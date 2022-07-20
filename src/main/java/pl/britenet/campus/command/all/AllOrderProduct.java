package pl.britenet.campus.command.all;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.object.OrderProduct;
import pl.britenet.campus.object.Paginator;
import pl.britenet.campus.service.OrderProductService;

import java.util.List;

public class AllOrderProduct extends Command {
    private final OrderProductService orderProductService;
    private OrderProduct orderProduct ;

    public AllOrderProduct(OrderProductService orderProductService)
    {
        super(Constants.COMMAND_ALL_ORDERPRODUCT);
        this.orderProductService = orderProductService;
    }

    public void execute() {
        List<OrderProduct> orderProductList = this.orderProductService.getOrderProduct();
        /*orderProductList.forEach( customer -> {
                    System.out.println();
                }
        );*/
        String labels = "POGCHAMPOWE NAZWY PUL";
        Paginator<OrderProduct> jd = new Paginator<>(orderProductList, 5, labels);
        jd.Paginate();
    }
}
