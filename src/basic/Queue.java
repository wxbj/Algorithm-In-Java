package basic;

import java.util.Scanner;

/**
 * 队列元素
 */
class QueueData {
    String name;
    int age;
}

/**
 * 队列
 */
class QueueTable {
    static final int QUEUELEN = 15;
    QueueData[] data = new QueueData[QUEUELEN];
    int head;
    int tail;

    /**
     * 队列长度
     */
    int QueueLen(QueueTable queue) {
        return queue.tail - queue.head;
    }

    /**
     * 读结点数据
     */
    QueueData GetQueueItem(QueueTable queue) {
        if (IsEmptyQueue(queue) == 1) {
            System.out.println("空队列");
            return null;
        } else
            return queue.data[queue.head];

    }

    /**
     * 出队
     */
    QueueData OutQueue(QueueTable queue) {
        if (queue.head == queue.tail) {
            System.out.println("队列为空");
            return null;
        } else
            return queue.data[queue.head++];

    }

    /**
     * 入队
     */
    int InQueue(QueueTable queue, QueueData data) {
        if (queue.tail == QUEUELEN) {
            System.out.println("队满了");
            return 0;
        } else {
            queue.data[queue.tail++] = data;
            return 1;
        }
    }

    /**
     * 释放队列
     */
    void FreeQueue(QueueTable queue) {
        queue = null;
    }

    /**
     * 清空队列
     */
    void ClearQueue(QueueTable queue) {
        queue.head = 0;
        queue.tail = 0;
    }

    /**
     * 判队满
     */
    int IsFullQueue(QueueTable queue) {
        int temp = 0;
        if (queue.tail == QUEUELEN) {
            temp = 1;
        }
        return temp;
    }

    /**
     * 判队空
     */
    int IsEmptyQueue(QueueTable queue) {
        int temp = 0;
        if (queue.head == queue.tail) {
            temp = 1;
        }
        return temp;
    }

    /**
     * 初始化队列
     */
    QueueTable InitQueue() {
        QueueTable queue = new QueueTable();
        queue.head = 0;
        queue.tail = 0;
        return queue;
    }
}


public class Queue {
    public static void main(String[] args) {
        QueueTable queue = new QueueTable();
        Scanner input = new Scanner(System.in);

        queue = queue.InitQueue();
        System.out.println("入队,输入0终止:wz 18");
        do {
            QueueData data = new QueueData();
            String name = input.next();
            if (name.equals("0")) break;
            else {
                data.name = name;
                data.age = input.nextInt();
                queue.InQueue(queue, data);
            }
        } while (true);

        System.out.println("出队,输入0终止:wz");
        String temp = input.next();
        while (!temp.equals(("0"))) {
            QueueData data = queue.OutQueue(queue);
            System.out.printf("出队数据(%S,%d)\n", data.name, data.age);
            temp = input.next();
        }
        System.out.print("测试结束");
        queue.FreeQueue(queue);
    }
}
