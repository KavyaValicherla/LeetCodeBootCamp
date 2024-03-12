class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String S, int K) {
        if(S==null||S.length()==0)
            return 0;
        int N = S.length(), windowStart=0, windowEnd=0, result=1, maxRepeatCount=0;
        HashMap<Character,Integer> M = new HashMap<>();
        for(windowEnd=0;windowEnd<N;windowEnd++){
            M.put(S.charAt(windowEnd), M.getOrDefault(S.charAt(windowEnd),0)+1);
            maxRepeatCount = Math.max(maxRepeatCount, M.get(S.charAt(windowEnd)));
            if(windowEnd-windowStart-maxRepeatCount+1>K){
                M.put(S.charAt(windowStart),M.get(S.charAt(windowStart))-1);
                windowStart++;
            }
            result = Math.max(result, windowEnd-windowStart+1);
        }
        return result;
    }
}