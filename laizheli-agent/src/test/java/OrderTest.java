import com.travel.laizheli.AgentApplication;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.mapper.OrderMappper;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: OrderTest
 * @Description: 订单测试
 * @Author: Wangcb
 * @Date: 2021/1/26 22:55
 * @Version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AgentApplication.class)
public class OrderTest {

    @Resource
    private OrderMappper orderMappper;

    @Test
    public void dateReduce(){
        Orders one = orderMappper.selectById(1);
        Orders two = orderMappper.selectById(2);

        int dayOne = one.getCreateTime().getDay();
        int dateOne = one.getCreateTime().getDate();
        System.out.println("one-date:"+dateOne);
        int dayTwo = two.getCreateTime().getDay();
        int dateTwo = two.getCreateTime().getDate();
        System.out.println("two_date:"+dateTwo);
        System.out.println("one-day:"+dayOne+"   "+"two-day:"+dayTwo);
    }
}
