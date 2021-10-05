package cn.xiaostudy.strategy;

import cn.xiaostudy.vo.PictureVO;


/**
 * 图片上传策略
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
public interface UploadStrategy {


    /**
     * 上传
     *
     * @param pictureVO 图片
     * @return {@link String} 图片地址
     */
    String uploadFile(PictureVO pictureVO);

}
