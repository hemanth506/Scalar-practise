// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class HelloWorld {
    
    ArrayList<String> globalArr;
    
    public void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
    
    public void fn(String[] words, int i, int N) {
        // System.out.println(i + " " + N);
        if(i == N) {
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < N; k++) {
                sb.append(words[k]);
            }
            globalArr.add(sb.toString());
            return;
        }
        
        for( int j = i; j < N; j++) {
            System.out.println("inside " + j + " " + N);
            swap(words, i, j);
            fn(words, i+1, N);
            swap(words, j, i);
        }
    }
    
    public ArrayList<String> unique_substring_concatenation(String[] words) {
        int N = words.length;
        globalArr = new ArrayList<String>();
        fn(words, 0, N);
        System.out.println(globalArr);
        return globalArr;
    }
    
    public static void main(String[] args) {
        HelloWorld hd = new HelloWorld();
        String[] words = {"foo", "bar", "two"};
        hd.unique_substring_concatenation(words);
    }
}