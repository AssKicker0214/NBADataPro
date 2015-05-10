package data;

import vo.playervo.HotPlayersVO;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/5/7.
 */
public class Tools {
    public static double change(double d1){
        BigDecimal bg = new BigDecimal(d1);
        double f1 = bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    public static String getNPosition(String s,int i){
        if (i >= s.length()){
            return "";
        }else {
            return s.substring(i);
        }
    }

    public static ArrayList<HotPlayersVO> getFirstNum(int num, ArrayList<HotPlayersVO> arrayList) {
        ArrayList<HotPlayersVO> res = new ArrayList<>();
        int length = arrayList.size() > num ? num :arrayList.size();
        for (int i = 0 ; i <length;i++){
            res.add(arrayList.get(i));
        }
        return res;
    }
}
