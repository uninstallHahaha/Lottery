package com.aclic.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] timer = new int[24];

        int n = 0;

        System.out.println("输入数据组数 : ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = 0;
            int h = 0;
            System.out.println("输入本组人数 : ");
            m = scanner.nextInt();
            System.out.println("输入本组允许时间长度 : ");
            h = scanner.nextInt();;
            System.out.println("输入本组各个学生入校时间 : ");
            for (int j = 0; j < m; j++) {
                int ts = 0;
                ts = scanner.nextInt();
                for (int k = ts; k < ts + h; k++) {
                    if (k <= 23) {
                        timer[k]++;
                    }
                }
            }
        }

        int mint = 0;
        int minv = timer[0];
        for (int y = 1; y < 24; y++) {
            if (timer[y] < minv) {
                minv = timer[y];
                mint = y;
            }
        }
        int start = mint;
        int end = mint;
        for(int i=mint+1;i<24;i++){
            if(timer[i]==minv){
                end = i+1;
            }
            if(timer[i]>minv){
                break;
            }
        }
        System.out.println( "留校最少的时间段为; "+mint +" 至 " +end);
    }
}
