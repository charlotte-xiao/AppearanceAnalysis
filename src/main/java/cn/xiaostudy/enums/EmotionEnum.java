package cn.xiaostudy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 情绪枚举类
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Getter
@AllArgsConstructor
public enum EmotionEnum {

    /**
     * 愤怒
     */
    ANGER("anger","愤怒"),
    /**
     * 厌恶
     */
    DISGUST("disgust","厌恶"),
    /**
     * 恐惧
     */
    FEAR("fear","恐惧"),
    /**
     * 高兴
     */
    HAPPINESS("happiness","高兴"),
    /**
     * 平静
     */
    NEUTRAL("neutral","平静"),
    /**
     * 伤心
     */
    SADNESS("sadness","伤心"),
    /**
     * 惊讶
     */
    SURPRISE("surprise","惊讶"),
    /**
     * 没有感情的机器人
     */
    NO_EMOTION("","没有感情的机器人");


    /**
     * 情绪英语名
     */
    private final String enName;

    /**
     * 情绪中文名
     */
    private final String chName;

    /**
     * 中英文情绪转换
     */
    public static String convertE2C(String enName){
        for(EmotionEnum emotion: EmotionEnum.values()){
            if(emotion.getEnName().equals(enName)){
                return emotion.getChName();
            }
        }
        return NO_EMOTION.getChName();
    }
}
