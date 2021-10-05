package cn.xiaostudy.strategy.context;

import cn.xiaostudy.strategy.GetLinkListStrategy;
import cn.xiaostudy.strategy.UploadStrategy;
import cn.xiaostudy.vo.LinkVO;
import cn.xiaostudy.vo.PictureVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static cn.xiaostudy.enums.UploadModeEnum.*;

/**
 * 上传策略上下文
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Service
public class PictureStrategyContext {

    /**
     * 上传模式
     */
    @Value("${upload.mode}")
    private String uploadMode;

    /**
     * 上传策略MAP
     */
    @Resource
    private Map<String, UploadStrategy> uploadStrategyMap;


    @Resource
    private Map<String, GetLinkListStrategy> getLinkListStrategyMap;

    /**
     * 执行上传策略
     * @param pictureVO 图片
     * @return url地址
     */
    public String executeUploadStrategy(PictureVO pictureVO){
        return uploadStrategyMap.get(getUploadStrategy(uploadMode)).uploadFile(pictureVO);
    }


    /**
     * 执行获取链接策略
     * @param id 图片名ID标识
     * @return  链接列表
     */
    public List<LinkVO> getLinkListByStrategy(String id){
        return getLinkListStrategyMap.get(getLinkStrategy(uploadMode)).getLinkList(id);
    }

}
