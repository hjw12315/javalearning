package BinaryTree;

import java.util.*;

public class BinarySearchTree {
    Node root = null;
    private class Node{
        private int value;
        private Node right, left;
        public Node(int value){
            this.value = value;
        }
    }


    // 查询节点
    public boolean get(int value){
        return get(root, value);
    }
    public boolean get(Node node, int value){
        if(node==null) return false;
        int cmp = Integer.compare(value, node.value);
        if(cmp>0) get(node.right, value);
        else if(cmp<0) get(node.left, value);
        return true;
    }


    // 插入节点
    public void put(int value){
        root = put(root, value);
    }
    public Node put(Node node, int val){
        if(node==null) return new Node(val);
        int cmp = Integer.compare(val, node.value);
        if(cmp>0) node.right = put(node.right, val);
        else if(cmp<0) node.left = put(node.left, val);
        return node;
    }

//    // 删除节点
//    public Node delete(int value){
//        if(root==null) return null;
//        // 要先判断是否为叶子结点,或者删除的节点只有一个子节点,
//        // 或者删除的节点有两个子节点: 用比删除节点大的最小节点来替换删除节点，或者用比删除节点小的最大节点来替换删除节点
//        Node current = root;
//        Node pre = root;
//        while(current.value!=value){
//            if(value>current.value){
//                pre = current;
//                current = current.right;
//            }else{
//                pre = current;
//                current = current.left;
//            }
//            if(current==null)  // 没找到对应节点
//                return null;
//        }
//        // 叶子节点
//        if(current.left==null && current.right==null){
//            if(current==root)    // 考虑匹配节点是根节点
//                root = null;
//            else
//                if(pre.right==current)
//                    pre.right = null;
//                else
//                    pre.left = null;
//        }
//        // 只有一个节点，判断是左子节点还是右子节点
//        else if(current.left==null || current.right==null){
//            if(current==root){  // 考虑匹配节点是根节点
//                if(current.right!=null)
//                    root = current.right;
//                else
//                    root = current.left;
//            }else{
//                if(pre.right==current) {
//                    if(current.right!=null)
//                        pre.right = current.right;
//                    else
//                        pre.right = current.left;
//                }
//                if(pre.left==current){
//                    if(current.right!=null)
//                        pre.left = current.right;
//                    else
//                        pre.left = current.left;
//                }
//            }
//        }
//        // 有两个子节点，则要找到左子树最小的那个节点来替代匹配节点，
//        // 又分为两种情况，一种是最小的是叶节点，另一种是叶节点的前一个节点(这种比较麻烦)
//        else{
//            Node lastLeft = current;
//            Node lastPreLeft = current;
//            while(lastLeft.left!=null){
//                lastPreLeft = lastLeft;
//                lastLeft = lastLeft.left;
//            }
//            if(current==root){  // 如果是根节点的话，则一定是在左子树上搜索，又要分两种情况
//                Node rootLeft = root.left;
//                Node rootRight = root.right;
//                while(rootRight.left!=null){
//                    rootRight = rootRight.left;
//                }
//                if(lastLeft.right==null){  // 最小节点为叶子节点
//                    root = lastLeft;
//                    lastPreLeft.left = null;
//                    rootRight.left = rootLeft;
//                }else{  // 最小节点非叶子节点
//
//                }
//
//            }else{
//                if(lastLeft.right==null){    // 最小节点为叶子节点
//                    if(pre.right==current){  // 判断匹配节点是前一个节点的左节点还是右节点
//                        pre.right = lastLeft;
//                        lastPreLeft.left = null;
//                    }else{
//                        pre.left = lastLeft;
//                        lastPreLeft.left = null;
//                    }
//                }
//                else{ // 非叶子节点，是不是要把该节点的右子树接到current节点的左子树的最后一个节点
//                    Node currentRight = current.right;
//                    while(currentRight.left!=null){
//                        currentRight = currentRight.left;
//                    }
//                    if(pre.right==current){
//                        pre.right = lastLeft;
//                        currentRight.left = lastLeft.right;
//                    }else{
//                        pre.left = lastLeft;
//                        currentRight.left = lastLeft.right;
//                    }
//                }
//            }
//        }
//
//        return current;
//    }

