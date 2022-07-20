package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Customer {
    private int CustomerId;
    private String CustomerName;
    private String LastName;
    private String Address;
    private int PhoneNr;
    private int CartId;
    private String password;
    private int OrderId;

    public String toString(){
        return this.CustomerId + " " + this.CustomerName + " " + this.LastName + " " + this.Address
                + " " + this.PhoneNr + " " + this.CartId + "" + this.OrderId + "" + this.password;
    }

    public Customer(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getCustomername(String customername) {this.CustomerName = String.valueOf(customername);
    }

    ;


    public Customer(int customerId) {
        this.CustomerId = customerId;
    }
    public Customer() {
        this.CustomerId= Constants.INVALID_ID;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return CustomerName;
    }

    public void setName(String customerName) {
        CustomerName = customerName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNr() {
        return PhoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        PhoneNr = phoneNr;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public Customer(int customerId, String customerName, String lastName, String address, int phoneNr, int cartId, int orderId) {
        CustomerId = customerId;
        CustomerName = customerName;
        LastName = lastName;
        Address = address;
        PhoneNr = phoneNr;
        CartId = cartId;
        OrderId = orderId;
    }
}
