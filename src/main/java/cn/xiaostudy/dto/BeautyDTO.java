package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 颜值
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeautyDTO {

    /**
     * 男性评价
     */
    private String maleScore;

    /**
     * 女性评价
     */
    private String femaleScore;

}
