package basic;

import java.util.Scanner;

/**
 * 顺序表元素
 */
class SequenceTableData {
    String key;
    String name;
    int age;
}

/**
 * 顺序表
 */
class SequenceTable {
    static final int MAXLEN = 100;
    SequenceTableData[] sequenceTableData = new SequenceTableData[MAXLEN + 1];
    int SequenceTableLen;

    /**
     * 打印
     */
    int Print(SequenceTable sequence) {
        for (int i = 1; i <= sequence.SequenceTableLen; i++)
            System.out.printf("%s,%s,%d\n", sequence.sequenceTableData[i].key, sequence.sequenceTableData[i].name, sequence.sequenceTableData[i].age);
        return 0;
    }

    /**
     * 按key查找
     */
    int FindByKey(SequenceTable sequence, String key) {
        for (int i = 1; i <= sequence.SequenceTableLen; i++)
            if (sequence.sequenceTableData[i].key.compareTo(key) == 0)
                return 1;
        return 0;
    }

    /**
     * 按序号查
     */
    SequenceTableData FindByNum(SequenceTable sequence, int num) {
        if (num < 1 || num > sequence.SequenceTableLen + 1) {
            System.out.print("查找序号错误!");
            return null;
        }
        return sequence.sequenceTableData[num];
    }

    /**
     * 删除
     */
    int Delete(SequenceTable sequence, int num) {
        if (num < 1 || num > sequence.SequenceTableLen + 1) {
            System.out.print("删除序号有误!");
            return 0;
        }
        for (int i = num; i < sequence.SequenceTableLen; i++) {
            sequence.sequenceTableData[i] = sequence.sequenceTableData[i + 1];
        }
        sequence.SequenceTableLen--;
        return 1;
    }

    /**
     * 追加
     */
    int Add(SequenceTable sequence, SequenceTableData SequenceTableData) {
        if (sequence.SequenceTableLen >= MAXLEN) {
            System.out.print("表已经满了，不能再追加了！");
            return 0;
        }
        sequence.sequenceTableData[++sequence.SequenceTableLen] = SequenceTableData;
        return 1;
    }

    /**
     * 插入
     */
    int Insert(SequenceTable sequence, int num, SequenceTableData SequenceTableData) {
        if (sequence.SequenceTableLen >= MAXLEN) {
            System.out.print("表已经满了！");
            return 0;
        }
        if (num < 0 || num > sequence.SequenceTableLen - 1) {
            System.out.print("插入的序号错啦！");
            return 0;
        }
        for (int i = sequence.SequenceTableLen; i >= num; i--) {
            sequence.sequenceTableData[i + 1] = sequence.sequenceTableData[i];
        }
        sequence.sequenceTableData[num] = SequenceTableData;
        sequence.SequenceTableLen++;
        return 1;

    }

    /**
     * 初始化
     */
    void Init(SequenceTable sequence) {
        sequence.SequenceTableLen = 0;
    }

    /**
     * 表长
     */
    int Length(SequenceTable sequence) {
        return sequence.SequenceTableLen;
    }

}

public class SeqList {
    public static void main(String[] args) {
        SequenceTable sequence = new SequenceTable();
        Scanner input = new Scanner(System.in);

        System.out.println("顺序表演示！");
        sequence.Init(sequence);
        System.out.println("初始化成功！");

        System.out.println("请输入添加的节点,输入0终止:1 wz 18");
        do {
            SequenceTableData SequenceTableData = new SequenceTableData();
            SequenceTableData.key = input.next();
            if (SequenceTableData.key.equals("0")) break;
            SequenceTableData.name = input.next();
            SequenceTableData.age = input.nextInt();
            if (sequence.Add(sequence, SequenceTableData) == 0) break;
        } while (true);
        System.out.println("顺序表中的结点顺序为:");
        sequence.Print(sequence);

        System.out.print("要查找的结点的序号:");
        int num = input.nextInt();
        SequenceTableData data = sequence.FindByNum(sequence, num);
        if (data != null) {
            System.out.printf("第%d个结点为:(%s,%s,%d)\n", num, data.key, data.name, data.age);
        }
        System.out.print("要查找结点的关键字:");
        String key = input.next();
        num = sequence.FindByKey(sequence, key);
        data = sequence.FindByNum(sequence, num);
        if (data != null) {
            System.out.printf("第%d个结点为:(%s,%s,%d)", num, data.key, data.name, data.age);
        }
    }
}