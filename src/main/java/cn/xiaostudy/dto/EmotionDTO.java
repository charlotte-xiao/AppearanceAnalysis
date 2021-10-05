package cn.xiaostudy.dto;

import cn.xiaostudy.enums.EmotionEnum;
import cn.xiaostudy.exception.MirrorException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * 情绪
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmotionDTO {

    /**
     * 生气
     */
    private Double anger;

    /**
     * 厌恶
     */
    private Double disgust;

    /**
     * 恐惧
     */
    private Double fear;

    /**
     * 高兴
     */
    private Double happiness;

    /**
     * 平静
     */
    private Double neutral;

    /**
     * 伤心
     */
    private Double sadness;

    /**
     * 惊讶
     */
    private Double surprise;

    /**
     * 获取情绪
     * @return 情绪
     */
    public String getMaxEmotion(){
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            double maxValue = BigDecimal.ZERO.doubleValue();
            String emotion = EmotionEnum.NO_EMOTION.getEnName();
            for (Field field: fields) {
                Double aDouble = (Double) field.get(this);
                if(aDouble >= maxValue){
                    maxValue = aDouble;
                    emotion = field.getName();
                }
            }
            return EmotionEnum.convertE2C(emotion);
        }catch (Exception e){
            throw new MirrorException("获取情绪部分异常");
        }
    }
}
