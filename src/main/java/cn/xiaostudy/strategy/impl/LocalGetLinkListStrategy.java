package cn.xiaostudy.strategy.impl;

import cn.xiaostudy.config.LocalConfig;
import cn.xiaostudy.exception.MirrorException;
import cn.xiaostudy.vo.LinkVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 本地获取链接列表策略
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Service("localGetLinkListStrategy")
public class LocalGetLinkListStrategy extends AbstractGetLinkListStrategyImpl{

    @Resource
    private LocalConfig localConfig;

    @Override
    public List<LinkVO> getAllLinkList() {
        File directory = makeDir(localConfig.getRealPath());
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .filter(File::isFile)
                .map(s -> new LinkVO(localConfig.getUrl()+localConfig.getPath()+s.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<LinkVO> getLinkListById(String id) {
        File directory = makeDir(localConfig.getRealPath());
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .filter(s -> s.isFile() && Objects.equals(id,getPrefix(s.getName())))
                .map(s -> new LinkVO(localConfig.getUrl()+localConfig.getPath()+s.getName()))
                .collect(Collectors.toList());
    }


    /**
     * 确保文件夹存在
     * @param filePath 文件夹路径
     * @return 文件
     */
    public static File makeDir(String filePath){
        File directory = new File(filePath);
        if(!directory.exists()){
            if(!directory.mkdirs()){
                throw new MirrorException("创建目录失败");
            }
        }
        return directory;
    }
}
