package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final DatabaseService databaseService;
    private Customer CustomerPass;

    public CustomerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Customer> getCustomer() {
        return this.databaseService.performSQL("SELECT * FROM Customer", resultSet -> {
            List<Customer> customerList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("CustomerId"));
                    customer.setEmail(resultSet.getString("Email"));
                    customer.setCustomerName(resultSet.getString("CustomerName"));
                    customer.setLastName(resultSet.getString("LastName"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhoneNr(resultSet.getInt("PhoneNr"));

                    customerList.add(customer);

                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return customerList;
        });
    }

    public Optional<Customer> getCustomer(int id) {
        Customer getCustomer = this.databaseService.performSQL(String.format("SELECT * FROM Customer WHERE CustomerId = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("CustomerId"));
                    customer.setEmail(resultSet.getString("Email"));
                    customer.setCustomerName(resultSet.getString("CustomerName"));
                    customer.setLastName(resultSet.getString("LastName"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhoneNr(resultSet.getInt("PhoneNr"));

                    return customer;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(getCustomer);
    }
    public void  addCustomer (Customer customer)
    {
        this.databaseService.performDML(String.format("INSERT INTO Customer (Email, CustomerName, LastName, Address, PhoneNr, password) VALUES('%s', '%s', '%s', '%s', %d, '%s')",
           customer.getEmail(),  customer.getCustomerName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNr(), customer.getPassword()));
    }
    public void deleteCustomer(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format( "DELETE FROM Customer WHERE CustomerId = %d", id ));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }
    public void updateCustomer(Customer customer) {
        this.databaseService.performDML(String.format("UPDATE Customer SET Email = '%s', CustomerName = '%s'" +
                        ", LastName='%s' , Address='%s', PhoneNr=%d WHERE CustomerId=%d",
               customer.getEmail(), customer.getCustomerName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNr(), customer.getCustomerId()));
    }


    public Optional<Customer> getCustomerPass(String email, String password) {
        Customer getCustomerPass = this.databaseService.performSQL(String.format("SELECT * FROM Customer WHERE Email = '%s' AND password = '%s' ",email, password), resultSet -> {
            try {
                if (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("CustomerId"));
                    customer.setEmail(resultSet.getString("Email"));
                    customer.setCustomerName(resultSet.getString("CustomerName"));
                    customer.setLastName(resultSet.getString("LastName"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhoneNr(resultSet.getInt("PhoneNr"));
                    customer.setPassword(resultSet.getString("password"));



                    return customer;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(getCustomerPass);
    }
}
