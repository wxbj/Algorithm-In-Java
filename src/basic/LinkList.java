package basic;

import java.util.Scanner;

/**
 * 链表数据
 */
class LinkListData {
    String key;
    String name;
    int age;
}

/**
 * 链表结点
 */
class LinkListNode {
    LinkListData nodeData = new LinkListData();
    LinkListNode nextNode;

    /**
     * 尾插法
     */
    LinkListNode AddAtEnd(LinkListNode head, LinkListData nodeData) {
        LinkListNode node = new LinkListNode();
        node.nodeData = nodeData;
        node.nextNode = null;
        if (head.nodeData.key == null) {
            head = node;
            return head;
        }
        LinkListNode temp = head;
        while (temp.nextNode != null)
            temp = temp.nextNode;
        temp.nextNode = node;
        return head;
    }

    /**
     * 头插法
     */
    LinkListNode AddAtFirst(LinkListNode head, LinkListData nodeData) {
        LinkListNode node = new LinkListNode();
        node.nodeData = nodeData;
        node.nextNode = head;
        head = node;
        return head;
    }

    /**
     * 按key值查找
     */
    LinkListNode FindNode(LinkListNode head, String key) {
        LinkListNode temp = head;
        while (temp != null) {
            if (temp.nodeData.key.equals(key)) return temp;
            temp = temp.nextNode;
        }
        return null;
    }

    /**
     * 按key值插入
     */
    LinkListNode InsertNode(LinkListNode head, String findKey, LinkListData nodeData) {
        LinkListNode node = new LinkListNode(), temp;
        node.nodeData = nodeData;
        temp = FindNode(head, findKey);
        if (temp != null) {
            node.nextNode = temp.nextNode;
            temp.nextNode = node;
        } else
            System.out.println("未找到正确的插入位置!");
        return head;

    }

    /**
     * 按key值删除结点
     */
    LinkListNode DeleteNode(LinkListNode head, String key) {
        LinkListNode node = head, temp = head;
        while (temp != null) {
            if (temp.nodeData.key.compareTo(key) == 0) {
                if (node == temp) temp = temp.nextNode;
                node.nextNode = temp.nextNode;
                return head;
            } else {
                node = temp;
                temp = temp.nextNode;
            }
        }
        return head;
    }

    /**
     * 计算表长
     */
    int Length(LinkListNode head) {
        LinkListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.nextNode;
            len++;
        }
        return len;
    }

    /**
     * 显示所有结点
     */
    void ShowAllNode(LinkListNode head) {
        LinkListNode temp = head;
        LinkListData nodeData;
        System.out.printf("当前列表结点数为:%d\n", Length(head));
        while (temp != null) {
            nodeData = temp.nodeData;
            System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            temp = temp.nextNode;
        }
    }

}


public class LinkList {
    public static void main(String[] args) {
        LinkListNode linklist = new LinkListNode();
        Scanner input = new Scanner(System.in);

        System.out.println("链表建立,输入0终止:1 wz 18");
        do {
            LinkListData nodeData = new LinkListData();
            nodeData.key = input.next();
            if (nodeData.key.equals("0")) break;
            else {
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                linklist = linklist.AddAtEnd(linklist, nodeData);
            }
        } while (true);
        linklist.ShowAllNode(linklist);

        System.out.print("输入插入位置的关键字:");
        String findKey = input.next();
        System.out.print("输入数据:");
        LinkListData nodeData = new LinkListData();
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        linklist = linklist.InsertNode(linklist, findKey, nodeData);
        linklist.ShowAllNode(linklist);

        System.out.print("删除关键字:");
        String key = input.next();
        linklist = linklist.DeleteNode(linklist, key);
        linklist.ShowAllNode(linklist);

        System.out.print("查找关键字:");
        key = input.next();
        LinkListNode node = linklist.FindNode(linklist, key);
        if (node != null) {
            nodeData = node.nodeData;
            System.out.printf("关键字%s对应的结点为(%s,%s,%d)", key,
                    nodeData.key, nodeData.name, nodeData.age);
        } else
            System.out.print("未找到结点！");

    }
}
