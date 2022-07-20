package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.service.CartProductService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteCartProductCommand extends Command {
    private final CartProductService cartProductService;
    private CartProduct cartProduct;

    public deleteCartProductCommand(CartProductService cartProductService) {
        super(Constants.COMMAND_DELETE_CARTPRODUCT);
        this.cartProductService = cartProductService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CartId ");
        this.cartProductService.deleteCartProduct(scanner.nextInt());

    }
}
