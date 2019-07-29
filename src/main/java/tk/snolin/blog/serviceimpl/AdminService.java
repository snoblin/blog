package tk.snolin.blog.serviceimpl;

import tk.snolin.blog.entity.Blog;
import tk.snolin.blog.entity.BlogMain;

import java.util.List;

public interface AdminService {
    /**
     *
     * 保存博客
     *
     * */
    boolean saveBlog(Blog blog);
    /**
     *
     *
     * 获取所有
     *
     * */
    List<BlogMain> getAllBlog();
    /**
     *
     * 根据id删除博客
     *
     * */
    boolean deleteBlogById(int id);
    /**
     *
     * 根据id更新博客
     *
     * */
    boolean updateBlogById(Blog blog);

}
