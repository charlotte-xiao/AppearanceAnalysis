package cn.xiaostudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 人脸检测配置
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "predict.face")
public class FaceConfig {


    /**
     * 请求路径
     */
    private String url;

    /**
     * API KEY
     */
    private String apiKey;

    /**
     * API SECRET
     */
    private String apiSecret;

}
