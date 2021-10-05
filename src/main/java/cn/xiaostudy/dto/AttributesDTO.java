package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 特征
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributesDTO {

    /**
     * 性别
     */
    private GenderDTO gender;

    /**
     * 年龄
     */
    private AgeDTO age;

    /**
     * 心情
     */
    private SmileDTO smile;

    /**
     * 情绪
     */
    private EmotionDTO emotion;

    /**
     * 颜值
     */
    private BeautyDTO beauty;

    /**
     * 皮肤
     */
    private SkinStatusDTO skinstatus;

}
