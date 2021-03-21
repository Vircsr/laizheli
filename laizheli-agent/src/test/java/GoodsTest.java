//import com.travel.laizheli.AgentApplication;
//import com.travel.laizheli.common.api.Result;
//import com.travel.laizheli.entity.result.GoodsTop;
//import com.travel.laizheli.service.GoodsService;
//import com.travel.laizheli.util.SerializeUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.BoundListOperations;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName: GoodsTest
// * @Description: TODO
// * @Author: Wangcb
// * @Date: 2021/3/4 10:42
// * @Version: 1.0
// **/
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AgentApplication.class)
//@Slf4j
//public class GoodsTest {
//
//    @Resource
//    GoodsService goodsService;
//
//    @Resource
//    RedisTemplate redisTemplate;
//
//    @Test
//    public void getTop(){
//        List<GoodsTop> top = goodsService.getTop();
//        System.out.println(top.toString());
//        return;
//    }
//
//    @Test
//    public void hotspot(){
//        ListOperations listOperations = redisTemplate.opsForList();
//        Boolean hotspot = redisTemplate.hasKey("hotspot");
//        if (hotspot){
//            List<GoodsTop> list = listOperations.range("hotspot", 0, -1);
//            list.forEach(item -> System.out.println(item.getId()+item.getName()+item.getCount()));
//        }else {
//            List<GoodsTop> top = goodsService.getTop();
//            listOperations.rightPushAll("hotspot",top);
//            listOperations.getOperations().boundListOps("hotspot").expire(1, TimeUnit.HOURS);
//        }
//        return;
//    }
//
//}
