package pl.britenet.campus.command.add;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AddCartCommand extends Command {

    private Cart cart;
    private final CartService cartService;

    public AddCartCommand(CartService cartService) {
        super(Constants.COMMAND_ADD_CART);
        this.cartService = cartService;
        this.cart = new Cart();
    }


    @Override
    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CustomerId: ");
        this.cart.setCustomerId(scanner.nextInt());

        System.out.println("Enter ProductId: ");
        this.cart.setProductId(scanner.nextInt());
        this.cart.setCreatedAt(new Date());


        System.out.println("Enter Total: ");
        this.cart.setTotal(scanner.nextInt());

        this.cartService.AddCart(this.cart);




        System.out.println(" CustomerId " + this.cart.getCustomerId() + " ProductId " +
                this.cart.getProductId() );

    }
}
