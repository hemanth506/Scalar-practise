/*
 * Click `Run` to execute the snippet below!
 */

 import java.io.*;
 import java.util.*;
 
 /*
  * To execute Java, please define "static void main" on a class
  * named Solution.
  *
  * If you need more classes, simply define them inline.
 
 List[String] 
 n 
 
 product type is at the end 
 don't know catalog
 
 "4gb phone" SKU product -> no fixed delimiter
 
 // l = {"4gb phone", "16gb_phone", "720p tv", "1024p tv", "16gbtablet", "32gb_phone"}
 
 {"phone": 3, "tv": 2, "16gbtablet": 1}
 
 <<2> <m>>
 3 -> phone, 2 -> tv , 1 -> : ""
 
 phone tv
 
 top n products types
 top 2 
 phone (3) , tv (2) 
 
 
 ===========================
 product type is at the end 
 
 4gb phone 16gb_phone
 4gb phone 1024p tv
 
 (N * N)* m +  NlogN + m = N**2 
 
  */
 
 class AppleSolution {
 
   public HashMap<String, Integer> getCatalog(ArrayList<String> strings) {
 
     HashMap<String, Integer> catalogTable = new HashMap<>();
     int N = strings.size();
 
     for(int i = 0; i < N; i++) {
       boolean productFound = false;
       String prod1 = strings.get(i);
       StringBuilder sb = new StringBuilder();
       for(int j = i; j < N; j++) {
         if(productFound) {
           break;
         }
         String prod2 = strings.get(j);
 
         int l = prod2.length()-1;
         for(int k = prod1.length()-1; k >= 0;k--) {
           if(prod1.charAt(k) == prod2.charAt(l)) {
             sb.append(prod1.charAt(k));
           } else {
             break;
           }
           l--;
         }
 
         int count = catalogTable.getOrDefault(sb.toString(), 0);
         if(count == 0) {
           catalogTable.put(sb.toString(), count);
         } else {
           productFound = true;
         }
 
       }
     }
 
     System.out.println(catalogTable);
     return null;
   } 
 
   public ArrayList<String> findNProducts(ArrayList<String> strings) {
     HashMap<String, Integer> catalog = getCatalog(strings);
     return null;
   }
 
   // public 
   public static void main(String[] args) {
     ArrayList<String> strings = new ArrayList<String>();
     strings.add("4gb phone");
     strings.add("16gb_phone");
     strings.add("720p tv");
     strings.add("1024p tv");
     AppleSolution sn = new AppleSolution();
     sn.findNProducts(strings);
   }
 }
 
 
 // Your previous Plain Text content is preserved below:
 
 // This is just a simple shared plaintext pad, with no execution capabilities.
 
 // When you know what language you'd like to use for your interview,
 // simply choose it from the dots menu on the tab, or add a new language
 // tab using the Languages button on the left.
 
 // You can also change the default language your pads are created with
 // in your account settings: https://app.coderpad.io/settings
 
 // Enjoy your interview!