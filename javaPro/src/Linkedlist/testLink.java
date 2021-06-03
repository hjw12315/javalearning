package Linkedlist;

public class testLink {

    private Node head;

    private static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    public void addNode(int d){
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    // 链表排序，只需要交换数据
    public void orderList(){
        Node tmp = head;
        while(tmp!=null){
            Node pNext = tmp.next;
            while(pNext!=null){
                if(tmp.data>pNext.data){
                    int temp = pNext.data;
                    pNext.data = tmp.data;
                    tmp.data = temp;
                }
                pNext = pNext.next;
            }
            tmp = tmp.next;
        }
    }

    public void printLink(){
        Node tmp = head;
        System.out.println("-------------------");
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args){
        testLink test = new testLink();
        test.addNode(0);
        test.addNode(1);
        test.addNode(2);
        test.addNode(5);
        test.addNode(1);
        test.printLink();
        test.orderList();
        test.printLink();
    }
}

