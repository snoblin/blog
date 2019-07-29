package tk.snolin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.snolin.blog.entity.Blog;
import tk.snolin.blog.entity.BlogMain;
import tk.snolin.blog.entity.BlogTag;
import tk.snolin.blog.entity.Tag;
import tk.snolin.blog.mapper.AdminMapper;
import tk.snolin.blog.serviceimpl.AdminService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * @param blog
     * 将博客的标题和内容保存在一张表中
     * 将标签保存在单独的一张表
     * 用一张关系表描述多对多关系
     * 插入过程中查看标签是否重复，重复讲该条标签的id返回，不重复将新的标签插入返回新插入的标签的id值
     * */
    @Override
    public boolean saveBlog(Blog blog) {
        try {
            BlogMain blogMain = new BlogMain();
            blogMain.setTitle(blog.getTitle());
            blogMain.setText(blog.getText());
            blogMain.setCreateTime(new Date());
            adminMapper.insertBlog(blogMain);
            for(String tag:blog.getTags()){
                Tag newTag = new Tag();
                newTag.setTag(tag);
                Tag t = adminMapper.SelectTagByTagName(newTag);
                if(t!=null&&t.getTag().equals(tag)){
                    adminMapper.insertBlogTag(blogMain.getId(),t.getId());
                }else{
                    adminMapper.insertTag(newTag);
                    adminMapper.insertBlogTag(blogMain.getId(),newTag.getId());
                }

            }
            return true;
        }catch (Exception e){
            return false;
        }
    }



    /**
     *   获取博客标题和内容和对应的标签，封装成blog对象
     *
     * 所有all
     *
     * */
    @Override
    public List<BlogMain> getAllBlog() {
        return adminMapper.getAllBlog();
    }

    /**
     *
     * 根据id删除博客内容
     * 步骤：
     * 先查询blog_tag表
     *      查询对应的标签是否还有其他的博文在使用，
     *              如果没有使用，删除对应的标签，然后删除blog_tag对应的记录
     *              如果还有博文在使用，不删除标签，然后删除blog_tag表对应的记录
     * 最后删除blog表内的内容
     *
     * */
    @Override
    public boolean deleteBlogById(int id) {
        int blogTagCount = adminMapper.deleteBlogTagByBlogId(id);
        int blogCount = adminMapper.deleteBlogById(id);
        return blogCount>0&&blogTagCount>0;
    }
    /**
     *
     * 根据id来更新
     * 1.主体部分进行更新
     * 2.tag照常插入
     * 3.对应的blog_tag表先删除再插入
     *
    */
    @Override
    public boolean updateBlogById(Blog blog) {
        try {
            //先删除关联表中的所有链接
            adminMapper.deleteBlogTagByBlogId(blog.getId());
            //再进行更新
            BlogMain blogMain = new BlogMain();
            blogMain.setId(blog.getId());
            blogMain.setTitle(blog.getTitle());
            blogMain.setText(blog.getText());
            adminMapper.updateBlogById(blogMain);
            for (String tag : blog.getTags()) {
                Tag newTag = new Tag();
                newTag.setTag(tag);
                Tag t = adminMapper.SelectTagByTagName(newTag);
                if (t != null && t.getTag().equals(tag)) {
                    adminMapper.insertBlogTag(blogMain.getId(), t.getId());
                } else {
                    adminMapper.insertTag(newTag);
                    adminMapper.insertBlogTag(blogMain.getId(), newTag.getId());
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
