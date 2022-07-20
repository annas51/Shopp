package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.OrderProduct;
import pl.britenet.campus.service.OrderProductService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteOrderProductCommand extends Command {
    private final OrderProductService orderProductService;
    private OrderProduct orderProduct;

    public deleteOrderProductCommand(OrderProductService orderProductService) {
        super(Constants.COMMAND_DELETE_ORDERPRODUCT);
        this.orderProductService = orderProductService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CartId ");
        this.orderProductService.deleteOrderProduct(scanner.nextInt());

    }
}
