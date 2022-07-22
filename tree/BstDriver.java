package tree;

import java.util.HashSet;

public class BstDriver {
   
    public static void main(String[] args) {
        BsTree bst = new BsTree();
        int[] treeArr = {5,2,3,6,1,7,4};

        int[] treeArr1 = {1,2,3,4,5,8};
        // int[] treeArr = {5,2,6};

        BsTree tree =  bst.createTree(treeArr);
        BsTree tree2 = bst.createTree(treeArr1);
        // bst.inOrder(tree.root);
        // bst.preOrder(tree.root);
        // bst.postOrder(tree.root);
        // bst.leftView(tree.root);
        // bst.rightView(tree.root);
        // bst.bottomTopView(tree.root, "bottom");
        // bst.bottomTopView(tree.root, "top");
        // bst.levelOrder(tree.root);
        // System.out.println(bst.height(tree.root)-1);
        // System.err.println(bst.diameter(tree.root));
        // System.out.println(bst.heightBalanced(tree.root));
        // System.out.println(bst.lca(tree.root, 1, 4).data);
        // System.out.println(bst.identical(tree.root, tree2.root));
        int[] in = {2,1,3,5,3,1,2};
        int[] pre = {5,1,2,3,1,3,2};
        // int[] post = {1,3,2,7,6,5};

        // System.out.println(bst.inPre(in, pre).left.data);
        // System.out.println(bst.inPost(in, post).right.left.data);
        // System.out.println(bst.flatten(tree.root).right.right.data);
        TreeNode mirrorRoot = bst.inPre(in, pre);
        // System.out.println( bst.mirror(mirrorRoot.left, mirrorRoot.right));

        // System.out.println(bst.populateNextRightTree(tree.root).left.next.data);
        // System.out.println(bst.btIsBst(mirrorRoot));
        // bst.floorCeil(tree.root, 5);
        // System.err.println(bst.inPredecessor(tree.root, 5).data);
        // System.err.println(bst.inSuccessor(tree.root, 5).data);
        HashSet<Integer> h = new HashSet<Integer>(); 
        bst.checkPairInBst(tree.root, 10, h);

    }
    
}
