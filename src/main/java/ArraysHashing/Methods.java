package ArraysHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Methods {
    // CONTAINS DUPLICATE
    // https://leetcode.com/problems/contains-duplicate/submissions/963172643/
    // https://leetcode.com/problems/contains-duplicate/submissions/963476365/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)) return true;
        }
        return false;
    }

    // VALID ANAGRAM
    // https://leetcode.com/problems/valid-anagram/submissions/963498013/
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] alphabet = new int[26];

        for(int i = 0; i<s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i<t.length(); i++){
            if(alphabet[t.charAt(i) - 'a']--==0) return false;
        }

        return true;
    }

    // TWO SUM
    // https://leetcode.com/problems/two-sum/submissions/964261893/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


}
