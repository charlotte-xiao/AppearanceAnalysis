package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.constant.AuthCode;
import cn.xiaostudy.exception.MirrorException;
import cn.xiaostudy.strategy.GetLinkListStrategy;
import cn.xiaostudy.vo.LinkVO;
import cn.xiaostudy.vo.PictureVO;

import java.util.Base64;
import java.util.List;

/**
 * 抽象获取链接列表模版
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
public abstract class AbstractGetLinkListStrategyImpl implements GetLinkListStrategy {



    public static String getPrefix(String s){
        return s.substring(0,s.lastIndexOf(PictureVO.DIVIDE_MARK));
    }

    @Override
    public List<LinkVO> getLinkList(String id) {
        Base64.Decoder decoder = Base64.getDecoder();
        String base64DecodeId = new String(decoder.decode(id));
        // 最高权限判断
        if (AuthCode.AUTH_TOKEN.equals(base64DecodeId)) {
            return getAllLinkList();
        }
        // 解析 ID 为数字
        if(!base64DecodeId.matches(PictureVO.NUMBER_REGEX)) {
            throw new MirrorException("非法查询链接");
        }
        return getLinkListById(base64DecodeId);
    }

    /**
     * 获取所有的链接
     * @return 链接列表
     */
    public abstract List<LinkVO> getAllLinkList();

    /**
     * 根据ID获取链接
     * @param id 查询ID
     * @return 链接列表
     */
    public abstract List<LinkVO> getLinkListById(String id);

}
