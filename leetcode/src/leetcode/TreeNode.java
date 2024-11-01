package leetcode;

import java.util.*;

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

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        TreeNode temp;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            temp = stack.pop();
            list.add(temp.val);

            if (temp.right != null){
                stack.add(temp.right);
            }
            if (temp.left != null){
                stack.add(temp.left);
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.add(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Stack<TreeNode> stack1, stack2;
        stack1 = new Stack<>();
        stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.add(root);

            if (root.left != null){
                stack1.add(root.left);
            }
            if (root.right != null){
                stack1.add(root.right);
            }

        }

        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int currentNodes, maxNodes, currentLevel;

        map.put(root, 1);
        queue.add(root);
        maxNodes = Integer.MIN_VALUE;
        currentNodes = 0;
        currentLevel = 1;

        List<Integer> tmp = new ArrayList<>();

        while (!queue.isEmpty()){
            root = queue.poll();

            if (map.get(root) == currentLevel){
                currentNodes ++;
                tmp.add(root.val);
            }else {
                currentLevel ++;
                maxNodes = Math.max(maxNodes, currentNodes);
                currentNodes = 1;

                list.add(tmp);
                tmp.clear();
            }
            if (root.left != null){
                map.put(root.left, map.get(root) + 1);
                queue.add(root.left);
            }
            if (root.right != null){
                map.put(root.right, map.get(root) + 1);
                queue.add(root.right);
            }
        }

        return list;
    }

}
