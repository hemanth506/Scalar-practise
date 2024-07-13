// Trie catch approach - need to handle edge case

import Medium.TriNode1;
import java.util.ArrayList;
import java.util.List;

public class wordBreak_Q139 {
    
    // private boolean validateStringOLD(String S, TriNode1 head) {
    //     TriNode1 node = head;
    //     for(int i = 0; i < N; i++) {
    //         // System.out.println(i);
    //         TriNode1 curNode = node;
    //         if(!curNode.hm.containsKey(S.charAt(i)) && i == (N-1) && !curNode.isLast) {
    //             return false;
    //         }
    //         while(i < N && curNode.hm.containsKey(S.charAt(i)) && !curNode.isLast) {
    //             System.out.println(i + " " + S.charAt(i));
    //             curNode = curNode.hm.get(S.charAt(i));
    //             i++;
    //         }
    //         i--;
    //     }
    //     return true;
    // }


    int N;
    TriNode1 main;
    public boolean wordBreak(String S, List<String> wordDict) {
        N = S.length();
        main = createTrie(wordDict);
        System.out.println(main);
        boolean result = validateString(S, main, 0);
        System.out.println(result);
        return result;
    }

    private boolean validateString(String S, TriNode1 head, int i) {
        // System.out.println(i);
        if(i == N && head.isLast) {
            System.out.println(head.isLast);
            return true;
        }
        if(i >= N) {
            System.out.println("End of character");
            return false;
        }

        System.out.println(head.hm + " == " + i + " === " +  S.charAt(i));
        boolean result = false;
        if(head.hm.containsKey(S.charAt(i))) {
            boolean fromStart = false;
            if(head.isLast) {
                System.out.println("isLast");
                fromStart = validateString(S, main, i);
            }
            boolean proceed = validateString(S, head.hm.get(S.charAt(i)), i+1);
            result = fromStart || proceed;
        } else {
            if(main.hm.containsKey(S.charAt(i))) {
                result = validateString(S, main, i);
            } else {
                return false;
            }
        }
        return result;
    }

    public TriNode1 createTrie(List<String> wordDict) {
        TriNode1 head = new TriNode1();
        // System.out.println("inside createTrie = " + head);
        for(int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            TriNode1 root = head;
            for(int j = 0; j < str.length(); j++) {
                char curChar = str.charAt(j);
                if(!root.hm.containsKey(curChar)) {
                    // System.out.println("No Contain = " + curChar);
                    TriNode1 nn = new TriNode1();
                    root.hm.put(curChar, nn);
                    root = nn;
                } else {
                    // System.out.println("Contains = " + curChar);
                    root = root.hm.get(curChar);
                }
            }
            // System.out.println("=====Break=====");
            root.isLast = true;
        }
        return head;
    }
    
    public static void main(String[] args) {
        wordBreak_Q139 wb = new wordBreak_Q139();
        // String S = "applepenapplet";
        // List<String> wordDict = new ArrayList<String>();
        // wordDict.add("apple");
        // wordDict.add("pen");
        // wordDict.add("apple");

        // String S = "catsandog";
        // List<String> wordDict = new ArrayList<String>();
        // wordDict.add("cats");
        // wordDict.add("dog");
        // wordDict.add("sand");
        // wordDict.add("and");
        // wordDict.add("cat");


        // String S = "leetcode";
        // List<String> wordDict = new ArrayList<String>();
        // wordDict.add("leet");
        // wordDict.add("code");


        // String S = "aaaaaaa";
        // List<String> wordDict = new ArrayList<String>();
        // wordDict.add("aaaa");
        // wordDict.add("aa");

        
        // String S = "a";
        // List<String> wordDict = new ArrayList<String>();
        // wordDict.add("a");

        String S = "dcacbcadcad";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cbd");
        wordDict.add("dca");
        wordDict.add("bcdc");
        wordDict.add("dcac");
        wordDict.add("ad");

        wb.wordBreak(S, wordDict);
    }
}
