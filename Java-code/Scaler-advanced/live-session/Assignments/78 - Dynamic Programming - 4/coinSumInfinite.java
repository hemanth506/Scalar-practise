import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class coinSumInfinite {
    
    public int getWays(ArrayList<Integer> A, int B, int N, int i, HashMap<String, Integer> hm, int mod) {
        if(B == 0) {
            return 1;
        }
        if(i < 0) {
            return 0;
        }
        // System.out.println("Hemanth i = " + i);
        String st = B + "_" + i;
        if(!hm.containsKey(st)) {
            int leaveIt = getWays(A, B, N, i-1, hm, mod);
            int takeIt = 0;
            if(B >= A.get(i)) {
                takeIt = getWays(A, B-A.get(i), N, i, hm, mod);
            }
            int val = (leaveIt + takeIt) % mod;
            hm.put(st, val);
        }
        return hm.get(st);
    }
    
    // recursion
    public int coinchange2Recursion(ArrayList<Integer> A, int B) {
        int N = A.size();
        int mod = 1000007;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int ways = getWays(A, B, N, N-1, hm, mod);
        System.out.println(ways);
        return ways;
    }

    // iteration
    public int coinchange2(ArrayList<Integer> A, int B) {
        long dp[] = new long[B+1];
    	dp[0] =1;
    	long mod = 1000007;

    	for(int i=0; i<A.size(); i++) {
    		for(int j=A.get(i); j<=B; j++) {
    			dp[j] = (dp[j]%mod + dp[j-A.get(i)]%mod)%mod;
    		}
    	}
    	
    	return (int) dp[B];
    }
    public static void main(String[] args) {
        coinSumInfinite cs = new coinSumInfinite();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        // int B = 4;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10));
        // int B = 10;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(406, 3, 137, 244, 46, 74, 175, 32, 506, 324, 405, 395, 298, 333, 226, 425, 552, 134, 354, 125, 472, 368, 580, 202, 449, 400, 529, 159, 68, 409, 523, 494, 515, 281, 498, 209, 578, 140, 99, 436, 194, 371, 442, 482, 591, 84, 77, 382, 484, 510, 418, 284, 398, 229, 266, 152, 212, 572, 211, 314, 302, 492, 338, 217, 113, 594, 248, 181, 45, 389, 52, 191, 561, 434, 465, 470, 238, 127, 97, 257, 399, 516, 117, 318, 236, 34, 138, 185, 445, 307, 415, 282, 116, 256, 11, 186, 239, 131, 313, 299, 565, 363, 135, 120, 543, 75, 483, 213, 489, 67, 404, 272, 263, 193, 500, 370, 495, 443, 295, 73, 568, 51, 571, 367, 20, 522, 156, 597, 459, 80, 154, 224, 1, 360, 551, 432, 258, 130, 195, 584, 455, 190, 422, 93, 62, 544, 531, 532, 124, 2, 466, 112, 123, 550, 65, 496, 366, 502, 204, 504, 177, 262, 553, 163, 44, 71, 326, 109, 215, 323, 243, 207, 512, 345, 25, 23, 421, 469, 95, 63, 55, 365, 545, 31, 556, 317, 101, 573, 270, 133, 235, 457, 320, 268, 424, 206, 335, 115, 375, 536, 566, 145, 488, 301, 30, 583, 349, 479, 280, 222, 58, 170, 208, 376, 560, 435, 12, 372, 303, 316, 267, 567, 255, 528, 420, 485, 337, 233, 198, 66, 563, 119, 304, 199, 577, 241, 85, 564, 173, 487, 339, 96, 297, 184, 401, 315, 293, 160, 475, 242, 22, 330, 90, 526, 187, 416, 540, 331, 178, 446, 89, 499, 146, 387, 19, 491, 581, 396, 452, 530, 444, 539, 250, 582, 554, 228, 392, 579, 161, 525, 555, 13, 136, 105, 569, 254, 402, 219, 76, 527, 593, 520, 341, 393, 451, 54, 165, 471, 501, 269, 513, 162, 379, 549, 453, 600, 41, 537, 381, 18, 168, 40, 88, 348, 509, 412, 237, 189, 463, 277, 141, 279, 431, 275, 352, 94, 547, 514, 419, 575, 433, 426, 264, 410, 588, 587, 172, 386, 81, 29, 259, 305, 69, 359, 144, 273, 592, 148, 390, 430, 252, 203, 14, 166, 558, 467, 598, 447, 322, 288, 511, 414, 458, 118, 142, 533, 468, 329, 110, 214, 486, 100, 438, 589, 102, 464, 407, 477, 98, 53));
        int B = 39588;

        cs.coinchange2(A, B);
    }
}
