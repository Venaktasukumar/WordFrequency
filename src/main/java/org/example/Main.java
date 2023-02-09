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
        Queue<Map.Entry<String,Integer>> queue=new PriorityQueue<>((a,b)->{return b.getValue()-a.getValue();});
        while(sc.hasNext()){
            String word=sc.next();
            if(hash.containsKey(word)){
                hash.put(word,hash.get(word)+1);
            }
            else{
                hash.put(word,1);
            }
        }
        l.log(Level.INFO,()->""+hash);
        queue.addAll(hash.entrySet());
        for(Map.Entry<String,Integer> q:queue){
            String k=q.getKey()+"->"+q.getValue();
            l.info(k);
        }

    }
}