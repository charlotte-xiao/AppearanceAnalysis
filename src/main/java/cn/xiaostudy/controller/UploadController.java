package cn.xiaostudy.controller;

import cn.xiaostudy.config.FileMvcConfig;
import cn.xiaostudy.vo.Picture;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;

/**
 * @author charlotte xiao
 * @date 2021/9/30
 * @description
 */
@RestController
@Data
public class UploadController {

    private static String HEADER = "data:image/png";

    private static Random random = new Random();

    private  static File file = new File(FileMvcConfig.uploadFolder);

    static {
        if(!file.exists()){file.mkdir();}
    }

    /**
     * 上传图片
     * @param picture
     * @return
     */
    @PostMapping("/upload")
    public Boolean upload(@RequestBody Picture picture){
        if(Optional.ofNullable(picture).map(Picture::getImg).orElse("").contains(HEADER)){
            picture.setImg(picture.getImg().replace("data:image/png;base64,",""));
            picture.setId(file.getAbsolutePath()+"//"+picture.getId()+"_"+random.nextInt(10000)+".png");
            return GenerateImage(picture.getImg(),picture.getId());
        }else{
            return false;
        }
    }

    /**
     * 图片转化并存储到本地
     * @param imgData
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String imgData,String imgFilePath) {
        if (imgData == null){
            return false;
        }
        Base64.Decoder decoder = Base64.getDecoder();
        try( OutputStream out = new FileOutputStream(imgFilePath)) {
            byte[] b = decoder.decode(imgData.getBytes());
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return true;
        }
    }
}
