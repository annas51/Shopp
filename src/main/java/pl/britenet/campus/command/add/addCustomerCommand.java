package pl.britenet.campus.command.add;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.text.ParseException;
import java.util.Scanner;

public class addCustomerCommand extends Command {

    private Customer customer;
    private final CustomerService customerService;

    public addCustomerCommand(CustomerService customerService) {
        super(Constants.COMMAND_ADD_CUSTOMER);
        this.customerService = customerService;
        this.customer = new Customer();
    }


    @Override
    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Name: ");
        this.customer.setName(scanner.next());

        System.out.println("Enter LastName: ");
        this.customer.setLastName(scanner.next());

        System.out.println("Enter Address: ");
        this.customer.setAddress(scanner.next());

        System.out.println("Enter PhoneNr: ");
        this.customer.setPhoneNr(scanner.nextInt());

        this.customerService.addCustomer(this.customer);


        System.out.println(" Name: " + this.customer.getName() + " LastName: " +
                this.customer.getLastName() + "Address: " + this.customer.getAddress() + "PhoneNr: " +
                this.customer.getPhoneNr());

    }
}