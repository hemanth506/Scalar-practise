// TO-DO
// import java.util.Arrays;

public class FindUnHappyFriends_Q1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        int unHappyFrnd = 0;
        for (int i = 0; i < n / 2; i++) {
            int friend1 = pairs[i][0];
            if (preferences[friend1][0] != pairs[i][1]) {
                unHappyFrnd += 1;
            }

            int friend2 = pairs[i][1];
            if (preferences[friend2][0] != pairs[i][0]) {
                unHappyFrnd += 1;
            }
        }

        System.out.println(unHappyFrnd);
        return unHappyFrnd;
    }

    public static void main(String[] args) {
        FindUnHappyFriends_Q1583 fd = new FindUnHappyFriends_Q1583();
        // int n = 4;
        // int[][] preferences = { { 1, 2, 3 }, { 3, 2, 0 }, { 3, 1, 0 }, { 1, 2, 0 } };
        // int[][] pairs = { { 0, 1 }, { 2, 3 } };

        // int n = 2;
        // int[][] preferences = { { 1 }, { 0 }};
        // int[][] pairs = { { 1, 0 } };

        int n = 4;
        int[][] preferences = { { 1, 2, 3 }, { 2, 3, 0 }, { 1, 3, 0 }, { 0, 2, 1 } };
        int[][] pairs = { { 1, 3 }, { 0, 2 } };
        fd.unhappyFriends(n, preferences, pairs);
    }
}
