package pl.britenet.campus.object;


public class CartProduct {
    private final int CartProductId;
    private int CartId;
    private int ProductId;
    private int Quantity;

    public CartProduct(int cartProductId) {

        this.CartProductId = cartProductId;
    }



    public int getCartProductId() {
        return CartProductId;
    }


    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
