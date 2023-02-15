//Iterative
// Time Complexity : O(n)
// Space Complexity : O(h) height of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return sum;

        dfs(root, low, high);

        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        //base
        if(root == null) return;

        //logic
        if(root.val > low)
            dfs(root.left, low, high);

        if(root.val >= low && root.val<=high) {
            sum = sum + root.val;
        }

        if(root.val < high)
            dfs(root.right, low, high);
    }
}


//Iterative
// Time Complexity : O(n)
// Space Complexity : O(h) hight of stack used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return sum;

        Stack<TreeNode> s = new Stack<>();

        while(root!=null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
            root = root.right;

        }

        return sum;
    }