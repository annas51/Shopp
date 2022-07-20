package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Orderx;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Orderx> getOrder() {
        return this.databaseService.performSQL("SELECT * FROM orderx", resultSet -> {
            List<Orderx> orderList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Orderx orderx = new Orderx(resultSet.getInt("OrdersId"));
                    orderx.setCreatedAt(resultSet.getDate("CreatedAt"));
                    orderx.setProductId(resultSet.getInt("ProductId"));
                    orderx.setCustomerId(resultSet.getInt("CustomerId"));
                    orderList.add(orderx);

                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return orderList;
        });
    }

    public Optional<Orderx> getOrder(int id) {
        Orderx retrievedOrderx = this.databaseService.performSQL(String.format("SELECT * FROM orderx WHERE OrdersId = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Orderx orderx = new Orderx(resultSet.getInt("OrdersId"));
                    orderx.setCreatedAt(resultSet.getDate("CreatedAt"));
                    orderx.setProductId(resultSet.getInt("ProductId"));
                    orderx.setCustomerId(resultSet.getInt("CustomerId"));
                    return orderx;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedOrderx);
    }

    public void AddOrderx(Orderx orderx) {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd");

        this.databaseService.performDML(String.format("INSERT INTO orderx (ProductId, CreatedAt, CustomerId) VALUES(%d, '%s', %d)",
                 orderx.getProductId(), df.format(orderx.getCreatedAt()),
                orderx.getCustomerId()));
    }

    public void deleteOrder(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format( "DELETE FROM Orderx WHERE OrdersId = %d", id ));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }

    public void updateOrder(Orderx orderx) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.databaseService.performDML(String.format("UPDATE orderx SET  CreatedAt= '%s', ProductId=%d " +
                        ", CustomerId=%d WHERE OrdersId = %d", df.format(orderx.getCreatedAt()), orderx.getProductId(),
                orderx.getCustomerId(), orderx.getOrdersId()));
    }
}

