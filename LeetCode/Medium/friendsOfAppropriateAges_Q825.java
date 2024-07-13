// Todo - Facebook question - Medium

import java.util.Arrays;

class friendsOfAppropriateAges_Q825 {
    public int numFriendRequestsOLD(int[] ages) {
        int N = ages.length;
        int friendReqCount = 0;

        reverse(ages);
        // Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));

        for (int i = 1; i < N; i++) {
            int curReq = getFriendReqCount(i, ages);
            System.out.println(0 + " " + i + " " + curReq);
            friendReqCount += curReq;
        }

        System.out.println(friendReqCount);
        
        return friendReqCount;
    }

    public int numFriendRequests(int[] ages) {
        int N = ages.length;
        int friendReqCount = 0;

        reverse(ages);
        // Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));

        for (int i = 1; i < N; i++) {
            int curReq = getFriendReqCount(i, ages);
            System.out.println(0 + " " + i + " " + curReq);
            friendReqCount += curReq;
        }

        System.out.println(friendReqCount);
        
        return friendReqCount;
    }
    
    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    private int getFriendReqCount(int j, int[] ages) {
        int l = 0;
        int h = j;

        int limit = j; 
        while (l < h) {
            int m = (l + h) / 2;
            if (cannotSendReq(m, j, ages)) {
                l = m + 1;
                System.out.println("l = " + l);
            } else {
                limit = m;
                h = m - 1;
                System.out.println("h = " + h + " l = " + l);
            }
        }

        int requests = limit - 1;
        System.out.println("==== " + j + " " + limit + " ====" + " " + requests);
        return requests;
    }

    private boolean cannotSendReq(int x, int y, int[] ages) {
        boolean cannotReq = false;
        if (ages[y] <= (0.5 * ages[x] + 7) || ages[y] > ages[x] || ages[y] > 100 && ages[x] < 100) {
            cannotReq = true;
        }
        return cannotReq;
    }

    public static void main(String[] args) {
        friendsOfAppropriateAges_Q825 fs = new friendsOfAppropriateAges_Q825();
        int[] ages = { 20, 30, 100, 110, 120 };
        // int[] ages = { 16, 17, 18 };
        // int[] ages = { 16, 16 };
        fs.numFriendRequests(ages);
    }
}