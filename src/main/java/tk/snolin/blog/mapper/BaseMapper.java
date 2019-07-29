package tk.snolin.blog.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.Tag;

import java.util.List;

@Repository
public interface BaseMapper {

    /**
     *
     * 由于分页插件pagehelper不支持一对多映射查询，所以要先把blogMain查询出来，再根据id查询tag
     *
     *
     * */
    List<BlogMain> selectAllBlogMain();

    /**
     *
     *
     *根据blogId查询tag
     *
     *
     * */
    List<Tag> selectTagByBlogId(@Param("blogId") int blogId);
    /***
     *
     * 根据id查询博客以及tag
     *
     * **/
    BlogMain selectBlogById(@Param("blogId") int id);
}
