package com.example.wpclc.lc;

import java.util.*;

/**
 * @author wangpengcheng
 * @version 1.0
 * @Description
 * @date 2023/6/8 16:37
 */
public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            // 统计每个string出现的次数
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        // 自定义排序器，如果两个元素相同就按字典排序，如果不同就按照出现的次数排序
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        // 对排序后的list进行取出前k个
        return rec.subList(0, k);
    }
}
