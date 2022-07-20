package pl.britenet.campus.command.getCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class GetProductCommand extends Command {

    private final ProductService productService;

    public GetProductCommand(ProductService productService) {
        super(Constants.COMMAND_GET_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String ProductId = scanner.nextLine();
        Optional<Product> product = this.productService.getProduct(Integer.parseInt(ProductId));
        product.ifPresent(value ->
                System.out.println("ProductId: " + String.valueOf(value.getProductId()) + ", "+
                        String.valueOf("OrderProductId: "+ value.getOrderProductId()) + ", " +
                        String.valueOf("Name: " + value.getName()) + ", " +
                        String.valueOf("Description: " + value.getDescription()) + ", " +
                        String.valueOf("Price: " + value.getPrice()) + ", " +
                        String.valueOf("Quantity: " + value.getQuantity()) + ", " +
                        String.valueOf("CartProductId: " + value.getCartProductId())));
    }
}

