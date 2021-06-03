package Linkedlist;

public class MyLink {

    private Node head;         // 设置一个头部节点
    private Node tail;

    // 每个节点是一个类对象，这个类包括节点存储的数据和节点存储的下一个节点地址
    private static class Node{
        Node next;    // 创建一个Node类型的变量，用来保存后面的对象
        // int data;  // 这个表只能存储int型的数据类型
        Object data;  // 所有基本数据类型的父类都是Object
        public Node(Object data){
            this.data = data;
        }
    }

    // 向链表尾部或者头部添加节点
    public void addNode(Object d){
        Node newNode = new Node(d);
        // 添加节点到尾部
        if(head==null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.next != null){  // 一直到最后一个节点才为 null
            tmp = tmp.next;
        }
        tmp.next = newNode;
        tail = newNode;
        /* 添加节点到头部
        newNode.next = head;
        head = newNode;
        */
    }

    // 添加节点到指定位置
    public void addNodeByIndex(int index, Object data){
        if(index<0 || index>linkLength()+1)
            System.out.println(">>>超出添加范围，添加失败");
        else {
            Node newNode = new Node(data);
            if (index == 1) {   // 添加到头部
                newNode.next = head;
                head = newNode;
            }
            Node tmp = head;
            int i = 1;
            while (true) {     // 添加到任意位置
                if (i == index-1) {
                    Node target = tmp.next;
                    tmp.next = newNode;
                    newNode.next = target;
                    break;
                }
                i++;
                tmp = tmp.next;
            }
        }
    }

    // 删除指定位置的节点
    public void deleteNode(int index){
        if(index<1 || index>linkLength()){
            System.out.println(">>>超出链表范围");
        }
        else {
            if (index == 1) {
                head = head.next;  // 删除头结点
            }
            int i = 1;
            // 先循环到找到指定节点的前一节点；这种可以吗
            Node tmp = head;
            while (tmp.next != null) {  // tmp.next做条件head为空时不行
                if (i == index - 1)
                    break;
                tmp = tmp.next;
                i++;
            }
            Node target = tmp.next;
            tmp.next = target.next;
//            这种挺好
//            int i = 1;
//            Node preNode = head;
//            Node curNode = preNode.next;
//            while (curNode != null) {
//                if (i == index-1) {
//                    preNode.next = curNode.next;
//                    return true;
//                }
//                preNode = curNode;
//                curNode = curNode.next;
//                i++;
//            }
        }

    }

    // 统计链表长度
    public int linkLength(){
        Node tmp = head;
        int len=0;
        // 这里不能用tmp.next!=null做条件，因为当第一个节点为null的时候会报错
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        return len;
    }

    // 打印链表数据
    public void printLinkData(){
        System.out.println("---------打印开始------------");
        for(Node x=head; x!=null; x=x.next){
            System.out.println(x.data);
        }
        System.out.println("---------打印结束------------");
    }

    // 获取指定位置的链表数据
    public Object getDataByindex(int index){
        if(index<1 || index>linkLength())
            return null;
        Node tmp = head;
        int i=0;
        while(tmp!=null){
            if(i==index-1){
                return tmp.data;
            }
            i++;
            tmp = tmp.next;
        }
        return null;
    }

    // 链表反转; 有点麻烦
    public Node reverseLink(Node head){
        Node pCurr = head;
        Node pPrev = null;
        while(pCurr!=null){
            Node pNext = pCurr.next;
            pCurr.next = pPrev;
            pPrev = pCurr;
            pCurr = pNext;
        }
        this.head = pPrev;
        return this.head;
    }
    // 递归实现反转
    public Node reverseLinkByRecursion(Node head){
        if(head.next==null)
            return head;
        Node newLink = reverseLinkByRecursion(head.next);// head=second newLink=third  // head=first newlink=third
        head.next.next = head;                           // third.next=second          // second.next=first
        head.next = null;                                // second.next=null           // first.next=null
        return newLink;
    }
    // 递归实现反转前n个节点
    Node successor = null;
    public Node reverseNLinkByRecursion(Node head, int n){
        if(n==1){
            successor = head.next;  // 记录n节点的下一个节点
            return head;
        }
        Node newlink = reverseNLinkByRecursion(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return newlink;
    }
    // 实现反转链表m-n之间的节点
    // 把 m 节点当做 1，用反转前 n 个的函数反转m-n之间的节点
    public Node reverseMN(Node head, int m, int n){
        if(m==1){
            return reverseNLinkByRecursion(head, n);
        }
        head.next = reverseMN(head.next, m-1, n-1);
        return head;
    }

    // 快慢指针查找单链表的中间节点
    public void findMiddleData(Node head){
        // 快慢指针，慢指针每次走一格，快指针每次走两格
        Node p = this.head, q = this.head;
        while(p!=null && p.next!=null && p.next.next!=null){
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Middle data: " + q.data);
    }

    // 链表指定位置成环
    public void makeLoop(int index) {
        if (index < 1 || index > linkLength())
            System.out.println(">>>超出范围");
        else {
            Node tmp = head;
            for (int i = 0; i < index; i++) {
                tail.next = tmp;
                tmp = tmp.next;
            }
        }
    }
    // 快慢指针查找链表是否有环
    // 快指针和慢指针的速度差可以是其他的吗？
    public boolean findLoop(Node head){
        Node fast = this.head, slow = this.head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                System.out.println(">>>该链表有环");
                return true;
            }
        }
        System.out.println(">>>该链表无环");
        return false;
    }
    // 快慢指针找环的入口
    public Node findLoopPort(){
        Node fast = head, slow = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                break;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;  // 慢指针回到原点，然后快慢指针一起移动，会一起到达入口，为什么？
        }
        return slow;
    }

    public void printLinkReversed(Node node){
        if(node!=null){
            // node = node.next; // 不能用这个，区别就是最后一个null会被下面的node.data所使用
            // printLinkReversed(node);
            printLinkReversed(node.next);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
//        Node first = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//        first.next = second;
//        second.next = third;
//        for(Node x=first; x!=null; x=x.next){
//            System.out.println(x.data);
//        }
        MyLink myLink = new MyLink();
        myLink.addNode(1);
        myLink.addNode('a');
        myLink.addNode("string");
        myLink.addNode(3.4);
        myLink.addNode(5);
//        myLink.makeLoop(2);
//        myLink.findLoop(myLink.head);
//        Node node = myLink.findLoopPort();
//        System.out.println(node.data);
        // 为什么有环之后删除不行了，按理应该是可以的啊？
        myLink.deleteNode(3);
        myLink.printLinkData();
        System.out.println("length: " + myLink.linkLength());
        System.out.println("getData: " + myLink.getDataByindex(4));
        myLink.addNodeByIndex(5, "three");
        myLink.printLinkData();
        myLink.reverseLink(myLink.head);
        myLink.printLinkData();
        myLink.findMiddleData(myLink.head);
        myLink.printLinkReversed(myLink.head);
        myLink.head = myLink.reverseLinkByRecursion(myLink.head);
        myLink.printLinkData();
        myLink.head = myLink.reverseNLinkByRecursion(myLink.head, 3);
        myLink.printLinkData();
        myLink.head = myLink.reverseMN(myLink.head, 2, 3);
        myLink.printLinkData();

        // psvm 回车 快速创建main
        // sout 回车键 快速创建输出
        // ctrl+Alt+space 内容辅助
    }
}
