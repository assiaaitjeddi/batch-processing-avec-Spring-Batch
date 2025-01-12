package ma.enset.batchprocessingavecspringbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderItemProcessor implements ItemProcessor<Order, Order> {

    @Override
    public Order process(Order order) throws Exception {
        System.out.println("Original Data : " + order);

        double discountedAmount = order.amount() * 0.9;
        Order discountedOrder = new Order(order.orderId(), order.customerName(), discountedAmount);
        return discountedOrder;
    }
}
