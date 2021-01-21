import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.ClientApplication;
import com.travel.laizheli.Entity.Goods;
import com.travel.laizheli.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 分页功能测试类
 * create by chen on 2021/1/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class PageTest {
    @Resource
    private GoodsMapper goodsMapper;

    @Test
    public void printGoodsPage(){
        System.out.println("--------------goods page---------");
        Page<Goods> page = new Page<>(1,5);
        IPage<Goods> result = goodsMapper.selectPage(page, Wrappers.<Goods>lambdaQuery().orderByDesc(Goods::getVisits));
        System.out.println("总页数：");
        System.out.println("总记录数：");
        result.getRecords().forEach(System.out::println);


    };
}