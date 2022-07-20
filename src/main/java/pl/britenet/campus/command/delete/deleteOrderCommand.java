package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Orderx;
import pl.britenet.campus.service.OrderService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteOrderCommand extends Command {
    private final OrderService orderService;
    private Orderx orderx;

    public deleteOrderCommand(OrderService orderService) {
        super(Constants.COMMAND_DELETE_ORDER);
        this.orderService = orderService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter OrderId ");
        this.orderService.deleteOrder(scanner.nextInt());

    }
}
