package tk.snolin.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.Tag;
import tk.snolin.blog.mapper.AdminMapper;
import tk.snolin.blog.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private AdminMapper mapper;

    @Autowired
    private BaseMapper baseMapper;

    @Test
    public void contextLoads() {
    }


    /*
    * 统计总文章数
    *
    * */
    @Test
    public void TestCount(){
        int count = mapper.selectCountBlog();
        System.out.println(count);
    }

    //测试mybatis保存博客
    /*@Test
    public void testMybatis(){
        Tag tag = new Tag();
        tag.setTag("java");
        System.out.println(mapper.insertTag(tag));
    }*/

   /* @Test
    public void testSelect(){
        Tag tag = new Tag();
        tag.setTag("java");
        System.out.println();
        Tag t = mapper.SelectTagByTagName(tag);
        Assert.notNull(t,"查看是否查出数据");
    }*/


   /*
   *
   * */
   /*@Test
   public void testGetAll(){
       List<BlogMain> bs = mapper.getAllBlogMain();
       for (BlogMain bg: bs) {
           System.out.println(bg.getTitle());
       }
   }*/
   /*
   /**
    * 测试多表查询
    * */
   /*
   @Test
   public void testMultSelect(){
       List<BlogMain> bs = mapper.getAllBlog();
       for(BlogMain bg:bs){
           System.out.println(bg.getTagList());
       }

   }*/
   @Test
    public void test123(){
       BlogMain blog = baseMapper.selectBlogById(20);
       System.out.println(blog.getId());
       System.out.println(blog.getTitle());
       System.out.println(blog.getText());
       System.out.println(blog.getCreateTime());
       System.out.println(blog.getTagList());
   }
}
