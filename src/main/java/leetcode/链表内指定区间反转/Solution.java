package leetcode.链表内指定区间反转;

import leetcode.node.ListNode;
import leetcode.node.TreePrintUtil;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {

    //例如：
    //给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL  1→2→3→4→5→NULL, m=2,n=4  m=2,n=4,
    //返回 1\to 4\to 3\to 2\to 5\to NULL  1→4→3→2→5→NULL.
    //
    //数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，
    // 链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
    //要求：时间复杂度 O(n)O(n) ，空间复杂度 O(n)O(n)
    //进阶：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)


    public ListNode ReverseList(ListNode head) {
        //处理空链表 fast-template
        // 1->2 ->3 ->4
        // 1  <- 2 <- 3 <- 4
        if (head == null) {
            return null;
        }
        ListNode nextNode = head;
        ListNode prevNode = null;
        while (nextNode.next != null) {
            ListNode curNode = nextNode;
            nextNode = nextNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
        }
        nextNode.next = prevNode;
        return nextNode;
    }

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n || m > n) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = null;
        ListNode firstNodePre = head;
        ListNode secondNodeNext = null;
        ListNode curNode = head;

        int i = 1;

        while (curNode != null) {
            ListNode pre = curNode;
            curNode = curNode.next;
            i++;
            if (i == m) {
                firstNode = curNode;
                firstNodePre = pre;
            }
            if (i == n) {
                secondNode = curNode;
                secondNodeNext = curNode.next;
                secondNode.next = null;
            }
        }

        if (n > i) {
            secondNodeNext = null;
        }
        ListNode reverseNode = ReverseList(firstNode);
        if (m == 1) {
            head.next = secondNodeNext;
            head = reverseNode;
        } else {
            firstNodePre.next = reverseNode;
            firstNode.next = secondNodeNext;
        }
        return head;
    }

    //标准答案

    public ListNode ST_reverseBetween(ListNode head, int m, int n) {
//      加个表头 fast -template
        if (head == null || m == n || m > n) {
            return head;
        }
        if (m <= 0) {
            m = 1;
        }
        ListNode occurNode = head;
        int idx = 0;
        while (occurNode != null) {
            idx++;
            occurNode = occurNode.next;
        }
        if (n > idx) {
            n = idx;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //找到m
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        //返回去头节点
        return res.next;
    }


    public static void main(String[] args) {
        ListNode root = TreePrintUtil.makeListNode(new Integer[]{1, 2, 3, 4, 5});
        int m = 2;
        int n = 9;
        TreePrintUtil.printListNode(root);
//        ListNode curNode = new Solution().ST_reverseBetween(root, m, n);
//        TreePrintUtil.printListNode(curNode);
    }

}