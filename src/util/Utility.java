package util;

import models.ListNode;
import models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sorcerer
 * @date 2016/1/3 0003
 */
public class Utility {
    public static void main(String[] args) {
        printTreeNodeTree(generateTreeNodeTree(new Integer[]{1, 2, 3, 4, 5, 6}));
    }

    public static void printIntArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printCharArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }

    public static void printfStringArray(String[] strings) {
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
    }

    public static void printListNodeList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode generateListNodeList(int[] nums) {
        ListNode head = null;
        ListNode current = null;
        for (int num : nums) {
            if (current == null) {
                current = new ListNode(num);
                head = current;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }
        return head;
    }

    public static TreeNode generateTreeNodeTree(Integer[] nums) {
        return generateTreeNodeTree(nums, 0);
    }

    private static TreeNode generateTreeNodeTree(Integer[] nums, int index) {
        if (index < nums.length && nums[index] != null) {
            TreeNode root = new TreeNode(nums[index]);
            root.left = generateTreeNodeTree(nums, index * 2 + 1);
            root.right = generateTreeNodeTree(nums, index * 2 + 2);
            return root;
        } else {
            return null;
        }
    }

    private static void printTreeNodeTree(TreeNode root) {
        System.out.println(levelOrderBottom(root));
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        getList(lists, root, 0);
        return lists;
    }

    private static void getList(List<List<Integer>> lists, TreeNode node, int step) {
        if (node == null) {
            return;
        }
        List<Integer> list;
        if (lists.size() <= step) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(step);
        }
        list.add(node.val);
        getList(lists, node.left, step + 1);
        getList(lists, node.right, step + 1);
    }
}
