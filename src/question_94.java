import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:question_94
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @Create:2024/4/3-9:22
 */
public class question_94 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.peek();
                    stack.pop();
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
            return result;
        }
    }
}
