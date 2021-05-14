/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105

*/

class Solution {
    public int trap(int[] nums) {
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = nums.length-1;
        int water = 0;

        while(i<=j){
            int cur_water = 0;
            if(nums[i]<=nums[j]){
                cur_water = leftMax - nums[i];
                if(cur_water>0)
                    water+= cur_water;

                leftMax = Math.max(leftMax,nums[i]);
                i++;
            }
            else{
                cur_water = rightMax - nums[j];
                if(cur_water>0)
                    water+= cur_water;

                rightMax = Math.max(rightMax,nums[j]);
                j--;
            }

        }

        return water;
    }
}