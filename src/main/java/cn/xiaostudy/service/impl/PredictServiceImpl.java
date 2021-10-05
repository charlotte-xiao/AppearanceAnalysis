package cn.xiaostudy.service.impl;

import cn.xiaostudy.config.FaceConfig;
import cn.xiaostudy.dto.*;
import cn.xiaostudy.exception.MirrorException;
import cn.xiaostudy.service.PredictService;
import cn.xiaostudy.vo.FaceVO;
import cn.xiaostudy.vo.PictureVO;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

import static cn.xiaostudy.constant.FaceConstant.*;

/**
 * 预测服务
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Service
public class PredictServiceImpl implements PredictService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private FaceConfig faceConfig;

    @Override
    public FaceVO predictPicture(PictureVO picture) {
        MultiValueMap<String, String> faceParam = new LinkedMultiValueMap<>();
        faceParam.add(API_KEY,faceConfig.getApiKey());
        faceParam.add(API_SECRET,faceConfig.getApiSecret());
        faceParam.add(IMAGE_BASE64,picture.getImg());
        faceParam.add(RETURN_ATTRIBUTES,RETURN_ATTRIBUTES_VALUE);
        PredictDTO predictDTO;
        try{
           predictDTO = JSON.parseObject(restTemplate.postForObject(faceConfig.getUrl(), faceParam, String.class),PredictDTO.class);
        }catch (Exception e){
            throw new MirrorException("预测服务异常");
        }
        // 图片中没有人的情况
        if(Optional.ofNullable(predictDTO).map(PredictDTO::getFaceNum).orElse(0) <= 0){
            throw new MirrorException("图片中没有检测到任何人物～");
        }
        // 获取第一个人物的信息
        AttributesDTO attributes = predictDTO.getFaces().get(0).getAttributes();
        FaceVO faceVO = FaceVO.builder()
                .gender(attributes.getGender().convertE2C())
                .age(attributes.getAge().getValue())
                .smile(attributes.getSmile().getValue())
                .isSmile(Optional.of(attributes.getSmile()).map(s -> s.getValue() > s.getThreshold()).get())
                .emotion(attributes.getEmotion().getMaxEmotion())
                .beauty(attributes.getBeauty())
                .skin(attributes.getSkinstatus())
                .build();
        return faceVO;
    }
}
