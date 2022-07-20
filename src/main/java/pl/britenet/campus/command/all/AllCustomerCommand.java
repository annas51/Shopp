package pl.britenet.campus.command.all;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.object.Paginator;
import pl.britenet.campus.service.CustomerService;

import java.util.List;

public class AllCustomerCommand extends Command {

        private final CustomerService customerService;
        private Customer customer;

        public AllCustomerCommand (CustomerService customerService)
        {
            super(Constants.COMMAND_ALL_CUSTOMER);
            this.customerService = customerService;
        }

        public void execute() {
           List<Customer> customerList = this.customerService.getCustomer();
        /*    customerList.forEach( customer -> {
                System.out.println(customer.getName() + customer.getLastName() + customer.getPhoneNr()); }
            );*/
            String labels = "POGCHAMPOWE NAZWY PUL";
            Paginator<Customer> jd = new Paginator<>(customerList, 5, labels);
            jd.Paginate();
        }
}


