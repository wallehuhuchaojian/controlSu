package com.walle.controlself.deffect.tools;

import java.nio.Buffer;
import java.security.PublicKey;

/**
 * Created by walle on 2017/7/31.
 */

public class CovertTools {
    public static  String integerToString(Integer[] in){
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i < in.length; i++) {
            if (i==0){
                buffer.append(in[i]);
            }else {
                buffer.append(",");
                buffer.append(in[i]);
            }
        }
        return buffer.toString();
    }
}
