package basic;

import java.util.Scanner;

/**
 * 二叉树
 */
class BinaryTree {
    String data;
    BinaryTree left;
    BinaryTree right;
    static final int MAXLEN = 20;

    /**
     * 先序遍历
     */
    void PreTree(BinaryTree treeNode) {
        if (treeNode != null) {
            TreeNodeData(treeNode);
            PreTree(treeNode.left);
            PreTree(treeNode.right);
        }
    }

    /**
     * 中序遍历
     */
    void OrdTree(BinaryTree treeNode) {
        if (treeNode != null) {
            OrdTree(treeNode.left);
            TreeNodeData(treeNode);
            OrdTree(treeNode.right);
        }
    }

    /**
     * 后序遍历
     */
    void PosTree(BinaryTree treeNode) {
        if (treeNode != null) {
            PosTree(treeNode.left);
            PosTree(treeNode.right);
            TreeNodeData(treeNode);
        }
    }

    /**
     * 按层遍历二叉树
     */
    void LevelTree(BinaryTree treeNode) {
        BinaryTree temp;
        BinaryTree[] queue = new BinaryTree[MAXLEN];
        int head = 0, tail = 0;

        if (treeNode != null) {
            tail = (tail + 1) % MAXLEN;
            queue[tail] = treeNode;
        }
        while (head != tail) {
            head = (head + 1) % MAXLEN;
            temp = queue[head];
            TreeNodeData(temp);
            if (temp.left != null) {
                tail = (tail + 1) % MAXLEN;
                queue[tail] = temp.left;
            }
            if (temp.right != null) {
                tail = (tail + 1) % MAXLEN;
                queue[tail] = temp.right;
            }
        }
    }

    /**
     * 显示结点数据
     */
    void TreeNodeData(BinaryTree temp) {
        System.out.println(temp.data);
    }

    /**
     * 清空二叉树
     */
    void ClearTree(BinaryTree treeNode) {
        if (treeNode != null) {
            ClearTree(treeNode.left);
            ClearTree(treeNode.right);
            treeNode = null;
        }
    }

    /**
     * 计算二叉树的深度
     */
    int TreeDepth(BinaryTree treeNode) {
        int depLeft, depRight;
        if (treeNode == null) return 0;
        else {
            depLeft = TreeDepth(treeNode.left);
            depRight = TreeDepth(treeNode.right);
            if (depLeft > depRight) return depLeft + 1;
            else return depRight + 1;
        }
    }

    /**
     * 判树空
     */
    int TreeEmpty(BinaryTree treeNode) {
        if (treeNode != null) return 0;
        else return 1;
    }

    /**
     * 获取右子树
     */
    BinaryTree TreeRightNode(BinaryTree treeNode) {
        if (treeNode != null) return treeNode.right;
        else return null;
    }

    /**
     * 获取左子树
     */
    BinaryTree TreeLeftNode(BinaryTree treeNode) {
        if (treeNode != null) return treeNode.left;
        else return null;
    }

    /**
     * 添加结点
     */
    void AddTreeNode(BinaryTree treeNode) {
        BinaryTree pnode = new BinaryTree();
        Scanner input = new Scanner(System.in);

        System.out.print("输入结点数据:");
        pnode.data = input.next();
        pnode.left = null;
        pnode.right = null;

        System.out.print("输入该结点的父节点:");
        String data = input.next();

        BinaryTree parent = TreeFindNode(treeNode, data);
        if (parent == null) {
            System.out.println("未找到");
            return;
        }
        System.out.println("1、添加到左子树。\n2、添加到右子树");
        int menu;
        do {
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    parent.left = pnode;
                    break;
                case 2:
                    parent.right = pnode;
                    break;
            }
        } while (menu != 1 && menu != 2);
    }

    /**
     * 查找结点
     */
    BinaryTree TreeFindNode(BinaryTree treeNode, String data) {
        BinaryTree temp;
        if (treeNode == null) return null;
        else {
            if (treeNode.data.equals(data)) return treeNode;
            else {
                if ((temp = TreeFindNode(treeNode.left, data)) != null)
                    return temp;
                else if ((temp = TreeFindNode(treeNode.right, data)) != null)
                    return temp;
                else return null;
            }
        }
    }

    /**
     * 初始化
     */
    BinaryTree InitTree() {
        BinaryTree node = new BinaryTree();
        Scanner input = new Scanner(System.in);

        System.out.print("请先输入根节点数据:");
        node.data = input.next();
        node.left = null;
        node.right = null;
        return node;
    }
}

public class Tree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree root = new BinaryTree();
        int menu = 1;
        root = root.InitTree();

        while (menu != 0) {
            System.out.print("添加结点,0终止，其他键添加:");
            menu = input.nextInt();
            root.AddTreeNode(root);
        }
        System.out.println("层次遍历\n");
        root.LevelTree(root);
        System.out.println("先序遍历\n");
        root.PreTree(root);
        System.out.println("中序遍历\n");
        root.OrdTree(root);
        System.out.println("后序遍历\n");
        root.PosTree(root);
        System.out.printf("二叉树的深度：%d", root.TreeDepth(root));
        root.ClearTree(root);
    }
}
