class Solution {
    public int getMax(int[] A){
        int maxval = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            maxval = Math.max(A[i], maxval);
        }
        return maxval;
    }
    public boolean isAllNegative(int[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]>=0)
                return false;
        }
        return true;
    }
    public int maxSubArray(int[] A) {
        if (isAllNegative(A)){
            return getMax(A);
        }
        int result = 0;
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            sum = Math.max(sum,0);
            result = Math.max(result,sum);
        }
        return result;
    }
}