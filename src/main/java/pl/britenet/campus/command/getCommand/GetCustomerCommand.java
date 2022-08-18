package pl.britenet.campus.command.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.util.Optional;
import java.util.Scanner;

public class GetCustomerCommand extends Command {
    private final CustomerService customerService;

    public GetCustomerCommand(CustomerService customerService) {
        super(Constants.COMMAND_GET_CUSTOMER);
        this.customerService = customerService;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String CustomerId = scanner.nextLine();
        Optional<Customer> customer = this.customerService.getCustomer(Integer.parseInt(CustomerId));
        customer.ifPresent(value ->
                System.out.println("CustomerId: " + String.valueOf(value.getCustomerId()) + ", " +
                                         "Email: " + String.valueOf(value.getEmail()) + ", " +

                            "Name: " + String.valueOf(value.getCustomerName()) + ", " +
                                        "LastName: " +String.valueOf( value.getLastName()) + ", " +
                                        "Address: " + String.valueOf(value.getAddress()) + ", "+
                                        "PhoneNr: " + String.valueOf(value.getPhoneNr()) + ", " +
                                            "CartId: " + String.valueOf(value.getCartId()) + ", " +
                                        "OrderId: " + String.valueOf(value.getOrderId()))) ;

    }
}
