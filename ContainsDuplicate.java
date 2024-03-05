class Solution {
    public boolean containsDuplicate(int[] A) {

        HashSet<Integer> set = new HashSet();
        for(int i=0; i< A.length; i++){
           if(set.contains(A[i])){
               return true;
           }else {
               set.add(A[i]);
           }
        }
        
        return false;
    }
}