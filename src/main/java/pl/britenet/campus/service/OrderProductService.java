package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.OrderProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderProductService {

    private final DatabaseService databaseService;

    public OrderProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<OrderProduct> getOrderProduct() {
        return this.databaseService.performSQL("SELECT * FROM OrderProduct", resultSet -> {
            List<OrderProduct> orderProductList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    OrderProduct orderProduct = new OrderProduct(resultSet.getInt("OrderProductId"));
                    orderProduct.setPrice(resultSet.getInt("Price"));
                    orderProduct.setQuantity(resultSet.getInt("Quantity"));
                    orderProduct.setProductId(resultSet.getInt("ProductId"));
                    orderProductList.add(orderProduct);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return orderProductList;
        });
    }

    public Optional<OrderProduct> getOrderProduct(int id) {
        OrderProduct retrievedOrderProduct = this.databaseService.performSQL(String.format("SELECT * FROM OrderProduct WHERE OrderProductId = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    OrderProduct orderProduct = new OrderProduct(resultSet.getInt("OrderProductId"));
                    orderProduct.setPrice(resultSet.getInt("Price"));
                    orderProduct.setQuantity(resultSet.getInt("Quantity"));
                    orderProduct.setProductId(resultSet.getInt("ProductId"));
                    return orderProduct;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrderProduct);
    }
    public void deleteOrderProduct(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format( "DELETE FROM Orderx WHERE OrdersId = %d", id ));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }
}

