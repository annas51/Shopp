package pl.britenet.campus.command.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Orderx;
import pl.britenet.campus.service.OrderService;

import java.util.Optional;
import java.util.Scanner;
    public class GetOrderCommand extends Command {
        private final OrderService orderService;

        public GetOrderCommand(OrderService orderService) {
            super(Constants.COMMAND_GET_ORDER);
            this.orderService = orderService;


        }

        @Override
        public void execute() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter id:");
                String OrdersId = scanner.nextLine();
                Optional<Orderx> orderProduct = this.orderService.getOrder(Integer.parseInt(OrdersId));
                orderProduct.ifPresent(value ->
                        System.out.println("OrdersId: " + String.valueOf(value.getOrdersId()) + ", " +
                                String.valueOf("CreatedAt: " + value.getCreatedAt()) + ", " +
                                String.valueOf("ProductId: " + value.getProductId()) + ", " +
                                String.valueOf("OrderProductId: " + value.getOrderProductId()) + ", " +
                                String.valueOf("CustomerId: " + value.getCustomerId())));

            }
        }
