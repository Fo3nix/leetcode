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


    // top k frequent elements
    // https://leetcode.com/problems/top-k-frequent-elements/submissions/965225863/
    public int[] topKFrequent(int[] nums, int k) {

        // mapping number to amount of times it is in the array
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];

        for(int key : map.keySet()){
            int mapVal = map.get(key);
            if(buckets[mapVal]==null) buckets[mapVal] = new ArrayList<>();
            buckets[mapVal].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length-1; i>0; i--){
            if(buckets[i]!=null) {
                for(int num : buckets[i]){
                    res[index++] = num;
                }
            }
            if(index==k) break;
        }

        return res;
    }

    // PRODUCT OF ARRAY EXCEPT SELF
    // https://leetcode.com/problems/product-of-array-except-self/submissions/965284973/
    public int[] productExceptSelf(int[] nums) {

        int[] res = nums.clone();
        for(int i = 1; i<nums.length; i++){
            res[i]=res[i]*res[i-1];
        }

        int val = 1;
        for(int i = nums.length-1; i>0; i--){
            res[i] = res[i-1]*val;
            val = val*nums[i];
        }
        res[0]=val;

        return res;

    }


    //  VALID SUDOKU
    // https://leetcode.com/problems/valid-sudoku/submissions/966581515/
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] columns = new int[81];
        int[] boxes = new int[81];

        int num = 0;

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                num = board[i][j];
                if(num == 46) continue;
                num -= 49;

                if(row[num]==1 || columns[(j*9)+num]==1 || boxes[(i/3)*27+(j/3)*9+num]==1) return false;

                row[num]=1;
                columns[(j*9)+num]=1;
                boxes[(i/3)*27+(j/3)*9+num]=1;
            }

            for(int j = 0; j<9; j++){
                row[j]=0;
            }
        }
        return true;
    }

    // longest consecutive sequence
    // https://leetcode.com/problems/longest-consecutive-sequence/submissions/966736350/
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){set.add(n);}

        int count = 1;
        int max = 1;

        for(int n : set){
            if(!set.contains(n-1)){
                int num = n+1;
                while(set.contains(num++)){
                    count++;
                }
            }
            max = Math.max(count,max);
            count=1;
        }

        return max;
    }



}
