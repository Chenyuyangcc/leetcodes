/**
 * ClassName:question_101
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @Create:2024/4/7-14:50
 */
public class question_101 {
    public class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            else
                return compare(root.left, root.right);
        }

        boolean compare(TreeNode left, TreeNode right) {
            if (left == null && right != null)
                return false;
            else if (left != null && right == null) {
                return false;
            } else if (right == null) {
                return true;
            } else if (left.val != right.val) {
                return false;
            } else {
                boolean out = compare(left.left, right.right);
                boolean in = compare(left.right, right.left);
                return in && out;
            }
        }
    }
}
