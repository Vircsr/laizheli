import com.travel.laizheli.AgentApplication;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.entity.result.SumMonth;
import com.travel.laizheli.mapper.OrderMappper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OrderTest
 * @Description: 订单测试
 * @Author: Wangcb
 * @Date: 2021/1/26 22:55
 * @Version: 1.0
 **/
@Slf4j
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

    @Test
    public void getOrders(){
        List<Orders> get = orderMappper.getByQuery("111",null,null,null,"1","a",1,5);
        System.out.println(get);
    }

    @Test
    public void getSumMonth() {
//        // 获取当前月份
//        int month = LocalDate.now().getMonthValue()-1;
//        log.info("这个月是："+month);
//        ArrayList<BigDecimal> result = new ArrayList<>();
//        result.add(new BigDecimal("0"));
//        result.add(new BigDecimal("0"));
//        result.add(new BigDecimal("0"));
//        result.add(new BigDecimal("0"));
//        result.add(new BigDecimal("0"));
//        List<SumMonth> list = new ArrayList<>();
//        list = orderMappper.getSumMonth();
//        for (SumMonth item : list) {
//            if (item.getCreateTime().getMonth()==(month+12)%12){
//                result.set(4,result.get(4).add(item.getSum()));
//            }
//            if (item.getCreateTime().getMonth()==(month-1+12)%12){
//                result.set(4,result.get(4).add(item.getSum()));
//            }
//            if (item.getCreateTime().getMonth()==(month-2+12)%12){
//                result.set(2,result.get(2).add(item.getSum()));
//            }
//            if (item.getCreateTime().getMonth()==(month-3+12)%12){
//                result.set(1,result.get(1).add(item.getSum()));
//            }
//            if (item.getCreateTime().getMonth()==(month-4+12)%12){
//                result.set(0,result.get(0).add(item.getSum()));
//            }
//        }
//        System.out.println(result.toString());
        // 设置显示的日期
        List<String> labels = new ArrayList<String>();
        // 获取当前月份
        int month = LocalDate.now().getMonthValue()-1;
        for(int i=4;i>=0;i--){
            labels.add(String.valueOf((month+12-i)%12+1)+"月");
        }
        System.out.println(labels.toString());
    }
}
