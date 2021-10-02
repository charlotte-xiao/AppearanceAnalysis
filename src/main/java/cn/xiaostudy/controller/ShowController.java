package cn.xiaostudy.controller;

import cn.xiaostudy.config.FileMvcConfig;
import cn.xiaostudy.vo.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@RestController
public class ShowController {

    /**
     * 查看所有照骗
     */
    private static String TOKEN = "charlottexiao";

    private static File file = new File(FileMvcConfig.uploadFolder);

    static {
        if(!file.exists()){file.mkdir();}
    }

    /**
     * 获取图片链接
     * @param id
     * @return
     */
    @GetMapping("/show/{id}")
    public List<Link> show(@PathVariable("id") String id){
        if(TOKEN.equals(id)){
            return Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(File::isFile).map(s -> new Link("/images/"+ s.getName())).collect(Collectors.toList());
        }else{
            return Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(s -> s.isFile()&&id.equals(getPrefix(s.getName()))).map(s -> new Link("/images/"+ s.getName())).collect(Collectors.toList());
        }
    }

    public static String getPrefix(String s){
        return s.substring(0,s.indexOf('_'));
    }
}
