package basic;

import java.util.Random;
import java.util.Scanner;

/**
 * 在数组中查找指定数据
 */
public class Array {
    static int MAXSIZE = 20;

    public static void main(String[] args) {
        int[] arr = new int[MAXSIZE];
        int position = -1;
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < MAXSIZE; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("随机生成的数据数列:");
        for (int i = 0; i < MAXSIZE; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("输入要查找的整数:");
        int searchNum = input.nextInt();
        for (int i = 0; i < MAXSIZE; i++) {
            if (searchNum == arr[i]) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            System.out.print("没有找到数据:");
        } else {
            System.out.print("数据位于" + (position + 1) + "个元素处");
        }
    }

}
