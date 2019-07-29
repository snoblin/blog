package tk.snolin.blog.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * 图片上传服务器的返回结果
 *
 *
 * */
@Data
public class PictureResult {
    private int errno;
    private ArrayList<String> data;
}
