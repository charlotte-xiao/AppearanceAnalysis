package cn.xiaostudy.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * OSS存储配置
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.oss")
public class OssConfig {

    /**
     * oss域名
     */
    private String url;

    /**
     * 上传文件映射路径
     */
    private String path;

    /**
     * 终点
     */
    private String endpoint;

    /**
     * 访问密钥id
     */
    private String accessKeyId;

    /**
     * 访问密钥密码
     */
    private String accessKeySecret;

    /**
     * bucket名称
     */
    private String bucketName;

    /**
     * 获取OSSClient
     *
     */
    public OSS getOssClient(){
        return new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
    }

}
