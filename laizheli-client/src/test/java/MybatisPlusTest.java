import com.travel.laizheli.ClientApplication;
import com.travel.laizheli.service.impl.CollectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * TODO
 * create by chen on 2021/2/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class MybatisPlusTest {
    @Resource
    CollectionService collectionService;
    @Test
    public void testCount(){
        System.out.println(collectionService.getCollectionCount("o_BW85YRWdyprKKgJuvGWhn6jTTw"));
    }
}
