package cn.xiaostudy.service.impl;

import cn.xiaostudy.service.ShowService;
import cn.xiaostudy.strategy.context.PictureStrategyContext;
import cn.xiaostudy.vo.LinkVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  展示链接服务
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Resource
    private PictureStrategyContext pictureStrategyContext;

    @Override
    public List<LinkVO> findLinkList(String id) {
        return pictureStrategyContext.getLinkListByStrategy(id);
    }
}
