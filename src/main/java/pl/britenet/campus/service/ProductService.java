package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Images;
import pl.britenet.campus.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Product> getProducts() {
        return this.databaseService.performSQL("SELECT * FROM product AS p LEFT JOIN image AS i on p.ImageId=i.ImageId", resultSet -> {
            List<Product> productList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getInt("p.ProductId"));
                    product.setOrderProductId(resultSet.getInt("p.OrderProductId"));
                    product.setName(resultSet.getString("p.Name"));
                    product.setDescription(resultSet.getString("p.Description"));
                    product.setPrice(resultSet.getDouble("p.Price"));
                    product.setQuantity(resultSet.getInt("p.Quantity"));

                    Images image = new Images(resultSet.getInt("i.ImageId"));
                    image.setPicture(resultSet.getString("i.picture"));
                    product.setImageId(resultSet.getInt("p.ImageId"));
                    product.setImages(image);

                    productList.add(product);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return productList;
        });
    }

    public Optional<Product> getProduct(int id) {
        Product getProduct = this.databaseService.performSQL(String.format("SELECT * FROM product AS p LEFT JOIN image AS i on p.ImageId=i.ImageId WHERE ProductId = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Product product = new Product(resultSet.getInt("ProductId"));
                    product.setOrderProductId(resultSet.getInt("OrderProductId"));
                    product.setName(resultSet.getString("Name"));
                    product.setDescription(resultSet.getString("Description"));
                    product.setPrice(resultSet.getDouble("Price"));
                    product.setQuantity(resultSet.getInt("Quantity"));
                    product.setCartProductId(resultSet.getInt("cartProductId"));
                    product.setImageId(resultSet.getInt("ImageId"));

                    Images image = new Images(resultSet.getInt("i.ImageId"));
                    image.setPicture(resultSet.getString("i.picture"));
                    product.setImageId(resultSet.getInt("p.ImageId"));
                    product.setImages(image);

                    return product;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(getProduct);
    }

    public void  AddProduct (Product product)
    {
        this.databaseService.performDML(String.format("INSERT INTO Product (Name, Description, Price, Quantity) VALUES('%s', '%s', " +product.getPrice() +", %d)",
                product.getName(), product.getDescription(), product.getQuantity()));
    }

    public void deleteProduct(int id)
    {
        this.databaseService.performDML("SET foreign_key_checks = 0");
        this.databaseService.performDML(String.format( "DELETE FROM Product WHERE ProductId = %d", id ));
        this.databaseService.performDML("SET foreign_key_checks = 1");
    }
    public void updateProduct(Product product) {
        this.databaseService.performDML(String.format("UPDATE product SET Name='%s', Description='%s', Price = "+product.getPrice()+", Quantity = %d" +
                        " WHERE ProductId = %d", product.getName(), product.getDescription(), product.getQuantity(), product.getProductId()));
    }

}