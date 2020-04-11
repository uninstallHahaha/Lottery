package com.aclic.lottery.Utils;

import java.util.UUID;

public class Utils {

    public static String genUUID(){
        return UUID.randomUUID().toString().substring(0,28);
    }
}
