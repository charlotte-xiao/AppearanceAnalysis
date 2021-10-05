package cn.xiaostudy.controller;

import cn.xiaostudy.service.ShowService;
import cn.xiaostudy.vo.LinkVO;
import cn.xiaostudy.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 显示对应图片的链接
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@RestController
public class ShowController {

    @Resource
    private ShowService showService;

    /**
     * 获取图片链接列表
     * @param id 传参ID
     * @return 链接列表
     */
    @GetMapping("/show/{id}")
    public Result<List<LinkVO>> show(@PathVariable("id") String id){
        return Result.ok(showService.findLinkList(id));
    }
}
