package com.example.wpclc.lcm;

import java.util.*;

/**
 * @author wangpengcheng
 * @version 1.0
 * @Description
 * @date 2023/6/8 17:10
 */
public class LCM692 {
    public List<String> topKFrequent(String[] words, int k) {
        //给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
        //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
        //words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
      //1.统计每个string出现的次数,使用map来进行统计
        HashMap<String, Integer> map = new HashMap<>();
        for (String word:words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        // 1.2对键进行排序
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        //2.对进行排序，如果相同则按照字典顺序来排
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2)-map.get(o1);
            }
        });
        //3.输出出现次数最多的k个string
      return list.subList(0,k);
    }
}
