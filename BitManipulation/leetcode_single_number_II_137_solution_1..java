package BitManipulation;/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.

-- This BitManipulation.Solution uses the approach of counting bits and storing it in bitCount array
Time Complexity - O(N)
Space Complexity - O(1) - as the bitCount array is of size 32 which is constant
*/

class Solution {
    public int singleNumber(int[] nums) {
     
        int [] bitCount = new int[32];
        for(int i=0;i<32;i++){
            for(int n:nums){
                if((n&(1<<i))!=0)
                    bitCount[i]++;
                
                bitCount[i] %=3;
            }
        }
        
        int res =0;
        for(int i=0;i<32;i++){
            if(bitCount[i]==1){
                res = res | (1<<i);
            }
        }
        return res;
    }
}
