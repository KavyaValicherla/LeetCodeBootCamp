class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentlength = queue.size();
            int prev= 0;
            for(int i=0; i< currentlength; i++){
                TreeNode node = queue.remove();
                prev =node.val;
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
                
            }
            ans.add(prev);
        }
        return ans;
    }
}