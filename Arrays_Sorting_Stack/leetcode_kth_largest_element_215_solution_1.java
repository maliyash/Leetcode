/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int smallest = nums.length-k;
        return helper(nums,0,nums.length-1,smallest);
    }
    
    public int helper(int [] nums ,int l, int r, int k){
        int pivotPosition = quickSelect(l,r,nums);
        if(pivotPosition==k)
            return nums[k];
        
        else if(pivotPosition < k)
            return helper(nums,pivotPosition+1,r,k);
        
        else
            return helper(nums,l,pivotPosition-1,k);
    }
  
    public int quickSelect(int l, int r, int [] nums){     
        // Choose a random pivot and swap with first element
        int random = (int)((Math.random() * (r-l)) + l);
        int t = nums[random];
        nums[random] = nums[l];
        nums[l]=t;    
        //choose first element as pivot (randomly choosen)
        int pivot = nums[l];
        int start = l;
        l++;
        while(l<=r){
            if(nums[l]>pivot && nums[r]<=pivot){
                int temp = nums[l];
                nums[l] =nums[r];
                nums[r]=temp;
                l++;
                r--;
                continue;
            }
            if(nums[l]<=pivot)
                l++;
                
            if(nums[r]>pivot)
                r--;
            
        }    
        t = nums[r];
        nums[r] = nums[start];
        nums[start] = t;
        return r;   
    }
}
