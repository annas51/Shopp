package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

import java.util.Date;

public class Cart {
    private int CartId;
    private int CustomerId;
    private int ProductId;
    private int CartProductId;
    private Date CreatedAt;
    private int Total;
    @Override
    public String toString(){
        return this.CartId + " " + this.CustomerId + " " + this.ProductId + " " + this.CartProductId
                + " " + this.CreatedAt.toString() + " " + this.Total;
    }

   public Cart(int cartId) { this.CartId = cartId ;}
    public Cart() {
        this.CartId=Constants.INVALID_ID;
    }

    public int getCartId() {
        return CartId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getCartProductId() {
        return CartProductId;
    }

    public void setCartProductId(int cartProductId) {
        CartProductId = cartProductId;
    }

    public Date getCreatedAt() {
        return  CreatedAt;
    }

    public void setCreatedAt( Date createdAt) {
        CreatedAt = createdAt;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }


    public void setCartId(int cartId) {
        this.CartId = cartId;
    }
}
