package leetcode.链表中的节点每k个一组翻转;

import leetcode.node.ListNode;
import leetcode.node.TreePrintUtil;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    //描述
    //将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
    //如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
    //你不能更改节点中的值，只能更改节点本身。
    //
    //数据范围： \ 0 \le n \le 2000 0≤n≤2000 ， 1 \le k \le 20001≤k≤2000 ，
    // 链表中每个元素都满足 0 \le val \le 10000 ≤val≤1000
    //要求空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
    //例如：
    //给定的链表是 1\to2\to3\to4\to5 1→2→3→4→5
    //对于 k = 2 k=2 , 你应该返回 2\to 1\to 4\to 3\to 5   2→1→4→3→5
    //对于 k = 3 k=3 , 你应该返回 3\to2 \to1 \to 4\to 5   3→2→1→4→5
    //
    //示例1
    //输入：
    //{1,2,3,4,5},2
    
    //返回值：
    //{2,1,4,3,5}
    
    //示例2
    //输入：
    //{},1
    
    //返回值：
    //{}
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        //找个每次旋转的尾部， fast-template
        ListNode tail=head;
        //遍历k次到尾部
        for(int i=0;i<k;i++){
            //如果不够，直接返回，不翻转
            if(tail==null){
                return  head;
            }
            tail=tail.next;
        }
        //翻转是需要的前序和当前节点
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=tail){
            //翻转
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        //当前尾部指向下一段要旋转的链表
        head.next=reverseKGroup(tail,k);
        return   pre;
    }

    public static void main(String[] args) {
        ListNode root = TreePrintUtil.makeListNode(new Integer[]{1, 2, 3, 4, 5});
        TreePrintUtil.printListNode(root);
        ListNode curNode = new Solution().reverseKGroup(root,2);
        TreePrintUtil.printListNode(curNode);
    }


}