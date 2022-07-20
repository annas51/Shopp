package pl.britenet.campus.service.Grouping;
import pl.britenet.campus.Constants;
import pl.britenet.campus.database.DatabaseService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartCountService {
    private final DatabaseService databaseService;
    private int CustomerId;

    public CartCountService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Map<Integer, Integer> getCartCount() {
        return this.databaseService.performSQL("SELECT cart.CustomerId, COUNT(cartproduct.ProductId) as Razem" +
                        " FROM cartProduct RIGHT JOIN cart ON cartproduct.CartId = cart.cartId " +
                        "GROUP BY cart.CustomerId;", resultSet -> {
            Map<Integer, Integer> cartCount = new HashMap<>();
            try {
                while (resultSet.next()) {
                    int CustomerId = resultSet.getInt("customerId");
                    int count = resultSet.getInt("Razem:");
                    cartCount.put(CustomerId, count);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartCount;


        });
    }

    public Map<Integer, Integer> getCustomer(int parseInt) {
        this.CustomerId= Constants.INVALID_ID;
        return null;
    }

}