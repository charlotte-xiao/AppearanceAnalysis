package cn.xiaostudy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 面部特征
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceDTO {

    /**
     * 人脸token标识
     */
    private String faceToken;

    /**
     * 人脸特征值
     */
    private AttributesDTO attributes;

}
