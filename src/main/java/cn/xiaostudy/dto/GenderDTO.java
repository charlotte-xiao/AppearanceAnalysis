package cn.xiaostudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 性别
 * @author charlotte xiao
 * @date 2021/10/3
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenderDTO {


    /**
     * 性别
     */
    private String value;

    /**
     * 男
     */
    private final static String MALE = "Male";

    /**
     * 女
     */
    private final static String FEMALE = "Female";

    /**
     * 中文：男
     */
    public final static String C_MALE = "男";

    /**
     * 中文：女
     */
    public final static String C_FEMALE = "女";

    /**
     * 未知生物
     */
    private final static String C_OTHER = "未知生物";

    /**
     * 性别中英文转换
     * @return 性别中文
     */
    public String convertE2C(){
        switch (value){
            case MALE:
                return C_MALE;
            case FEMALE:
                return C_FEMALE;
            default:
                return C_OTHER;
        }
    }
}
