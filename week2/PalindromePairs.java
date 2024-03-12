class PalindromePairs {
    private static boolean isPalindrome(String S){
        if (S == null || S.length() == 0){
            return true;
        }

        int p = 0, q = S.length() - 1;

        while(p < q){
            if (S.charAt(p) != S.charAt(q)){
                return false;
            }
            p++;
            q--;
        }

        return true;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<words.length;i++){
            for (int j=0;j<words.length;j++){
                if (i != j){
                    if (isPalindrome(words[i]+words[j])){
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(i); pair.add(j);
                        result.add(pair);
                    }
                }
            }
        }

        return result;
    }
}