package pl.britenet.campus.object;

public class Images {
    private final int ImageId;

    private String picture;

    private int CustomerId;

    private int ProductId;

    public Images(int imageId, String picture, int customerId, int productId) {
        ImageId = imageId;
        this.picture = picture;
        CustomerId = customerId;
        ProductId = productId;
    }

    public Images(int imageId) {
        this.ImageId = imageId;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
}
