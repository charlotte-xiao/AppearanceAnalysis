package cn.xiaostudy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 上传模式枚举
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Getter
@AllArgsConstructor
public enum UploadModeEnum {

    /**
     * oss
     */
    OSS("oss","ossUploadStrategy","ossGetLinkListStrategy"),
    /**
     * local
     */
    LOCAL("local","localUploadStrategy","localGetLinkListStrategy");


    /**
     * 模式
     */
    private final String mode;

    /**
     * 上传策略
     */
    private final String uploadStrategy;
    /**
     * 获取链接策略
     */
    private final String linkStrategy;

    /**
     * 获取上传策略
     * @param mode 模式
     * @return 策略
     */
    public static String getUploadStrategy(String mode){
        for(UploadModeEnum strategy: UploadModeEnum.values()){
            if(strategy.getMode().equals(mode)){
                return strategy.getUploadStrategy();
            }
        }
        // 默认使用本地策略
        return LOCAL.getUploadStrategy();
    }

    /**
     * 获取链接策略
     * @param mode 模式
     * @return 策略
     */
    public static String getLinkStrategy(String mode){
        for(UploadModeEnum strategy: UploadModeEnum.values()){
            if(strategy.getMode().equals(mode)){
                return strategy.getLinkStrategy();
            }
        }
        // 默认使用本地策略
        return LOCAL.getLinkStrategy();
    }
}
