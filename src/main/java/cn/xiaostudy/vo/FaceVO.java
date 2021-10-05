package cn.xiaostudy.vo;

import cn.xiaostudy.dto.BeautyDTO;
import cn.xiaostudy.dto.SkinStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人脸预测信息VO
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaceVO {

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 微笑指数
     */
    private Double smile;

    /**
     *  是否微笑
     */
    private Boolean isSmile;

    /**
     * 情绪
     */
    private String emotion;

    /**
     * 颜值
     */
    private BeautyDTO beauty;

    /**
     * 皮肤状态
     */
    private SkinStatusDTO skin;


}
