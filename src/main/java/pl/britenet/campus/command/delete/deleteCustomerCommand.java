package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteCustomerCommand extends Command {
    private final CustomerService customerService;
    private Customer customer;

    public deleteCustomerCommand(CustomerService customerService) {
        super(Constants.COMMAND_DELETE_CUSTOMER);
        this.customerService = customerService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CartId ");
        this.customerService.deleteCustomer(scanner.nextInt());

    }

}
