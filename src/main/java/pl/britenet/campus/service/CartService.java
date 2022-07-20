package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Cart;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartService {

    private final DatabaseService databaseService;

    public CartService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Cart> getCart() {
        return this.databaseService.performSQL("SELECT * FROM cart", resultSet -> {
            List<Cart> cartList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Cart cart = new Cart(resultSet.getInt("CartId"));
                    cart.setCustomerId(resultSet.getInt("CustomerId"));
                    cart.setProductId(resultSet.getInt("ProductId"));
                    cart.setCartProductId(resultSet.getInt("CartProductId"));
                    cart.setCreatedAt(resultSet.getDate("createdAt"));
                    cart.setTotal(resultSet.getInt("Total"));

                    cartList.add(cart);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartList;
        });
    }

    public Optional<Cart> getCart(int id) {
        Cart retrievedCart = this.databaseService.performSQL(String.format("SELECT * FROM cart WHERE CartId = %d", id),
                resultSet -> {
                    try {
                        if (resultSet.next()) {
                            Cart cart = new Cart(resultSet.getInt("CartId"));
                            cart.setCustomerId(resultSet.getInt("CustomerId"));
                            cart.setProductId(resultSet.getInt("ProductId"));
                            cart.setCartProductId(resultSet.getInt("CartProductId"));
                            cart.setTotal(resultSet.getInt("Total"));
                            return cart;
                        }
                    } catch (SQLException exception) {
                        throw new IllegalStateException(exception);
                    }
                    return null;
                });

        return Optional.of(retrievedCart);
    }

    public void deleteCart(int id) {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format("DELETE FROM Cart WHERE CartId = %d", id));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }

    public void AddCart(Cart cart) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.databaseService.performDML(String.format("INSERT INTO Cart (CustomerId, ProductId, CreatedAt, Total) VALUES(%d, %d, '%s', %d) ", cart.getCustomerId(),
                cart.getProductId(), df.format(cart.getCreatedAt()), cart.getTotal()));
    }
    public void updateCart(Cart cart) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.databaseService.performDML(String.format("UPDATE cart SET  CustomerId= %d, ProductId=%d, cartProductId=%d " +
                        ", createdAt='%s', Total=%d  WHERE CartId = %d", cart.getCustomerId(), cart.getProductId(), cart.getCartProductId(),
                df.format(cart.getCreatedAt()), cart.getTotal(), cart.getCartId()));

    }

}