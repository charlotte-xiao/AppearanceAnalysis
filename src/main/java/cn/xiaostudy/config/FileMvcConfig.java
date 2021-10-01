package cn.xiaostudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@Configuration
public class FileMvcConfig implements WebMvcConfigurer {


    /**
     * 映射路径
     */
    public static String staticAccessPath = "/images/**";

    /**
     * 真实路径
     */
    public static String uploadFolder = "./images/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
    }
}
