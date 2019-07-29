package tk.snolin.blog.serviceimpl;

import com.github.pagehelper.PageInfo;
import tk.snolin.blog.entity.BlogMain;



public interface BaseService {
    /**
     *
     * 分页查询,返回查询结果
     *
     * */
    PageInfo<BlogMain> getPageContent(int currentPage, int pageSize);

    /**
     *
     * 根据blogId查询返回博客和对应的tag
     *
     *
     * */
    BlogMain selectBlogById(int id);
}
