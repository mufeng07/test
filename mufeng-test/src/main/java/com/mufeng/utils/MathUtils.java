package com.mufeng.utils;

import java.math.BigDecimal;
import java.util.Arrays;

public class MathUtils {
    public static BigDecimal ZERO_DECIMAL = new BigDecimal(0);

    /**
     * 四舍五入 保留2位
     *
     * @param decimal
     * @return
     */
    public static BigDecimal roundHalfUp(BigDecimal decimal) {
        return roundHalfUp(decimal, 2);
    }

    /**
     * 四舍五入
     *
     * @param decimal
     * @param scale 保留小数点后位数
     * @return
     */
    public static BigDecimal roundHalfUp(BigDecimal decimal, int scale) {
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入
     *
     * @param value
     * @param scale 保留小数点后位数
     * @return
     */
    public static BigDecimal roundHalfUp(double value, int scale) {
        BigDecimal decimal = new BigDecimal(value);
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入,保留小数点后两位
     *
     * @param value
     * @return
     */
    public static BigDecimal roundHalfUp(double value) {
        return roundHalfUp(value, 2);
    }

    /**
     * 多值累加
     *
     * @param value
     * @return
     */
    public static BigDecimal doubleAdd(double... value) {
        double sum = 0;
        if (value != null) {
            for (int i = 0; i < value.length; i++) {
                sum += value[i];
            }
        }
        return roundHalfUp(sum);
    }
    /**
     * 整型转换成字节数组
     */
    public static byte[] int2Bytes(int i){
        byte[] arr = new byte[4] ;
        arr[0] = (byte)i ;
        arr[1] = (byte)(i >> 8) ;
        arr[2] = (byte)(i >> 16) ;
        arr[3] = (byte)(i >> 24) ;
        return arr ;
    }

    /**
     * 字节数组转成int
     */
    public static int bytes2Int(byte[] bytes){
        int i0= bytes[0];
        int i1 = (bytes[1] & 0xFF) << 8 ;
        int i2 = (bytes[2] & 0xFF) << 16 ;
        int i3 = (bytes[3] & 0xFF) << 24 ;
        return i0 | i1 | i2 | i3 ;
    }

    public static void main(String[] args) throws Exception{
        //DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream("d:/transferStation/a.dat"));

        // dataOutputStream.writeInt(23);
         //dataOutputStream.close();
        //-127 4 0 0
        System.out.println(Arrays.toString(int2Bytes(1153)));
        bytes2Int(int2Bytes(1153));
        System.out.println(bytes2Int(int2Bytes(129)));
        System.out.println(4<<8);
        System.out.println(0<<16);
        System.out.println(-127|1024);
    }
}
