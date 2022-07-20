package pl.britenet.campus.command.add;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Orderx;
import pl.britenet.campus.service.OrderService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
public class AddOrderx extends Command {
    private final OrderService orderService;
    private Orderx orderx;

    public AddOrderx(OrderService orderService) {
        super(Constants.COMMAND_ADD_ORDER);
        this.orderService = orderService;
        this.orderx = new Orderx();


    }


    @Override
    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ProductId: ");
        this.orderx.setProductId(scanner.nextInt());
        this.orderx.setCreatedAt(new Date());


        System.out.println("Enter CustomerId");
        this.orderx.setCustomerId(scanner.nextInt());

        System.out.println("Inserting order: ");
        System.out.println(" ProductId: " + this.orderx.getProductId() +
                " CustomerId: " + this.orderx.getCustomerId());

        this.orderService.AddOrderx(this.orderx);

    }
}