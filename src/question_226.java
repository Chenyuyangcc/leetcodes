/**
 * ClassName:question_226
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @Create:2024/4/7-14:18
 */
public class question_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
            swapChildren(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        void swapChildren(TreeNode root) {
            TreeNode temp;
            temp = root.left;
            root.left = root.right ;
            root.right = temp;
        }
    }
}
