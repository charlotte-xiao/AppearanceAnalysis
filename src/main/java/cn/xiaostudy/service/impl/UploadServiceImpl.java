package cn.xiaostudy.service.impl;

import cn.xiaostudy.service.UploadService;
import cn.xiaostudy.strategy.context.PictureStrategyContext;
import cn.xiaostudy.vo.PictureVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 上传服务
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private PictureStrategyContext pictureStrategyContext;

    @Override
    public String uploadPicture(PictureVO pictureVO) {
        return pictureStrategyContext.executeUploadStrategy(pictureVO);
    }
}
