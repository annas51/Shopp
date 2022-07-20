package pl.britenet.campus.command.groupingCommand;


import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.Grouping.CartCountService;

import java.text.ParseException;
import java.util.Map;

public class CartCountCommand extends Command {
    private final CartCountService cartCountService;


    public CartCountCommand(CartCountService cartCountService) {
        super(Constants.COMMAND_COUNT_CART);
        this.cartCountService = cartCountService;

    }


    public void execute() throws ParseException {
        Map<Integer, Integer> cartCount = cartCountService.getCartCount();
        for (Map.Entry<Integer, Integer> entry: cartCount.entrySet()) {
            System.out.println("CustomerId: " + entry.getKey() + " Razem " + entry.getValue());
        }
    }
}
