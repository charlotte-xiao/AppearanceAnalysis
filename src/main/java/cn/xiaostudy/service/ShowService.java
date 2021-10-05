package cn.xiaostudy.service;

import cn.xiaostudy.vo.LinkVO;

import java.util.List;

/**
 * 展示链接服务
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
public interface ShowService {

    /**
     * 根据ID查找链接
     * @param id 入参ID
     * @return 链接列表
     */
    public List<LinkVO> findLinkList(String id);


}
