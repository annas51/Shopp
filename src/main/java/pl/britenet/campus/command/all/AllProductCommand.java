package pl.britenet.campus.command.all;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Paginator;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.List;


        public class AllProductCommand extends Command {
                private final ProductService productService;
                private Product product;

                public AllProductCommand (ProductService productService)
                {
                    super(Constants.COMMAND_ALL_PRODUCT);
                    this.productService= productService;

                }

                public void execute() {
                    List<Product> productList = this.productService.getProducts();
                  /*  productList.forEach( product -> {
                        System.out.println(product.getName());
                    }
                    );*/
                    String labels = "Products";
                    Paginator<Product> productPaginator = new Paginator<>(productList, 5, labels);
                    productPaginator.Paginate();
                 }
        }