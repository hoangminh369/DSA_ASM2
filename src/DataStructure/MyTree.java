package DataStructure;

// Implement Tree in java
// Node(value, leftNode, rightNode)

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class MyTree {
    // Nút gốc root
    public TreeNode root;

    public MyTree() {
        this.root = null;
        TreeNode n1 = new TreeNode(18);
        TreeNode n2 = new TreeNode(12);
        TreeNode n3 = new TreeNode(35);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(22);
        TreeNode n7 = new TreeNode(58);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(7);
        TreeNode n10 = new TreeNode(13);
        TreeNode n11 = new TreeNode(16);
        TreeNode n12 = new TreeNode(19);
        TreeNode n13 = new TreeNode(31);
        TreeNode n14 = new TreeNode(40);
        TreeNode n15 = new TreeNode(87);

        // Xây dựng cây:
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;
        root = n1;
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.value);
            print(root.right);
        }
    }

    public boolean contains(TreeNode root, int target) {
        if (root == null) {
            return false; // Base case: target not found
        }
        if (root.value == target) {
            return true; // Target found
        }
        // Recur to left or right subtree
        return contains(root.left, target) || contains(root.right, target);
    }
}
