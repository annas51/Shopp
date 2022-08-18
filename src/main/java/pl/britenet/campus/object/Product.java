package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class Product {


    private final int ProductId;
    private int OrderProductId;
    private String Name;
    private String Description;
    private double Price;
    private int Quantity;
    private int CartProductId;
    private int imageId;
    private Images images;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Product(int productId) {
        ProductId = productId;
    }


  public Product(int productId, int i, String test, String s) {this.ProductId = productId; }

    public Product() {
        this.ProductId=Constants.INVALID_ID;
    }


    public int getProductId() {
        return ProductId;
    }

    public int getOrderProductId() {
        return OrderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        OrderProductId = orderProductId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public int getCartProductId() {
        return CartProductId;
    }

    public void setCartProductId(int cartProductId) {
        CartProductId = cartProductId;
    }


}
