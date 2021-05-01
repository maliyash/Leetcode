/*
Danik urgently needs rock and lever! Obviously, the easiest way to get these things is to ask Hermit Lizard for them.

Hermit Lizard agreed to give Danik the lever. But to get a stone, Danik needs to solve the following task.

You are given a positive integer 𝑛, and an array 𝑎 of positive integers. The task is to calculate the number of such pairs (𝑖,𝑗) that 𝑖<𝑗 and 𝑎𝑖 & 𝑎𝑗≥𝑎𝑖⊕𝑎𝑗, where & denotes the bitwise AND operation, and ⊕ denotes the bitwise XOR operation.

Danik has solved this task. But can you solve it?

Input
Each test contains multiple test cases.

The first line contains one positive integer 𝑡 (1≤𝑡≤10) denoting the number of test cases. Description of the test cases follows.

The first line of each test case contains one positive integer 𝑛 (1≤𝑛≤105) — length of the array.

The second line contains 𝑛 positive integers 𝑎𝑖 (1≤𝑎𝑖≤109) — elements of the array.

It is guaranteed that the sum of 𝑛 over all test cases does not exceed 105.

Output
For every test case print one non-negative integer — the answer to the problem.
*/

class Solution{

    public int findPairs(int [] nums){
        int msb [] = new int [32];
        int res =0;
        for(int num:nums){
            findMSB(nums,msb);
        }
        for(int i=0;i<32;i++){
            res + = ((msb[i])/(msb[i]-2)*2);
        }
        return res;
    }

    public void findMSB(int num,int msb []){
        int n = num;
        n|= n>>1;
        n|=n>>2;
        n|=n>>4;
        n|=n>>8;
        n|=n>>16;
        n = n+1;
        num = (n>>1)&num;
        num = (int)(Math.log(N) / Math.log(2));
        msb[num]++;
    }


}
