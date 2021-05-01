package BitManipulation;/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1

-- This BitManipulation.Solution is Moore's Voting algorithm for finding majority element
Logic - Candidate count is increased by one if candidate == nums[i] otherwise count is decreased by 1
when count is 0 change the candidate and reset count to 1
As majority element exists > N/2 times in the array, this algorithm guarantees that the final candidate is majority element.

Assumption:
This solution assumes that the array always contatin majority element, otherwise we need to verify the candidate
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count= 1;
        int candidate = nums[0];
        for(int i=1;i<nums.length;i++){
            if(candidate == nums[i])
                count++;
            else
                count--;
            
            if(count==0){
                candidate = nums[i];
                count=1;
            }
        }        
        return candidate; 
    }
}
