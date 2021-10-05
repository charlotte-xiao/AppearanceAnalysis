package cn.xiaostudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 本地存储配置
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "upload.local")
public class LocalConfig implements WebMvcConfigurer {

    /**
     * 真实路径文件访问协议名
     */
    private static final String PATH_CONST = "file:";

    /**
     * 本地服务器地址
     */
    private String url;

    /**
     * 前缀路径
     */
    private String path;

    /**
     * 映射路径
     */
    private String mapPath;

    /**
     * 真实路径
     */
    private String realPath;

    /**
     * 映射路径到真实路径
     * @param registry 资源映射注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(mapPath).addResourceLocations(PATH_CONST+realPath);
    }
}