    // 删除节点，思路一：分三种情况讨论
    // 匹配到的节点只有一个子节点，匹配到的节点有两个子节点
    public Node deleteMethodOne(Node root, int value){
        if(root==null){
            return null;
        }
        if(root.value>value){
            root.left = deleteMethodOne(root.left, value);
            return root;
        }else if(root.value<value){
            root.right = deleteMethodOne(root.right, value);
            return root;  // 没找到则返回根节点
        }
        // 到达此处说明已经找到节点
        // 该节点有一个子节点
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }
        // 该节点有两个子节点
        Node minLeftNode = root.right;
        while(minLeftNode.left!=null){
            minLeftNode = minLeftNode.left;
        }
        root.value = minLeftNode.value;
        root.right = deleteMinLeftNode(root.right); // 后继节点的右子树上移
        return root;
    }
    private Node deleteMinLeftNode(Node node){
        if(node.left==null){
            Node right = node.right;
//            node.right = null;  // 这里有必要吗？ 力扣测试不用也可以
            return right;       // 如果用于替换的那个节点有右子树，则右子树要向上移动；没有右子树则返回null
        }
        node.left = deleteMinLeftNode(node.left);
        return node;
    }

    // 思路二：匹配到的节点有两个子节点时，将此节点的左子树放到右子树的最小节点的左边
    public Node deleteMethodTwo(Node root, int value){
        if(root==null){
            return null;
        }
        if(root.value>value){
            root.left = deleteMethodTwo(root.left, value);
        }else if(root.value<value){
            root.right = deleteMethodTwo(root.right, value);
        }else{
            if(root.right==null){ return root.left; }
            else if(root.left==null){ return root.right; }
            else{
                Node minLeftNode = root.right;
                while(minLeftNode.left!=null)
                    minLeftNode = minLeftNode.left;
                // 将该节点的左子树放到右子树的最小左节点的左下方；这个方法会增加树的高度
                minLeftNode.left = root.left;
                return root.right;  // 右子树上移
            }
        }
        return root;
    }


    // 查询树的最大深度
    public int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; // 每棵左右子树的最大深度加 1
    }

    // 判断一棵二叉搜索树是不是平衡二叉树
    // 自顶向下，先判断大树，再判断小树
    public boolean isBalancedToB(Node root){
        if(root==null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1) // 先判断树的高度差是否符合平衡二叉树，再判断左右两棵树是不是平衡二叉树
            return false;
        return isBalancedToB(root.left) && isBalancedToB(root.right); // 如果有一棵子树不是平衡的直接退出
    }
    // 自底向上，先判断小树，再判断大树
    // 结束递归的条件，返回什么东西，每一轮递归要做什么东西
    // 节点为空的时候结束递归  返回子树的高度  判断子树的高度差
    public boolean isBalancedBoT(Node root){
        if(root==null) return true;
        return BoT(root)!=-1;
    }
    public int BoT(Node root){
        if(root==null) return 0;
        int leftDepth = BoT(root.left);
        if (leftDepth==-1) return -1;  // 有必要啊
        int rightDepth = BoT(root.right);
        if (rightDepth==-1) return -1;
        if(Math.abs(leftDepth-rightDepth)>1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }


    // DFS非递归打印二叉查找树
    public void printDFS(){
        if (root==null) return;
        Stack<Node> stack = new Stack<>();   // 使用堆做DFS
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
            list.add(node.value);
            if (node.right!=null) {  // 要先把右边的压入栈，因为DFS先对左边的进行搜索
                stack.push(node.right);
                // System.out.println("right: " + node.right.value);
            }
            if (node.left!=null) {
                stack.push(node.left);
                // System.out.println("left: " + node.left.value);
            }
        }
        System.out.println(list);
    }
    // 递归版 前序
    public void printFormer(Node root){
        if (root==null) return;
        System.out.print(root.value + " ");
        printFormer(root.left);
        printFormer(root.right);
    }
    // 中序遍历: 左子树——>根节点——>右子树
    public void printMiddle(Node root){
        if(root==null) return;
        printMiddle(root.left);
        System.out.print(root.value + " ");
        printMiddle(root.right);
    }
    // 后序遍历: 左子树——>右子树——>根节点
    public void printBack(Node root){
        if(root==null) return;
        printBack(root.left);
        printBack(root.right);
        System.out.print(root.value + " ");
    }


    // BFS打印二叉查找树
    public void printBFS(){
        if (root==null) return;
        Queue<Node> deque = new LinkedList<>();  // 使用队列做BFS，先进先出
        ArrayList<Integer> list = new ArrayList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            Node node = deque.poll();
            list.add(node.value);
            if(node.left!=null){
                deque.offer(node.left);
            }
            if(node.right!=null){
                deque.offer(node.right);
            }
        }
        System.out.println(list);
    }
    // BFS记录每层的节点
    public List<List<Integer>> recordEachLayerNode(){
        List<List<Integer>> listOuter = new ArrayList<>();
        if(root==null) return listOuter;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> listInner = new ArrayList<>();
            int size = queue.size();   // 每一层的节点个数
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                listInner.add(node.value);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            listOuter.add(listInner);
        }
        return listOuter;
    }


    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(3);
        bst.put(1);
        bst.put(5);
        bst.put(0);
        bst.put(2);
        bst.put(9);
        bst.put(3);
        bst.put(6);
        bst.put(10);
        bst.put(4);
        System.out.println(bst.get(0));
        System.out.println("DFS: ");
        bst.printDFS();
        bst.printFormer(bst.root);
        System.out.println();
        bst.printMiddle(bst.root);
        System.out.println();
        bst.printBack(bst.root);
        System.out.println();
        System.out.println("BFS: ");
        bst.printBFS();
        System.out.println(bst.recordEachLayerNode());
        bst.deleteMethodOne(bst.root, 3);
        bst.deleteMethodTwo(bst.root, 1);
        System.out.println("删除节点之后的DFS: ");
        bst.printDFS();
        System.out.println(bst.recordEachLayerNode());
        System.out.println(bst.isBalancedToB(bst.root));
        System.out.println(bst.isBalancedBoT(bst.root));
    }
}
