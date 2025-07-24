package com.stream.stream.leetcode;

import java.util.HashMap;

public class Leetcode {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target= 9;

        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
          int   complement=target-nums[i];

          if(valueIndexMap.containsKey(complement)){
              System.out.println(valueIndexMap.get(complement)+" "+i);
          }

          valueIndexMap.put(nums[i],i);
        }


    }
}
