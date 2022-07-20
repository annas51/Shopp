package pl.britenet.campus.command.updateCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Scanner;

public class updateProductCommand extends Command {

    private final ProductService productService;
    private Product product;

    public updateProductCommand(ProductService productService) {
        super(Constants.COMMAND_UPDATE_PRODUCT);
        this.productService = productService;
    }


    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ProductId:");
        int id = Integer.parseInt(scan.nextLine());
        final Product[] product = {new Product()};
        this.productService.getProduct(id).ifPresent(value ->
                product[0] = value);

        Product temp = product[0];
        System.out.println("Name:");
        temp.setName(scan.nextLine());
        System.out.println("Description:");
        temp.setDescription(scan.nextLine());
        System.out.println("Price:");
        temp.setPrice(Double.parseDouble(scan.nextLine()));
        System.out.println("Quantity:");
        temp.setQuantity(scan.nextInt());

        this.productService.updateProduct(temp);

    }
}