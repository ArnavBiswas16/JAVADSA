package tree;

import queue.*;
import queue.Queue;

import java.util.*;

import javax.swing.plaf.TextUI;

class BsTree{
    private static BsTree bstreeObj = null;
    public TreeNode root;

    public static BsTree getTree(){
        if(bstreeObj == null){
            bstreeObj = new BsTree();
            return bstreeObj;
        }
        return bstreeObj;
    }

    TreeNode insertNode(TreeNode root, int val){
    
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(val <= root.data){
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }
       return root;
    }

    BsTree createTree(int[] arr){

        int n = arr.length;
        if(n>0){
            BsTree bst = new BsTree();
            for(int i=0; i<n; i++){
                try{
                    bst.root = bst.insertNode(bst.root, arr[i]);
                } catch(Exception e){
                }
            }
            return bst;
        }
        return null;
    } 

    void inOrder(TreeNode root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        
        System.err.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);

        System.err.println(root.data);

    }

    void leftView(TreeNode root){
        
        if(root == null){
            return;
        }

        Queue q = Queue.createQueue();
        q.enqueue(null);
        q.enqueue(root);

        while(!q.que.isEmpty()){

            if(q.que.getFirst() == null){
                q.deque();
                if(!q.que.isEmpty()){
                    System.out.println(((TreeNode)q.que.getFirst()).data);
                    q.enqueue(null);
                }   
                
            } else {
                TreeNode node = (TreeNode)q.deque();

                if(node.left != null){
                    q.enqueue(node.left);
                }
                if(node.right != null){
                    q.enqueue(node.right);
                }
            }
        }
    }

    void rightView(TreeNode root){
        
        if(root == null){
            return;
        }

        Queue q = Queue.createQueue();
        q.enqueue(null);
        q.enqueue(root);

        while(!q.que.isEmpty()){

            if(q.que.getFirst() == null){
                q.deque();
                if(!q.que.isEmpty()){
                    System.out.println(((TreeNode)q.que.getFirst()).data);
                    q.enqueue(null);
                }
                
            } else {
                TreeNode node = (TreeNode)q.deque();

               
                if(node.right != null){
                    q.enqueue(node.right);
                }
                if(node.left != null){
                    q.enqueue(node.left);
                }
            }
        }
    }

    class Node{
        TreeNode treeNode;
        int hd;

        Node(TreeNode t, int hd){
            this.treeNode = t;
            this.hd = hd;
        }
    }
    void bottomTopView(TreeNode root, String flag){
        
        SortedMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        Queue q = Queue.createQueue();

        q.enqueue(new Node(root, 0));

        while(!q.que.isEmpty()){
            Node node = (Node)q.deque();
            if(m.containsKey(node.hd)){
                ArrayList<Integer> l = m.get(node.hd);
                l.add(node.treeNode.data);
                m.put(node.hd, l);
            } else {
                ArrayList<Integer> l = new ArrayList<>(); 
                l.add(node.treeNode.data);
                m.put(node.hd, l);
            }
            
            if(node.treeNode.left != null){
                q.enqueue(new Node(node.treeNode.left, node.hd-1));
            }

            if(node.treeNode.right != null){
                q.enqueue(new Node(node.treeNode.right, node.hd+1));
            }
        }

        for (Map.Entry mapElement : m.entrySet()) {  
            // Finding the value
            ArrayList<Integer> value = (ArrayList<Integer>)mapElement.getValue();
            
            if(flag.equals("bottom")){
                System.out.println(value.get(value.size()-1));
            }
            if(flag.equals("top")){
                System.out.println(value.get(0));

            }
        }
    }

    void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue q = Queue.createQueue();
        q.enqueue(root);

        q.enqueue(null);

        while(!q.que.isEmpty()){

            if(q.que.getFirst() == null){
                q.deque();
                if(!q.que.isEmpty()){
                    q.enqueue(null);
                    System.out.println("");
                }
                
            } else {
                TreeNode node = (TreeNode)q.deque();
                System.out.print(node.data +" ");
               

                if(node.left != null){
                    q.enqueue(node.left);
                }
                if(node.right != null){
                    q.enqueue(node.right);
                }
                
            }
        }
    }

    int height(TreeNode root){
        if(root  == null){
            return 0;
        } 
        return Math.max(height(root.left), height(root.right)) +1;
    }


    int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(height(root.left) + height(root.right), Math.max(diameter(root.left), diameter(root.right)));
    }


    boolean heightBalanced(TreeNode root){
        if(root ==  null){
            return true;
        }
        return(Math.abs(height(root.right) - height(root.left)) <= 1 && heightBalanced(root.left) && heightBalanced(root.right));
    }

    TreeNode lca(TreeNode root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        TreeNode left = lca(root.left, n1,n2);
        TreeNode right = lca(root.right, n1,n2);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        } else {
            return right;
        }
    }

    boolean identical(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }

        if(n1!=null && n2!=null){
                   
            return(n1.data == n2.data && identical(n1.left, n2.left) && identical(n1.right, n2.right));
            
        }
        return false;
    }

    TreeNode inPre(int[] inArr, int[] preArr){
        TreeNode root = new TreeNode(preArr[0]);
        int n = BsTree.indexOf(inArr, preArr[0]);
        if(n>-1){
            root.left = inPre(Arrays.copyOfRange(inArr, 0, n), Arrays.copyOfRange(preArr, 1, preArr.length));
            root.right = inPre(Arrays.copyOfRange(inArr, n+1, inArr.length), Arrays.copyOfRange(preArr, 1, preArr.length));
        }
        return root;
    }

    TreeNode inPost(int[] inArr, int[] postArr){
        int l = postArr.length-1;
        TreeNode root = new TreeNode(postArr[l]);
        int n = BsTree.indexOf(inArr, postArr[l]);
        if(n>-1){
            root.left = inPost(Arrays.copyOfRange(inArr, 0, n), Arrays.copyOfRange(postArr, 0, l));
            root.right = inPost(Arrays.copyOfRange(inArr, n+1, inArr.length), Arrays.copyOfRange(postArr, 0, l));
        }
        return root;
    }

    static int indexOf(int[] arr, int n){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }


    TreeNode flatten(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode last, right = null, left= null;
        if(root.right != null){
             right = flatten(root.right);
        }

        if(root.left != null){
             left = flatten(root.left);
        }

        root.right = left;
        last = root;
        while(last.right !=null){
            last = last.right;
        }

        if(left !=null){
            last.right = right;

        }

        return root;
    }

    boolean mirror(TreeNode left, TreeNode right){
        // System.out.println(left.data+" "+right.data);
        if(left == null && right == null){
            return true;
        }
        if(left != null && right !=null && left.data == right.data){
            return (mirror(left.left, right.right) && mirror(left.right, right.left));
        }
        return false;
    }

    TreeNode populateNextRightTree(TreeNode root){
        if(root == null){
            return null;
        }

        Queue q = new Queue();

        q.enqueue(root);
        q.enqueue(null);

        while(!q.que.isEmpty()){

            TreeNode n = (TreeNode)q.deque();
            
            if(n != null){
                if(q.seek() != null){
                    n.next = (TreeNode)q.seek();
                } 

                if(n.left != null){
                    q.enqueue(n.left);
                }

                if(n.right != null){
                    q.enqueue(n.right);
                }
            } else {
                if(!q.que.isEmpty()){
                    q.enqueue(null);
                }
            }
        }
        return root;
    }


    boolean btIsBst(TreeNode root){

        if(root == null){
            return true;
        }

        if(root.left != null && root.left.data>root.data){
            return false;
        }
        
        if(root.right != null && root.right.data <= root.data){
            return false;
        }

        return (btIsBst(root.left) || btIsBst(root.right));
    }


    void floorCeil(TreeNode root, int n){

        int floor=-1,ceil=-1;
        while(root != null){

            if(root.data == n){
                floor = root.data;
                ceil = root.data;
                System.out.println("floor="+floor +" ceil="+ceil);
                return;
            }
            if(root.data>n){
                floor = root.data;
                root = root.left;
            } else{
                ceil = root.data;
                root = root.right;
            }
        }
        System.out.println("floor="+floor +" ceil="+ceil);
        return;
    }

    TreeNode inPredecessor(TreeNode root, int n){
        if(root == null){
            return null;
        }
        if(root.data == n){
            root = root.left;
            while(root.right !=null){
                root = root.right;
            }
            return root;
        }
        if(root.data < n){
            inPredecessor(root.right, n);
        } else{
            inPredecessor(root.left, n);
        }
        return null;
    }

    TreeNode inSuccessor(TreeNode root, int n){
        if(root == null){
            return null;
        }
        if(root.data == n){
            root = root.right;
            while(root.left !=null){
                root = root.left;
            }
            return root;
        }
        if(root.data < n){
            inSuccessor(root.right, n);
        } else{
            inSuccessor(root.left, n);
        }
        return null;
    }

    boolean checkPairInBst(TreeNode root, int sum, HashSet<Integer> set){
        if(root == null){
            return false;
        }

        if(checkPairInBst(root.left, sum, set)){
            return true;
        }

        if(set.contains(sum-root.data)){
            System.out.println("pair found"+root.data+" "+(sum-root.data));
            return true;
        } else{
            set.add(root.data);
        }

         return checkPairInBst(root.right, sum, set);
         
    }

}
