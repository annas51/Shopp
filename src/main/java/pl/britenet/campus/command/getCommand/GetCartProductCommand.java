package pl.britenet.campus.command.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.service.CartProductService;


import java.util.Optional;
import java.util.Scanner;

public class GetCartProductCommand extends Command {
    private final CartProductService cartProductService;

    public GetCartProductCommand(CartProductService cartProductService) {
        super(Constants.COMMAND_GET_CART_PRODUCT);
        this.cartProductService = cartProductService;


    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String CartProductId = scanner.nextLine();
        Optional<CartProduct> cart = this.cartProductService.getCartProduct(Integer.parseInt(CartProductId));
        cart.ifPresent(value ->
                System.out.println("CartProductId: " + String.valueOf(value.getCartProductId()) + ", " +
                        String.valueOf("CartId: " + value.getCartId()) + ", " +
                        String.valueOf("ProductId: " +value.getProductId()) + ", " +
                        String.valueOf("Quantity: " +value.getQuantity())));

    }
}

