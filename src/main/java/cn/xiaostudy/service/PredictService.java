package cn.xiaostudy.service;

import cn.xiaostudy.vo.FaceVO;
import cn.xiaostudy.vo.PictureVO;

/**
 * 预测服务
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
public interface PredictService {

    /**
     * 根据Picture的格式进行分析
     * @param picture 图片
     * @return 预测信息
     */
    public FaceVO predictPicture(PictureVO picture);

}
