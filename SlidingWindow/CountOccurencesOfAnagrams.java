package com.example.meme.slidingwindow;

import java.util.HashMap;

/*
 1. create map according to pattern
 2. store map size in count
 3. while(j<size)
    chekc if arr[j] present in map-->decrement map value or check if arr[j] map value ==0 --> decrement count
 4.if(j-i+1<k)-->j++
 5.if(j-i+1==k)-->slide
    if count==0 --> ans++;
    arr[i]-in map++
    i++;
    j++;

 */
public class CountOccurencesOfAnagrams {
    public static void main(String args[]) {
        String str = "aabaabaa";
        String pattern = "aaba";
        int ans = 0;
        HashMap<Character, Integer> kmap = new HashMap<>();
        int k = pattern.length();
        for (int i = 0; i < k; i++) {
            char ch = pattern.charAt(i);
            kmap.put(ch,kmap.getOrDefault(ch,0)+1);
        }
        int count = kmap.size();

        int i=0,j=0;
        while(j<str.length()){
            char ch=str.charAt(j);
            if(kmap.containsKey(ch)){
                kmap.put(ch,kmap.get(ch)-1);
            }
            if((kmap.get(str.charAt(j))==0)){
                count--;
            }
            if(j-i+1<k) {
                j++;
            }else if(j-i+1==k){
                if(count==0){
                    ans++;
                }
                char ch1= str.charAt(i);
                if(kmap.containsKey(ch1)){
                    kmap.put(ch1,kmap.get(ch1)+1);
                }
                if(kmap.get(ch1)==1){
                    count++;
                }
                i++;j++;
            }
        }

        System.out.println(ans);

    }
}