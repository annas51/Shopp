package pl.britenet.campus.command.getCommand;

import pl.britenet.campus.Constants;

import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.OrderProduct;
import pl.britenet.campus.service.OrderProductService;

import java.util.Optional;
import java.util.Scanner;

public class GetOrderProductCommand extends Command {
    private final OrderProductService orderProductService;

    public GetOrderProductCommand(OrderProductService orderProductService) {
        super(Constants.COMMAND_GET_ORDERPRODUCT);
        this.orderProductService = orderProductService;


    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String OrderProductId = scanner.nextLine();
        Optional<OrderProduct> orderProduct = this.orderProductService.getOrderProduct(Integer.parseInt(OrderProductId));
        orderProduct.ifPresent(value ->
                System.out.println("OrderProductId: " + String.valueOf(value.getOrderProductId()) + ", " +
                        String.valueOf("Price: " + value.getPrice()) + ", " +
                        String.valueOf("Quantity: " + value.getQuantity()) + ", " +
                        String.valueOf("ProductId: " + value.getProductId())));

    }
}

