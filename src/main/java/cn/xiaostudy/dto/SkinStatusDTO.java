package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 皮肤状态
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkinStatusDTO {

    /**
     * 健康
     */
    private String health;

    /**
     * 色斑
     */
    private String stain;

    /**
     * 青春痘
     */
    private String acne;

    /**
     * 黑眼圈
     */
    private String darkCircle;
}
