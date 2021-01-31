import com.travel.laizheli.ClientApplication;
import com.travel.laizheli.entity.User;
import com.travel.laizheli.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

/**
 * User测试类
 * create by chen on 2021/1/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class UserTest {
//    @Autowired
//    private UserMapper userMapper;

//    @Test
//    public void printUser(){
//        System.out.println("----------all user-----------");
//        List<User> userList = userMapper.selectList(null);
////        Assert.assertEquals(5,userList.size());
//        userList.forEach(System.out::println);
//    }

//    @Test
//    public void testRandom() {
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//
//            double nextDouble = random.nextDouble();
//
//            BigDecimal bigDecimal = new BigDecimal(nextDouble * 10).setScale(2, RoundingMode.HALF_UP);
//            System.out.println(bigDecimal);
//
//        }
//    }
}
