package cn.xiaostudy.controller;

import cn.xiaostudy.service.PredictService;
import cn.xiaostudy.service.UploadService;
import cn.xiaostudy.util.PredictUtil;
import cn.xiaostudy.vo.FaceVO;
import cn.xiaostudy.vo.PictureVO;
import cn.xiaostudy.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 上传图片并进行预测分析
 * @author charlotte xiao
 * @date 2021/9/30
 * @description
 */
@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @Resource
    private PredictService predictService;

    /**
     * 上传图片
     * @param pictureVO 图片
     * @return 预测结果
     */
    @PostMapping("/upload")
    public Result<FaceVO> upload(@RequestBody PictureVO pictureVO){
        String url = uploadService.uploadPicture(pictureVO);
        System.out.println("-------------------");
        FaceVO faceVO = predictService.predictPicture(pictureVO);
        System.out.println(url);
        System.out.printf(faceVO.toString());
        String message = PredictUtil.predictMessage(faceVO);
        System.out.println(message);
        return Result.ok(faceVO,message);
    }

}
