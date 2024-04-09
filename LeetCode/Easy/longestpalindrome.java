import java.util.HashMap;

public class longestpalindrome {
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    for (char c : s.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }

    boolean hasOdd = false;
    int totalLength = 0;
    for (HashMap.Entry<Character, Integer> entry : hm.entrySet()) {
      if (entry.getValue() % 2 == 0) {
        totalLength += entry.getValue();
      } else {
        hasOdd = true;
        totalLength += entry.getValue() - 1;
      }
    }

    if (hasOdd) {
      totalLength++;
    }

    return totalLength;
  }

  public static void main(String[] args) {
    longestpalindrome lp = new longestpalindrome();
    String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
    lp.longestPalindrome(s);
  }
}
