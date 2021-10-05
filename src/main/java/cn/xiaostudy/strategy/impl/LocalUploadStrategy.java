package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.config.LocalConfig;
import cn.xiaostudy.exception.MirrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

/**
 * 本地上传策略
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Service("localUploadStrategy")
public class LocalUploadStrategy extends AbstractUploadStrategyImpl {

    @Resource
    private LocalConfig localConfig;

    @Override
    public Boolean exists(String fileName) {
        return new File(localConfig.getRealPath() + fileName).exists();
    }

    @Override
    public void upload(String fileName, String image) {
        // 判断目录是否存在
        File directory = new File(localConfig.getRealPath());
        if(!directory.exists()){
            if(!directory.mkdirs()){
                throw new MirrorException("创建目录失败");
            }
        }
        // 写入文件
        Base64.Decoder decoder = Base64.getDecoder();
        try( OutputStream out = new FileOutputStream(localConfig.getRealPath()+fileName)) {
            // 格式转换
            byte[] content = decoder.decode(image.getBytes());
            for(int index = 0;index<content.length;index++){
                if(content[index]<0){
                    content[index] += 1<<8;
                }
            }
            out.write(content);
        } catch (Exception e) {
            throw new MirrorException("文件写入异常");
        }
    }

    @Override
    public String getFileAccessUrl(String fileName) {
        return localConfig.getUrl()+localConfig.getPath()+fileName;
    }
}
