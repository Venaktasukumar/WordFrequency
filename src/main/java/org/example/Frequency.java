package org.example;
import java.io.*;
import java.util.*;
import java.util.logging.*;

class Frequency{
    public static void main(String[] args) throws FileNotFoundException{
        Logger l= Logger.getLogger("com.api.jar");
        String s="C:/Users/Tringapps-User12/Documents/frequencyfile/text.txt";
        File fi=new File(s);
        Scanner sc=new Scanner(fi);
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
        l.info("After Sorting:");
        ArrayList<Map.Entry<String,Integer>> k=new ArrayList<>(hash.entrySet());
        Collections.sort(k,(a,b)->b.getValue().compareTo(a.getValue()));
        l.log(Level.INFO,()->""+k);
        for(Map.Entry<String,Integer> i:k){
            String f= i.getKey()+" -> "+i.getValue();
            l.info(f);
        }
    }
}