package BitManipulation;/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

-- This solution makes use of Bitwise operator xor, ~, & 
Logic -> ones - this would have bit set if bit occurs 1,4,7,10,....  while iterating through entire array
         twos - this would have bit set if bit occurs 2,5,8,11,.... while iterating through the entire array 
Finally ones would contain the single element that we require

*/

class Solution {
    public int singleNumber(int[] nums) {
        int ones =0;
        int twos =0;
        for(int n:nums){
            ones = ~twos & (ones^n);
            twos = ~ones & (twos^n);
        }
        return ones; 
    }
}
