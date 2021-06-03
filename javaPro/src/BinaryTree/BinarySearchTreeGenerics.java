//package BinaryTree;
//
//public class BinarySearchTreeGenerics {
//    private Node<K,V> root = null;
//    private class Node<K extends Comparable<K>, V>{
//        private K key;
//        private V value;
//        private Node<K, V> left;
//        private Node<K,V> right;
//        private int N;
//        public Node(K key, V value, int N){
//            this.key = key;
//            this.value = value;
//            this.N = N;   // 保存以这个节点为根节点的子树节点数量
//        }
//    }
//
//    public int size(){
//        return size(root);
//    }
//    public int size(Node<K,V> node){
//        if(node==null) return 0;
//        else return node.N;
//    }
//
//    // 获取键的值
//    public <K extends Comparable<K>, V> V get(K key){
//        return get(root, key);
//    }
//    public <K extends Comparable<K>, V> V get(Node<K,V> node, K key){
//        if(node==null) return null;
//        int cmp = key.compareTo(node.key);
//        if(cmp>0) get(node.right, key);
//        else if(cmp<0) get(node.left, key);
//        return node.value;
//    }
//
//    // 插入一个节点
//    public <K extends Comparable<K>, V> void put(K key, V val){
//        root = put(root, key, val);
//    }
//    public <K extends Comparable<K>, V> Node<K,V> put(Node<K,V> node, K key, V val){
//        if(node==null) return new Node<K,V>(key, val, 1);
//        int cmp = key.compareTo(node.key);
//        if(cmp>0) node.right = put(node.right, key, val);
//        else if(cmp<0) node.left = put(node.left, key, val);
//        else node.value = val;
//        node.N = size(node.left) + size(node.right) + 1;
//        return node;
//    }
//
//    public static void main(String[] args){
//        BinarySearchTreeGenerics bst = new BinarySearchTreeGenerics();
//        bst.get("123");
//    }
//}
