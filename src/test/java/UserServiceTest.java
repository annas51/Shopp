import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.util.List;

public class UserServiceTest {
    private CustomerService customerService;

    @BeforeEach
    public void setup(){
        this.customerService = new CustomerService(new DatabaseService());
    }
    @Test
    public void Test123(){
        assert !this.customerService.getCustomer().isEmpty();
    }
    @Test
    public void getProductTest() {
        Customer customer = new Customer( 1,"Jan","Kowalski","halinka",456789321,5,5);
        customerService.addCustomer(customer);
        List<Customer> newlist  = customerService.getCustomer();
        assert this.customerService.getCustomer(newlist.get(newlist.size()-1).getCustomerId()).isPresent();

    }


}
