import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:question_145
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @since :2024/4/2-20:13
 */
public class question_145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }

        void postorder(TreeNode root, List<Integer> result) {
            if (root == null)
                return;
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);

        }
    }
}
