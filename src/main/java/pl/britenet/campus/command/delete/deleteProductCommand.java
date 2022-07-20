package pl.britenet.campus.command.delete;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.text.ParseException;
import java.util.Scanner;

public class deleteProductCommand extends Command {

    private final ProductService productService;
    private Product product;

    public deleteProductCommand(ProductService productService) {
        super(Constants.COMMAND_DELETE_PRODUCT);
        this.productService = productService;

    }

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CartId");

        this.productService.deleteProduct(scanner.nextInt());

    }
}
