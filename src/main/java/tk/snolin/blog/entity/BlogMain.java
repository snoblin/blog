package tk.snolin.blog.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 映射blog表
 *
 * */
@Data
public class BlogMain {
    private int id;
    private String title;
    private String text;
    private Date createTime;
    private List<Tag> tagList;
}
