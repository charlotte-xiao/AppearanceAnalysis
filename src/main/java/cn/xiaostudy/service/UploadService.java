package cn.xiaostudy.service;

import cn.xiaostudy.vo.PictureVO;

/**
 * 图片上传服务
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
public interface UploadService {

    /**
     * 上传图片
     * @param pictureVO 图片
     * @return 访问地址
     */
    public String uploadPicture(PictureVO pictureVO);

}
