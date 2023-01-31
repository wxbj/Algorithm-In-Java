package basic;

import java.util.Scanner;

/**
 * 栈元素
 */
class StackData {
    String name;
    int age;
}

/**
 * 顺序栈
 */
class SequenceStack {
    static final int MAXLEN = 50;
    StackData[] data = new StackData[MAXLEN + 1];
    int top;

    /**
     * 读栈顶元素
     */
    StackData GetTop(SequenceStack sequenceStack) {
        if (sequenceStack.top == 0) {
            System.out.println("栈为空");
            System.exit(0);
        }
        return sequenceStack.data[sequenceStack.top];
    }

    /**
     * 出栈
     */
    StackData Pop(SequenceStack sequenceStack) {
        if (sequenceStack.top == 0) {
            System.out.println("栈为空");
            return null;
        }
        return sequenceStack.data[sequenceStack.top--];
    }

    /**
     * 入栈
     */
    int Push(SequenceStack sequenceStack, StackData data) {
        if ((sequenceStack.top + 1) > MAXLEN) {
            System.out.println("栈溢出了");
            return 0;
        }
        sequenceStack.data[++sequenceStack.top] = data;
        return 1;
    }

    /**
     * 释放空间
     */
    void FreeStack(SequenceStack sequenceStack) {
        if (sequenceStack != null) {
            sequenceStack = null;
        }
    }

    /**
     * 清空栈
     */
    void Clear(SequenceStack sequenceStack) {
        sequenceStack.top = 0;
    }

    /**
     * 判栈满
     */
    boolean Full(SequenceStack sequenceStack) {
        return sequenceStack.top == MAXLEN;
    }

    /**
     * 判栈空
     */
    boolean Empty(SequenceStack sequenceStack) {
        return (sequenceStack.top == 0);
    }

    /**
     * 初始化栈
     */
    SequenceStack Init() {
        SequenceStack p = new SequenceStack();
        p.top = 0;
        return p;
    }
}


public class Stack {
    public static void main(String[] args) {
        SequenceStack sequenceStack = new SequenceStack();
        Scanner input = new Scanner(System.in);

        sequenceStack.Init();
        System.out.println("入栈,0终止:wz 18");
        do {
            StackData data = new StackData();
            data.name = input.next();
            if (data.name.equals("0")) {
                break;
            } else {
                data.age = input.nextInt();
                sequenceStack.Push(sequenceStack, data);
            }
        } while (true);
        String temp;
        System.out.print("出栈,按0终止,其他键出栈:");
        temp = input.next();
        while (!temp.equals("0")) {
            StackData data = sequenceStack.Pop(sequenceStack);
            System.out.printf("出栈的数据是(%s,%d)\n", data.name, data.age);
            temp = input.next();
        }
        System.out.print("测试结束");
        sequenceStack.FreeStack(sequenceStack);
    }
}
