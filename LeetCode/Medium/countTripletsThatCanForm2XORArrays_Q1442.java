import java.util.HashMap;

class countTripletsThatCanForm2XORArrays_Q1442 {
    public int countTriplets_N4(int[] arr) {
        int N = arr.length;

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j; k < N; k++) {
                    int a = 0;
                    for (int x = i; x < j; x++) {
                        a ^= arr[x];
                    }

                    int b = 0;
                    for (int y = j; y <= k; y++) {
                        b ^= arr[y];
                    }

                    if (a == b) {
                        // System.out.println(i + " " + j + " " + k);
                        count += 1;
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public int countTriplets(int[] arr) {
        int N = arr.length;

        int ct = 0;
        for(int i = 0; i < N; i++) {
            int xor = arr[i];
            for(int j = i+1; j < N; j++) {
                if(xor == arr[j]) {
                    System.out.println(i + " " + j);
                    ct += j - i;
                }
                xor ^= arr[j];
            }
        }
        System.out.println(ct);
        return ct;
    }

    public static void main(String[] args) {
        countTripletsThatCanForm2XORArrays_Q1442 ct = new countTripletsThatCanForm2XORArrays_Q1442();
        int[] arr = { 2, 3, 1, 6, 7 };
        ct.countTriplets(arr);
    }
}