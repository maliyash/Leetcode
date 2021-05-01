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