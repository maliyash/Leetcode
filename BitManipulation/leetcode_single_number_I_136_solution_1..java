package BitManipulation;/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
Example 1:

Input: nums = [2,2,1]
Output: 1

*/

class Solution {
    public int singleNumber(int[] nums) {
       int res =0;
        for(int num: nums){
            res = res ^ num;
        }
        return res;
    }
}
