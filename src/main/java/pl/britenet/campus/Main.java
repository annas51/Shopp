package pl.britenet.campus;

import pl.britenet.campus.command.Command;
import pl.britenet.campus.command.CommandList;
import pl.britenet.campus.command.ExitCommand;
import pl.britenet.campus.command.HelloCommand;
import pl.britenet.campus.command.add.AddCartCommand;
import pl.britenet.campus.command.add.AddOrderx;
import pl.britenet.campus.command.add.AddProductCommand;
import pl.britenet.campus.command.add.addCustomerCommand;
import pl.britenet.campus.command.all.AllCartCommand;
import pl.britenet.campus.command.all.AllCustomerCommand;
import pl.britenet.campus.command.all.AllOrderProduct;
import pl.britenet.campus.command.all.AllProductCommand;
import pl.britenet.campus.command.delete.*;
import pl.britenet.campus.command.getCommand.*;
import pl.britenet.campus.command.groupingCommand.CartCountCommand;
import pl.britenet.campus.command.groupingCommand.SumCommand;
import pl.britenet.campus.command.updateCommand.updateCartCommand;
import pl.britenet.campus.command.updateCommand.updateCustomerCommand;
import pl.britenet.campus.command.updateCommand.updateOrderCommand;
import pl.britenet.campus.command.updateCommand.updateProductCommand;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.service.*;
import pl.britenet.campus.service.Grouping.CartCountService;

import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        boolean isRunning = true;

        DatabaseService databaseService = new DatabaseService();

        ProductService productService = new ProductService(databaseService);
        CartService cartService = new CartService(databaseService);
        CartProductService cartProductService = new CartProductService(databaseService);
        OrderService orderService = new OrderService(databaseService);
        OrderProductService orderProductService = new OrderProductService(databaseService);
        CustomerService customerService = new CustomerService(databaseService);
        CartCountService cartCountService = new CartCountService(databaseService);



        CommandService commandService = new CommandService();

        commandService.registerCommand(new HelloCommand());
        commandService.registerCommand(new ExitCommand());


        commandService.registerCommand(new GetCartCommand(cartService));
        commandService.registerCommand(new GetCartProductCommand(cartProductService));
        commandService.registerCommand(new GetProductCommand(productService));
        commandService.registerCommand(new GetCustomerCommand(customerService));
        commandService.registerCommand(new GetOrderProductCommand(orderProductService));
        commandService.registerCommand(new GetOrderCommand(orderService));

        commandService.registerCommand(new AllProductCommand(productService));
        commandService.registerCommand(new AllCartCommand(cartService));
        commandService.registerCommand(new AllCustomerCommand(customerService));
        commandService.registerCommand(new AllOrderProduct(orderProductService));
         commandService.registerCommand(new CommandList(commandService));


        commandService.registerCommand(new AddProductCommand(productService));
        commandService.registerCommand(new addCustomerCommand(customerService));
        commandService.registerCommand(new AddOrderx(orderService));
        commandService.registerCommand(new AddCartCommand(cartService));

        commandService.registerCommand(new updateOrderCommand(orderService));
        commandService.registerCommand(new updateProductCommand(productService));
        commandService.registerCommand(new updateCartCommand(cartService));
        commandService.registerCommand(new updateCustomerCommand(customerService));



        commandService.registerCommand(new deleteCartCommand(cartService));
        commandService.registerCommand(new deleteCustomerCommand(customerService));
        commandService.registerCommand(new deleteOrderCommand(orderService));
        commandService.registerCommand(new deleteProductCommand(productService));
        commandService.registerCommand(new deleteOrderProductCommand(orderProductService));
        commandService.registerCommand(new deleteCartProductCommand(cartProductService));


        commandService.registerCommand(new CartCountCommand(cartCountService));

        commandService.registerCommand(new SumCommand());


        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Wprowadź komendę...");
            String command = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(command);
            oCommand.orElseThrow().execute();
        }
    }}