package pl.britenet.campus.command.updateCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Orderx;
import pl.britenet.campus.service.OrderService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class updateOrderCommand extends Command {

    private final OrderService orderService;
    private Orderx orderx;

    public updateOrderCommand(OrderService orderService) {
        super(Constants.COMMAND_UPDATE_ORDER);
        this.orderService = orderService;

    }

    public void execute() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("ID:");
        int id = Integer.parseInt(scan.nextLine());
        final Orderx[] orderx = {new Orderx()};
        this.orderService.getOrder(id).ifPresent(value ->
                orderx[0] = value
        );
        Orderx temp = orderx[0];

        temp.setCreatedAt(new Date());
        System.out.println("ProductId");
        temp.setProductId(scan.nextInt());
        System.out.println("OrderProductId");
        temp.setOrderProductId(scan.nextInt());
        System.out.println("CustomerId");
        temp.setCustomerId(scan.nextInt());

        this.orderService.updateOrder(temp);
    }


}
