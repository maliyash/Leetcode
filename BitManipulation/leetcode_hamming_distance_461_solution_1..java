package BitManipulation;/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1
--BitManipulation.Solution

Bits that are diff can be found by x^y
The number of bits that are different can be found by Brian Kernighan's Algorithm

*/

class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int counter =0;
        while(res!=0){
            res = res&(res-1);
            counter++;
        }
        return counter;
    }
}
