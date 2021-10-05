package cn.xiaostudy.strategy;

import cn.xiaostudy.vo.LinkVO;

import java.util.List;

/**
 * 获取链接策略
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
public interface GetLinkListStrategy {

    /**
     * 获取链接列表
     * @param id 图片名ID标识
     * @return 链接列表
     */
    public List<LinkVO> getLinkList(String id);
}
