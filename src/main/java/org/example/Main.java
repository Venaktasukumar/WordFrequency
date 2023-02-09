package org.example;
import java.io.*;
import java.util.*;
import java.util.logging.*;

class Frequency{
    public static void main(String[] args) throws FileNotFoundException{
        Logger l= Logger.getLogger("com.api.jar");
        String s="C:/Users/Tringapps-User12/Documents/frequencyfile/text.txt";
        File file=new File(s);
        Scanner sc=new Scanner(file);
        HashMap<String,Integer> hash=new HashMap<String,Integer>();
        while(sc.hasNext()){
            String word=sc.next();
            if(hash.containsKey(word)){
                hash.put(word,hash.get(word)+1);
            }
            else{
                hash.put(word,1);
            }
        }
        l.info("Before Sorting:");
        l.log(Level.INFO,()->""+hash);
        List<Map.Entry<String, Integer>> k= hash.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
        l.info("After Sorting:");
        l.log(Level.INFO,()->""+k);

    }
}