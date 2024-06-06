// To-do

import java.util.ArrayList;

public class canIWin_Q464 {

    public boolean rightToLeft(int maxChoosableInteger, int desiredTotal) {
        int p1 = maxChoosableInteger - 1;
        int p2 = maxChoosableInteger;
        int lastpick = 1;
        boolean first = true;
        boolean second = false;
        while (desiredTotal > 0) {
            if (first) {
                lastpick = 1;
                desiredTotal -= p1;
                p1 -= 2;
                first = false;
                second = true;
            } else if (second) {
                lastpick = 2;
                desiredTotal -= p2;
                p2 -= 2;
                first = true;
                second = false;
            }
        }
        System.out.println(lastpick);
        return lastpick == 1 ? true : false;
    }

    // public boolean leftToRight(int maxChoosableInteger, int desiredTotal) {
    //     System.out.println(maxChoosableInteger + " " + desiredTotal);
        
    //     int p2 = maxChoosableInteger - 1;
    //     int p1 = maxChoosableInteger;
    //     int lastpick = 1;
    //     boolean first = true;
    //     boolean second = false;
    //     while (desiredTotal > 0) {
    //         if (first) {
    //             lastpick = 1;
    //             desiredTotal -= p1;
    //             System.out.println("p1 desiredTotal = " + desiredTotal + " p1 = " + p1);
    //             p1 -= 2;
    //             first = false;
    //             second = true;
    //         } else if (second) {
    //             lastpick = 2;
    //             desiredTotal -= p2;
    //             System.out.println("p2 desiredTotal = " + desiredTotal + " p2 = " + p2);
    //             p2 -= 2;
    //             first = true;
    //             second = false;
    //         }
    //     }
    //     System.out.println(lastpick);
    //     return lastpick == 1 ? true : false;
    // }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            System.out.println("true base condition");
            return true;
        }


        boolean RtoL = rightToLeft(maxChoosableInteger, desiredTotal);
        // boolean LtoR = leftToRight(maxChoosableInteger, desiredTotal);
        // System.out.println(RtoL + " " + LtoR);

        return RtoL;
        // return RtoL || LtoR;
    }

    public static void main(String[] args) {
        canIWin_Q464 cn = new canIWin_Q464();
        int maxChoosableInteger = 10;
        int desiredTotal = 11;

        // int maxChoosableInteger = 4;
        // int desiredTotal = 6;
        cn.canIWin(maxChoosableInteger, desiredTotal);
    }
}

/*
 * 
 * // int p1 = maxChoosableInteger - 1;
 * // int p2 = maxChoosableInteger;
 * // int lastpick = 1;
 * // boolean first = true;
 * // boolean second = false;
 * // while (desiredTotal > 0) {
 * // if (first) {
 * // lastpick = 1;
 * // desiredTotal -= p1;
 * // p1 -= 2;
 * // first = false;
 * // second = true;
 * // } else if (second) {
 * // lastpick = 2;
 * // desiredTotal -= p2;
 * // p2 -= 2;
 * // first = true;
 * // second = false;
 * // }
 * // }
 * 
 * // System.out.println(lastpick);
 * // return lastpick == 1 ? true : false;
 */