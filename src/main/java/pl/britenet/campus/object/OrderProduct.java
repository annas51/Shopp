package pl.britenet.campus.object;

public class OrderProduct {
    private int OrderProductId;
    private int Price;
    private int Quantity;
    private int ProductId;

    public String toString(){
        return this.OrderProductId + " " + this.Price + " " + this.Quantity + " " + this.ProductId;
    }
    public OrderProduct(int orderproductId) {
        this.OrderProductId = orderproductId;
    }
    public int getOrderProductId() {return OrderProductId;}

    public int getOrderId() {
        return OrderProductId;
    }

    public int getPrice() {return Price;}

    public void setPrice(int price) {
        this.Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }
}
