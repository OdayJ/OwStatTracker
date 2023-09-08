package jona.Utils;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ArrayUtil {
    static int getIndexId(ArrayList<Object> array, String name){
        for (int i = 0; i < array.size(); i++){
            if (array.get(i).toString().contains(name)){
                return i;
            }
        }
        return -1;
    }

    public static float obtainFloatValue(ArrayList<Object> array, String name){
        int i  = getIndexId(array, name);
        if (i == -1){
            return 0;
        }

        return Float.parseFloat(array.get(i + 1).toString());
    }

    public static Time obtainTimeValue(ArrayList<Object> array, String name){
        int i = getIndexId(array, name);
        return Time.valueOf(array.get(i + 1).toString());
    }

    public static int obtainIntValue(ArrayList<Object> array, String name){
        int i = getIndexId(array, name);
        if (i == -1){
            return 0;
        }
        return Integer.parseInt(array.get(i + 1).toString());
    }

    public static Date getTodayDate(){
        long milis = System.currentTimeMillis();
        Date todayDate = new java.sql.Date(milis);

        return todayDate;
    }
}
