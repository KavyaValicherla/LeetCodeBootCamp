class Solution {
    public int findKthLargest(int[] nums, int k) {
       
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num > heap.peek()) {
                heap.poll(); 
                heap.add(num);
            }
        }
        return heap.peek();
    }
}