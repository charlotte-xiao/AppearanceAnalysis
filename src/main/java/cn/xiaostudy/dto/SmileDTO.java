package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 微笑值
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmileDTO {

    /**
     * 心情值
     */
    private Double value;

    /**
     * 微笑阈值
     */
    private Double threshold;

}
