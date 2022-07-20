package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

import java.util.Date;

public class Orderx {
    private final int OrdersId;
    private Date CreatedAt;
    private int ProductId;
    private int OrderProductId;
    private int CustomerId;

    public Orderx(int ordersId) {this.OrdersId = ordersId;}
    public Orderx() {
        this.OrdersId= Constants.INVALID_ID;
    }

    public int getOrdersId() {return OrdersId;} ;
    public Date getCreatedAt() {
         return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.CreatedAt = createdAt;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }

    public int getOrderProductId() {
        return OrderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.OrderProductId = orderProductId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        this.CustomerId = customerId;
    }


}
