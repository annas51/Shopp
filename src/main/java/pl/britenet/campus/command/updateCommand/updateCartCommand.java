package pl.britenet.campus.command.updateCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class updateCartCommand extends Command {

    private final CartService cartService;
    private Cart cart;

    public updateCartCommand(CartService cartService) {
        super(Constants.COMMAND_UPDATE_CART);
        this.cartService = cartService;
    }

    public void execute() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("CartID:");
        int id = Integer.parseInt(scan.nextLine());
        final Cart[] cart = {new Cart()};
        this.cartService.getCart(id).ifPresent(value ->
                cart[0] = value);



        Cart temp = cart[0];
        System.out.println("CustomerId");
        temp.setCustomerId(scan.nextInt());
        System.out.println("ProductId");
        temp.setProductId(scan.nextInt());
        System.out.println("cartProductId");
        temp.setCartProductId(scan.nextInt());
        temp.setCreatedAt(new Date());
        System.out.println("Total");
        temp.setTotal(scan.nextInt());

        this.cartService.updateCart(temp);
    }


}

