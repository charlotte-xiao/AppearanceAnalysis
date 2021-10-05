package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.config.OssConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.util.Base64;

/**
 * OSS 上传策略
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Service("ossUploadStrategy")
public class OssUploadStrategy extends AbstractUploadStrategyImpl {

    @Resource
    private OssConfig ossConfig;

    @Override
    public Boolean exists(String fileName) {
        return ossConfig.getOssClient().doesObjectExist(ossConfig.getBucketName(),ossConfig.getPath()+fileName);
    }

    @Override
    public void upload(String fileName, String image) {
        // 格式转换
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] content = decoder.decode(image.getBytes());
        for(int index = 0;index<content.length;index++){
            if(content[index]<0){
                content[index] += 1<<8;
            }
        }
        ossConfig.getOssClient().putObject(ossConfig.getBucketName(),ossConfig.getPath()+fileName,new ByteArrayInputStream(content));
    }

    @Override
    public String getFileAccessUrl(String fileName) {
        return ossConfig.getUrl()+ossConfig.getPath()+fileName;
    }


}
