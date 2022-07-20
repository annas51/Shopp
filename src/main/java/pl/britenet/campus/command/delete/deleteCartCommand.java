package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteCartCommand extends Command {
    private final CartService cartService;
    private Cart cart;

    public deleteCartCommand(CartService cartService) {
        super(Constants.COMMAND_DELETE_CART);
        this.cartService = cartService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CartId ");
        this.cartService.deleteCart(scanner.nextInt());

    }
}