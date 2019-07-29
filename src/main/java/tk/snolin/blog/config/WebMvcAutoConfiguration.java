package tk.snolin.blog.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
public class WebMvcAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/js")
                .addResourceLocations("classpath:/static/css")
                .addResourceLocations("classpath:/static/fonts")
                .addResourceLocations("classpath:/templates/")
                .addResourceLocations("file:///G:/pictures/");
        registry.addResourceHandler("assets/")
                .addResourceLocations("classpath:/static/assets");
    }

}
