package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {

    // Valid Palindrome
    // https://leetcode.com/problems/valid-palindrome/submissions/970922528/
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

            i++;
            j--;
        }

        return true;
    }

    // Two Sum II - Input array is sorted
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/970941682/
    public int[] twoSum(int[] numbers, int target) {
        int p1=0, p2 = numbers.length-1;
        while(numbers[p1]+numbers[p2] != target){
            if(numbers[p1]+numbers[p2]>target) p2--;
            else p1++;
        }
        return new int []{p1+1,p2+1};
    }

    // Three Sum
    // https://leetcode.com/problems/3sum/submissions/970949746/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);
        for(int k = 0; k<nums.length; k++){
            if(k>0 && nums[k-1]==nums[k])continue;
            if(nums[k]>0) break;

            int i=k+1,j=nums.length-1;
            while(i<j){
                if(nums[k]+nums[i]+nums[j]<0) i++;
                else if(nums[k]+nums[i]+nums[j]>0) j--;
                else if(nums[k]+nums[i]+nums[j]==0){
                    ret.add(List.of(nums[k],nums[i],nums[j]));
                    i++;
                    while(nums[i]==nums[i-1] && i<j) i++;
                }
            }
        }

        return ret;
    }

    // maxArea
    // https://leetcode.com/problems/container-with-most-water/submissions/971004019/
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length-1;
        int max=0;
        int iH;
        int jH;

        while(i<j){
            iH = height[i];
            jH = height[j];

            int area = (j-i) * (iH<jH ? iH : jH);
            max = max<area ? area : max;
            if(iH<jH){
                while(i<j && height[i]<=iH){
                    i++;
                }
            }
            else{
                while(i<j && height[j]<=jH){
                    j--;
                }
            }
        }

        return max;
    }

    // trap
    // https://leetcode.com/problems/trapping-rain-water/submissions/971065371/
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;

        int mxL = height[i];
        int mxR = height[j];

        int res = 0;

        while(i<j){
            if(height[i]<=height[j]){
                i++;
                int amount = Math.min(mxL,mxR) - height[i];
                res+= amount<0 ? 0 : amount;
                mxL = Math.max(mxL, height[i]);
            }
            else{
                j--;
                int amount = Math.min(mxL,mxR) - height[j];
                res+= amount<0 ? 0 : amount;
                mxR = Math.max(mxR, height[j]);
            }
        }

        return res;
    }



}
