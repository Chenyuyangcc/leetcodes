/**
 * ClassName:question_104
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @Create:2024/4/7-15:23
 */
public class question_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        class Solution {
            public int maxDepth(TreeNode root) {
                if (root == null)
                    return 0;
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return 1 + Math.max(leftHeight, rightHeight);
            }
        }
    }
}
