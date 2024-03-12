class Solution {
    public int maxArea(int[] height) {

        int area =0;
        int max_area =0;
        for(int i =0; i< height.length(); i++){
            for (int j= height.length()-1; j>i; j--){
                area = (min(a[i],a[j]))*[j-i];
                if (max_area < area){
                    max_area = area;
                } 
            }
        }
        return max_area;
    }
}