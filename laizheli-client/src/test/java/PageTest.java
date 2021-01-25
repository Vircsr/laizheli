import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.ClientApplication;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.mapper.GoodsMapper;
import com.travel.laizheli.service.IGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页功能测试类
 * create by chen on 2021/1/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
public class PageTest {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private IGoodsService IGoodsService;

    @Test
    public void printGoodsPage(){
        System.out.println("--------------goods page---------");
        Page<Goods> page = new Page<>(1,5);
        IPage<Goods> result = goodsMapper.selectPage(page, Wrappers.<Goods>lambdaQuery().orderByDesc(Goods::getVisits));
        System.out.println("总页数：");
        System.out.println("总记录数：");
        result.getRecords().forEach(System.out::println);
    };

    @Test
    public void printServicePaege(){
        System.out.println("-------------service page------------------------");
//        IPage<Goods> result = IGoodsService.getGoodsList(1,10, "1");
//        result.getRecords().forEach(System.out::println);
    }

    @Test
    public void selectById(){
        System.out.println("-------------id------------");
        Goods good = goodsMapper.selectById(1111);
        System.out.println(good);
    }
    @Test
    public void selectList(){
        System.out.println("-------------list------------");
        List<Goods> list = goodsMapper.selectList(new QueryWrapper<Goods>().orderByDesc("visits"));
        list.forEach(System.out::println);
    }

    @Test
    public void sqlTest(){
        System.out.println("-------------test------------");
        Page<GoodsList> page = new Page<>(1,5);
        IPage<GoodsList> result = goodsMapper.selectGoodsPage(page,"1");
        result.getRecords().forEach(System.out::println);
    }
}
