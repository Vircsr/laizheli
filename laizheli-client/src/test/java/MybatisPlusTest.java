import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.ClientApplication;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.service.impl.CollectionService;
import com.travel.laizheli.service.impl.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TODO
 * create by chen on 2021/2/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class MybatisPlusTest {
    @Resource
    CollectionService collectionService;
    @Resource
    OrdersService ordersService;
    @Test
    public void testCount(){
        System.out.println(collectionService.getCollectionCount("o_BW85YRWdyprKKgJuvGWhn6jTTw"));
    }
    @Test
    public void timeTest(){
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date(System.currentTimeMillis());
        ca.setTime(now);
        ca.add(Calendar.DATE,-7);
        Date eWeek = ca.getTime();
        System.out.println("early one week: "+ format.format(eWeek));
        System.out.println("now: "+ format.format(now));
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.between("start_date",eWeek,now);

        List<Orders> list = ordersService.getBaseMapper().selectList(wrapper);
        list.forEach(System.out::println);
    }
}
