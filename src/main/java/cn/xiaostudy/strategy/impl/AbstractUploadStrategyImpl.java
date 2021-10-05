package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.exception.MirrorException;
import cn.xiaostudy.strategy.UploadStrategy;
import cn.xiaostudy.vo.PictureVO;

import java.util.Base64;
import java.util.Random;

/**
 * 抽象上传模版
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
public abstract class AbstractUploadStrategyImpl implements UploadStrategy {

    /**
     * 重命名随机数
     */
    private final static Random random = new Random();

    /**
     *
     * @param pictureVO 图片
     * @return
     */
    @Override
    public String uploadFile(PictureVO pictureVO) {
        // Picture预处理
        if(pictureVO.getImg().contains(PictureVO.PICTURE_HEADER)){
            pictureVO.setImg(pictureVO.getImg().replace(PictureVO.PICTURE_HEADER,""));
        }else{
            throw new MirrorException("图片格式错误");
        }
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            String base64DecodeId = new String(decoder.decode(pictureVO.getId()));
            // 解析 ID 为数字
            if(!base64DecodeId.matches(PictureVO.NUMBER_REGEX)) {
                throw new MirrorException("非法ID数字");
            }
            // 生成文件名
            String fileName = base64DecodeId + PictureVO.DIVIDE_MARK + random.nextInt(1<<10) + PictureVO.EXE_NAME;
            // 判断文件是否存在
            if(!exists(fileName)){
                upload(fileName, pictureVO.getImg());
            }
            // 返回文件访问URL
            return getFileAccessUrl(fileName);
        }catch (Exception e){
            throw new MirrorException("上传图片异常");
        }
    }

    /**
     * 判断文件是否存在
     *
     * @param fileName 文件名
     * @return {@link Boolean}
     */
    public abstract Boolean exists(String fileName);

    /**
     * 上传
     *
     * @param fileName    文件名
     * @param image BASE64编码的图片数据
     */
    public abstract void upload(String fileName, String image);

    /**
     * 获取文件访问url
     *
     * @param fileName 文件名
     * @return {@link String}
     */
    public abstract String getFileAccessUrl(String fileName);

}
