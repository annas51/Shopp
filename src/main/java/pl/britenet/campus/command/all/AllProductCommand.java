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
                    List<Product> productList = this.productService.getProduct();
                  /*  productList.forEach( product -> {
                        System.out.println(product.getName());
                    }
                    );*/
                    String labels = "POGCHAMPOWE NAZWY PUL";
                    Paginator<Product> jd = new Paginator<>(productList, 5, labels);
                    jd.Paginate();
                 }
        }