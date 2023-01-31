package basic;

import java.util.Scanner;

/**
 * 图
 */
class GraphMatrix {
    static final int MaxNum = 20;
    static final int MaxValue = 65535;

    char[] Vertex = new char[MaxNum];
    int GType;
    int VertexNum;
    int EdgeNum;
    int[][] EdgeWeight = new int[MaxNum][MaxNum];
    int[] IsTravel = new int[MaxNum];

    /**
     * 深度优先遍历
     */
    void DeepTraOne(GraphMatrix GM, int n) {
        GM.IsTravel[n] = 1;
        System.out.printf("->%c", GM.Vertex[n]);
        for (int i = 0; i < GM.VertexNum; i++)
            if (GM.EdgeWeight[n][i] != MaxValue && GM.IsTravel[i] == 0)
                DeepTraOne(GM, i);
    }

    void DeepTraGraph(GraphMatrix GM) {
        for (int i = 0; i < GM.VertexNum; i++) GM.IsTravel[i] = 0;
        System.out.print("深度优先遍历:");
        for (int i = 0; i < GM.VertexNum; i++)
            if (GM.IsTravel[i] == 0) DeepTraOne(GM, i);
    }

    /**
     * 显示
     */
    void OutGraph(GraphMatrix GM) {
        for (int i = 0; i < GM.VertexNum; i++)
            System.out.printf("\t%c", GM.Vertex[i]);
        System.out.println();

        for (int i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c", GM.Vertex[i]);
            for (int j = 0; j < GM.VertexNum; j++) {
                if (GM.EdgeWeight[i][j] == MaxValue) System.out.print("\tZ");
                else System.out.printf("\t%d", GM.EdgeWeight[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 初始化
     */
    void InitGraph(GraphMatrix GM) {
        for (int i = 0; i < GM.VertexNum; i++)
            for (int j = 0; j < GM.VertexNum; j++)
                GM.EdgeWeight[i][j] = MaxValue;
    }

    /**
     * 创建
     */
    void CreateGraph(GraphMatrix GM) {
        Scanner input = new Scanner(System.in);

        System.out.println("输入顶点值格式:a");
        for (int i = 0; i < GM.VertexNum; i++) {
            System.out.printf("第%d个顶点:", i + 1);
            GM.Vertex[i] = (input.next().toCharArray())[0];
        }

        System.out.println("输入边及边值格式:a b 1");
        for (int i = 0; i < GM.VertexNum; i++) {
            System.out.printf("第%d条边:", i + 1);
            int j = 0, k = 0;
            char StartV = input.next().charAt(0);
            char EndV = input.next().charAt(0);
            int weight = input.nextInt();
            while (StartV != GM.Vertex[j]) j++;
            while (EndV != GM.Vertex[k]) k++;
            GM.EdgeWeight[j][k] = weight;
            if (GM.GType == 0) GM.EdgeWeight[k][j] = weight;
        }
    }

}

public class Graph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GraphMatrix GM = new GraphMatrix();
        System.out.print("输入生成图的类型,0代表无向图,1代表有向图:");
        GM.GType = input.nextInt();
        System.out.print("输入图的顶点数量:");
        GM.VertexNum = input.nextInt();
        System.out.print("输入图的边点数量:");
        GM.EdgeNum = input.nextInt();
        GM.InitGraph(GM);
        GM.CreateGraph(GM);
        System.out.println("该图的邻接矩阵数据如下:");
        GM.OutGraph(GM);
        GM.DeepTraGraph(GM);
    }
}
