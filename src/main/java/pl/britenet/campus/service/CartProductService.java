package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.CartProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartProductService {

    private final DatabaseService databaseService;

    public CartProductService (DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<CartProduct> getCartProduct() {
        return this.databaseService.performSQL("SELECT * FROM cartProduct", resultSet -> {
            List<CartProduct> cartProductList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    CartProduct cartProduct = new CartProduct(resultSet.getInt("CartProductId"));
                    cartProduct.setCartId(resultSet.getInt("CartId"));
                    cartProduct.setProductId(resultSet.getInt("ProductId"));
                    cartProduct.setQuantity(resultSet.getInt("Quantity"));

                    cartProductList.add(cartProduct);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartProductList;
        });
    }

    public Optional<CartProduct> getCartProduct(int id) {
        CartProduct retrievedCartProduct = this.databaseService.performSQL(String.format("SELECT * FROM cartProduct WHERE CartProductId = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    CartProduct cartProduct = new CartProduct(resultSet.getInt("CartProductId"));
                    cartProduct.setCartId(resultSet.getInt("CartId"));
                    cartProduct.setProductId(resultSet.getInt("ProductId"));
                    cartProduct.setQuantity(resultSet.getInt("Quantity"));
                    return cartProduct;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCartProduct);
    }
    public void deleteCartProduct(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format("DELETE FROM CartProduct WHERE CartProductId = %d", id));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }
    public void  addCartProduct (CartProduct cartProduct)
    {
        this.databaseService.performDML(String.format("INSERT INTO cartProduct (CartId, ProductId, Quantity) VALUES(%d, %d, %d)", cartProduct.getCartId(),
                cartProduct.getProductId(), cartProduct.getQuantity()));    }
}


