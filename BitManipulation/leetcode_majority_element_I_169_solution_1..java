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
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

--This solution makes use of an auxillary array of size 32 to keep a count of number of bits set at each position

Ideally as we only use an auxillary array of fixed space -> space complexity is O(1)
Time Complexity -> O(N)

A better approach is to use Moore's Voting algorithm which would be coded in solution 2 for this problem.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int [] bitCount = new int[32];
        for(int i=0;i<32;i++){
            for(int n:nums){
                if((n&(1<<i))!=0)
                    bitCount[i]++;
            }
        }
        
        int res =0;
        for(int i=0;i<32;i++){
            if(bitCount[i]>(nums.length/2)){
                res = res | (1<<i);
            }
        }
        return res;
    }
}
