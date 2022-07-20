package pl.britenet.campus.command.add;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;
import java.text.ParseException;
import java.util.Scanner;

public class AddProductCommand extends Command {
        private final ProductService productService;
        private Product product;

    public AddProductCommand (ProductService productService)
        {
            super(Constants.COMMAND_ADD_PRODUCT);
            this.productService= productService;
            this.product = new Product();
        }


        @Override

    public void execute() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Name: ");
        this.product.setName(scanner.next());

        System.out.println("Enter Description: ");
        this.product.setDescription(scanner.next());

        System.out.println("Enter Price: ");
        this.product.setPrice(scanner.nextInt());

        System.out.println("Quantity : ");
        this.product.setQuantity(scanner.nextInt());

        this.productService.AddProduct(this.product);


        System.out.println(" Name: " + this.product.getName() +
                        " Description " + this.product.getDescription() +
                        " Price: " + this.product.getPrice() +
                        " Quantity: " + this.product.getQuantity());

    }
}
