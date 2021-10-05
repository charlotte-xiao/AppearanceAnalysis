package cn.xiaostudy.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 基本组件Bean
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Configuration
public class CommonBean {

    /**
     * Web请求RestTemplate
     * @return 请求工具
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
