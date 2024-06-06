public class KlentyQ1 {

  public String solution(int[] array, int N) {
    int changes = 0;
    int total = 0;
    for (int i = 0; i < N; i++) {
      changes = changes + array[i];
      if (array[i] != 0) {
        System.out.println(changes + " " + total);

        total += changes;
      }
    }

    total -= changes;
    System.out.println(changes + " " + total);
    if (total % 2 == 0) {
      System.out.println("Kiran");
      return "Kiran";
    }
    System.out.println("Alex");
    return "Alex";
  }

  public static void main(String[] args) {
    // 1 = Kiran, 2 = Alex
    KlentyQ1 kl = new KlentyQ1();
    int[] array = { 3, 4, 0, 1, 5, 2 };
    int N = 6;
    kl.solution(array, N);
  }
}
