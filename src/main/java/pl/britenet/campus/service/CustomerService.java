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
                    customer.setName(resultSet.getString("CustomerName"));
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
                    customer.setName(resultSet.getString("CustomerName"));
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
        this.databaseService.performDML(String.format("INSERT INTO Customer (CustomerName, LastName, Address, PhoneNr) VALUES('%s', '%s', '%s', %d)",
             customer.getName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNr()));
    }
    public void deleteCustomer(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format( "DELETE FROM Customer WHERE CustomerId = %d", id ));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }
    public void updateCustomer(Customer customer) {
        this.databaseService.performDML(String.format("UPDATE customer SET CustomerName = '%s'" +
                        ", LastName='%s' , Address='%s', PhoneNr=%d WHERE CustomerId=%d",
                customer.getName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNr(), customer.getCustomerId()));
    }


    public Optional<Customer> getCustomerPass( String customername, String password) {
        Customer getCustomerPass = this.databaseService.performSQL(String.format("SELECT * FROM Customer WHERE CustomerName = '%s' AND password = '%s' ",customername, password), resultSet -> {
            try {
                if (resultSet.next()) {
                    Customer customer = new Customer(resultSet.getInt("CustomerId"));
                    customer.setName(resultSet.getString("CustomerName"));
                    customer.setLastName(resultSet.getString("LastName"));
                    customer.setAddress(resultSet.getString("Address"));
                    customer.setPhoneNr(resultSet.getInt("PhoneNr"));
                    customer.setPassword(resultSet.getString("Password"));



                    return CustomerPass;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(getCustomerPass);
    }
}
