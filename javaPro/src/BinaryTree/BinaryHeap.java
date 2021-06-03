package BinaryTree;

import java.util.*;

public class BinaryHeap {
    class HeapNode{
        private String key;
        private int value=1;
        public HeapNode(String key){
            this.key = key;
        }
    }
    private int N=0;
    private HeapNode[] heap;
    public BinaryHeap(int length){
        heap = new HeapNode[length+1];
    }
    // 二叉堆插入节点, 插入的时候还要考虑节点是否已经出现过，如果出现过则节点值加1并且上浮到合适的位置
    public void add(HeapNode node){
        heap[++N] = node;
        // 上浮的过程中的要判断是否是存在的节点
        int k = N;
        while(k>1 && node.value>heap[k/2].value){
            if(!node.key.equals(heap[k/2].key)){
                HeapNode temp = heap[k];
                heap[k] = heap[k/2];
                heap[k/2] = temp;
                k = k/2;
            }else{

            }
        }

    }
    // 二叉堆删除节点
    public int size(){
        return N;
    }

}


