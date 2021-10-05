package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.config.OssConfig;
import cn.xiaostudy.vo.LinkVO;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * OSS获取链接列表策略
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Service("ossGetLinkListStrategy")
public class OssGetLinkListStrategy extends AbstractGetLinkListStrategyImpl{

    @Resource
    private OssConfig ossConfig;

    @Override
    public List<LinkVO> getAllLinkList() {
        ObjectListing objectListing = ossConfig.getOssClient().listObjects(new ListObjectsRequest(ossConfig.getBucketName()).withPrefix(ossConfig.getPath()).withMaxKeys(Integer.MAX_VALUE));
        return objectListing.getObjectSummaries().stream()
                .map(OSSObjectSummary::getKey)
                .map(s -> new LinkVO(ossConfig.getUrl() + s) )
                .collect(Collectors.toList());
    }

    @Override
    public List<LinkVO> getLinkListById(String id) {
        return getAllLinkList().stream()
                .filter(s -> Objects.equals(id,getPrefix(s.getLink())))
                .collect(Collectors.toList());
    }
}
