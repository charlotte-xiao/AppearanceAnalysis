package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 面部预测结果
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredictDTO {

    /**
     * 面部特征
     */
    private List<FaceDTO> faces;

    /**
     * 人脸个数
     */
    private Integer faceNum;
}
