package tk.snolin.blog.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.snolin.blog.entity.Blog;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.BlogTag;
import tk.snolin.blog.entity.Tag;

import java.util.List;

@Repository
public interface AdminMapper {
    /**
     * @param blogMain
     *
     * */
    @Insert("insert into blog(title,text,create_time)values (#{title},#{text},#{createTime,jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
    void insertBlog(BlogMain blogMain);
    /**
     *
     * @param tag
     *
     * */
    @Insert("insert into tag(tag)values(#{tag})")
    @Options( useGeneratedKeys=true, keyProperty="id" ,keyColumn="id")
    void insertTag(Tag tag);
    /**
     * 插入tag和blog的关系表
     * @param blogMainId
     * @param tagId
     *
     * */
    @Insert("insert into blog_tag(blog_id,tag_id)values (#{blogId},#{tagId})")
    void insertBlogTag(@Param("blogId") int blogMainId, @Param("tagId") int tagId);

    @Select("select * from tag where tag = #{tag}")
    @ResultType(Tag.class)
    Tag SelectTagByTagName(Tag tag);
    /**
     *
     * 多表联合查询，获取所有BLOG
     *
     * */
    List<BlogMain> getAllBlog();

    /**
     *
     * 根据id删除博客
     *
     * */
    @Delete("delete from blog where id = #{blogId}")
    int deleteBlogById(@Param("blogId") int id);
    /**
     *
     * 根据BlogId来删除BlogTag
     *
     * */
    @Delete("delete from blog_tag where blog_id = #{BlogId}")
    int deleteBlogTagByBlogId(@Param("BlogId") int blogId);
    /**
     *
     * 根据id来更新博客(主体)
     *
     * */
    @Update("update blog set title = #{title},text=#{text} where id = #{id}")
    int updateBlogById(BlogMain blogMain);

    /**
     *
     * 统计博客总数
     *
     * */
    @Select("select count(*) as count from blog")
    @ResultType(Integer.class)
    int selectCountBlog();

}
