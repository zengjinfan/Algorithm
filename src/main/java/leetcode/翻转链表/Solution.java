package leetcode.翻转链表;

import leetcode.node.ListNode;
import leetcode.node.TreePrintUtil;

public class Solution {

    //数据范围： 0\leq n\leq10000≤n≤1000
    //要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
    //
    //如当输入链表{1,2,3}时，
    //经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
    //以上转换过程如下图所示：
    //
    //示例1
    //输入：
    //{1,2,3}
    
    //返回值：
    //{3,2,1}
    
    //示例2
    //输入：
    //{}
    
    //返回值：
    //{}
    
    //说明：
    //空链表则输出空   
    public ListNode ReverseList(ListNode head) {
        //处理空链表 fast-template
        // 1->2 ->3 ->4
        // 1  <- 2 <- 3 <- 4
        if (head == null) {
            return null;
        }
        ListNode nextNode = head;
        ListNode prevNode=null;
        while(nextNode.next!=null) {
            ListNode curNode = nextNode;
            nextNode = nextNode.next;
            curNode.next=prevNode;
            prevNode=curNode;
        }
        nextNode.next=prevNode;
        return nextNode;
    }



    // 标准答案

    public ListNode ST_ReverseList(ListNode head) {
        //处理空链表 fast-template
        // 1->2 ->3 ->4
        // 1  <- 2 <- 3 <- 4
        if (head == null) {
            return null;
        }
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            //断开连接，保存后续一个
            ListNode tem=cur.next;
            //当前的下一个，指向前一个
            cur.next=pre;
            pre=cur;
            cur=tem;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode root = TreePrintUtil.makeListNode(new Integer[]{1, 2,15,16,17,18,19,});
        TreePrintUtil.printListNode(root);
        ListNode newNode = new Solution().ST_ReverseList(root);
        TreePrintUtil.printListNode(newNode);
    }

}