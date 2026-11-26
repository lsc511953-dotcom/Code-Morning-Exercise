import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    private static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public TreeNode root;

    public void createNode() {
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        nodeE.right = nodeH;

        root = nodeA;
    }

    //前序遍历
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

    //经典题目
    //获取节点个数
    public int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    //获取叶子节点个数
    public int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    //获取第k层节点个数
    public int getLevelNodeCount(TreeNode root,int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getLevelNodeCount(root.left,k - 1) + getLevelNodeCount(root.right,k - 1);
    }

    //获取二叉树高度
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    //查找值为val的节点
    public TreeNode find(TreeNode root,char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        return find(root.right,val);
    }

    //判断是否是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                break;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                return false;
            }
        }
        return true;
    }
}
