package leetcode.合并两个排序的链表;

import leetcode.node.ListNode;
import leetcode.node.TreePrintUtil;

public class Solution {
    //描述
    //输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
    //数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
    //要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
    //
    //如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
    //
    //
    //或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}，转换过程如下图所示：
    //
    //示例1
    //输入：
    //{1,3,5},{2,4,6}

    //返回值：
    //{1,2,3,4,5,6}

    //示例2
    //输入：
    //{},{}

    //返回值：
    //{}

    //示例3
    //输入：
    //{-1,2,4},{1,3,4}

    //返回值：
    //{-1,1,2,3,4,4}

    public ListNode Merge(ListNode list1, ListNode list2) {
        //{1,3,5},{2,4,6} -> {1,2,3,4,5,6}
        ListNode node = new ListNode(-1);
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode cur = node;

        while (l1 != null || l2 != null) {
            ListNode tmp = null;
            if (l1 != null && l2 != null) {
                int a = l1.val;
                int b = l2.val;
                if (a >= b) {
                    tmp = l2;
                    l2 = l2.next;
                } else {
                    tmp = l1;
                    l1 = l1.next;
                }
            } else {
                if (l1 != null) {
                    tmp = l1;
                    l1=l1.next;
                } else {
                    tmp = l2;
                    l2=l2.next;
                }
            }
            cur.next = tmp;
            cur = cur.next;
        }

        return node.next;
    }
    //标准答案(递归)
    public ListNode ST_Merge_EX(ListNode list1, ListNode list2) {
        if(list1==null){
            return  list2;
        }
        if(list2==null) {
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next=ST_Merge_EX(list1.next,list2);
            return  list1;
        }else{
            list2.next=ST_Merge_EX(list1,list2.next);
            return  list2;
        }
    }

    //标准答案
    public ListNode ST_Merge(ListNode list1, ListNode list2) {
        ListNode vHead = new ListNode(-1);
        ListNode cur = vHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return vHead.next;
    }


    public static void main(String[] args) {

        ListNode l1 = TreePrintUtil.makeListNode(new Integer[]{4,10,18,20});
        ListNode l2 = TreePrintUtil.makeListNode(new Integer[]{2, 4, 6,9});
        ListNode ret = new Solution().ST_Merge(l1, l2);
        TreePrintUtil.printListNode(ret);
    }

}
