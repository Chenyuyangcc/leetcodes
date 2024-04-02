import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:question_144
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *使用递归实现前序遍历
 * @since :2024/4/2-19:29
 */
public class question_144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        void preorder(TreeNode root, List<Integer> result) {
            if (root == null)
                return;
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
}
