package cn.xiaostudy.util;

import cn.xiaostudy.dto.GenderDTO;
import cn.xiaostudy.vo.FaceVO;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 预测分析工具类
 * @author charlotte xiao
 * @date 2021/10/4
 * @description
 */
public class PredictUtil {

    public static String predictMessage(FaceVO faceVO){
        int beauty = new BigDecimal(faceVO.getBeauty().getFemaleScore()).intValue();
        String gender = faceVO.getGender();
        String result = "";
        switch (beauty/10){
            case 6:
                result += "看到你的时候，我想到了夏天，泳池，薄荷叶和18岁。";
                break;
            case 7:
                if(Objects.equals(gender,GenderDTO.C_FEMALE)){
                    result += "有美一人，清扬惋兮。";
                }else{
                    result += "萧萧肃肃,爽朗清举。";
                }
                break;
            case 8:
            case 9:
                if(Objects.equals(gender,GenderDTO.C_FEMALE)){
                    result += "如果你还单身，不要再犹豫了，赶快联系作者。";
                }else{
                    result += "萧萧肃肃,爽朗清举。";
                }
                break;
            default:
                result+="没有你，谁来衬托世界的美。";
        }
        return result;
    }

}
