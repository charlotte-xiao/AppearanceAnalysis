package cn.xiaostudy.vo;

import lombok.*;

/**
 * 图片信息格式
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureVO {

    /**
     * 数字匹配正则表达式
     */
    public static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    /**
     * BASE64编码图片前缀
     */
    public final static String PICTURE_HEADER = "data:image/png;base64,";

    /**
     * 图片名后缀
     */
    public final static String EXE_NAME = ".png";

    /**
     * 图片分割符号
     */
    public final static String DIVIDE_MARK = "_";

    /**
     * BASE64编码图片ID标识
     */
    @NonNull
    private String id;

    /**
     * BASE64编码的图片数据
     */
    @NonNull
    private String img;


}
