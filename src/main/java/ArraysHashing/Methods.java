package ArraysHashing;

import java.util.*;

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

    // GROUP ANAGRAMS
    // https://leetcode.com/problems/group-anagrams/submissions/964364331/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);

            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                map.put(key, new ArrayList<String>(List.of(strs[i])));
            }
        }

        return new ArrayList<>(map.values());
    }




}
