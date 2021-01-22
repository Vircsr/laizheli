//import com.travel.laizheli.ClientApplication;
//import com.travel.laizheli.Entity.User;
//import com.travel.laizheli.mapper.UserMapper;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * User测试类
// * create by chen on 2021/1/13
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ClientApplication.class)
//public class UserTest {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void printUser(){
//        System.out.println("----------all user-----------");
//        List<User> userList = userMapper.selectList(null);
////        Assert.assertEquals(5,userList.size());
//        userList.forEach(System.out::println);
//    }
//}
