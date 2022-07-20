package pl.britenet.campus.command.all;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.object.Paginator;
import pl.britenet.campus.service.CartService;

import java.util.List;

public class AllCartCommand extends Command {

    private final CartService cartService;
    private Cart cart;

    public AllCartCommand (CartService cartService)
    {
        super(Constants.COMMAND_ALL_CART);
        this.cartService = cartService;

    }


    public void execute() {
        List<Cart> cartList = this.cartService.getCart();
//        cartList.forEach( product -> {
//                    System.out.println(product.getCartId() + product.getProductId());
//                }
//        );
        String labels = "POGCHAMPOWE NAZWY PUL";
        Paginator<Cart> jd = new Paginator<>(cartList, 5, labels);
        jd.Paginate();
    }
}
