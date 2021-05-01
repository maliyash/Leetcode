/*
There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.

It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].

Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.



Example 1:

Input: encoded = [3,1]
Output: [1,2,3]
Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
Example 2:

Input: encoded = [6,5,4,6]
Output: [2,4,1,5,3]


Constraints:

3 <= n < 105
n is odd.
encoded.length == n - 1

Solution:

eg input [3,1] -> input size is 2, so number of elements are a,b,c

we know that
1.a^b = 3
2.b^c = 1

Combining 1 and 2 -> a^b^b^c = a^c = 2

3. a^c

We can find out a^b^c because we know numbers start from 1 and to size of input + 1 ie 1 to 3 in this case

4. a^b^c = 0

Find out the first element by combining equations 4 and 2
  a^b^c^b^c = a = 1

5. a =1

So from equation 5 and 1 we can find out b -> 2

Similarly we can find out all other elements

*/

class Solution {
    public int[] decode(int[] encoded) {
        int all_xor = 0;
        int res [] = new int [encoded.length+1];

        for(int i=1;i<=res.length;i++){
            all_xor = all_xor^i;
        }

        for(int i=1;i<encoded.length;i=i+2){
            all_xor = all_xor ^ encoded[i];
        }
        res[0] = all_xor;
        for(int i=0;i<encoded.length;i++){
            all_xor = all_xor ^ encoded[i];
            res[i+1] = all_xor;
        }

        return res;
    }
}

