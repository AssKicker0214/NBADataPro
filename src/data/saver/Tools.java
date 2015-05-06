package data.saver;

import java.math.BigDecimal;

/**
 * Created by chenghao on 15/5/7.
 */
public class Tools {
    public static double change(double d1){
        BigDecimal bg = new BigDecimal(d1);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}
