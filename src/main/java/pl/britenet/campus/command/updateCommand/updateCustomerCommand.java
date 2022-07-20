package pl.britenet.campus.command.updateCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.text.ParseException;
import java.util.Scanner;

public class updateCustomerCommand extends Command {
    private final CustomerService customerService;
    private Customer customer;

    public updateCustomerCommand(CustomerService customerService) {
        super(Constants.COMMAND_UPDATE_CUSTOMER);
        this.customerService = customerService;
    }

    public void execute() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("CustomerId:");
        int id = Integer.parseInt(scan.nextLine());
        final Customer[] customer = {new Customer()};
        this.customerService.getCustomer(id).ifPresent(value ->
                customer[0] = value);


        Customer temp = customer[0];
        System.out.println("Name");
        temp.setName(scan.nextLine());
        System.out.println("lastName");
        temp.setLastName(scan.nextLine());
        System.out.println("Address");
        temp.setAddress(scan.nextLine());
        System.out.println("PhoneNr");
        temp.setPhoneNr(scan.nextInt());



        this.customerService.updateCustomer(temp);
    }
}
