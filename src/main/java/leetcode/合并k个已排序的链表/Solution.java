package leetcode.合并k个已排序的链表;

import leetcode.node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //描述
    //合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
    //
    //数据范围：节点总数满足 0 \le n \le 10^50≤n≤10 
    //5
    // ，链表个数满足 1 \le k \le 10^5 \1≤k≤10 
    //5
    //   ，每个链表的长度满足 1 \le len \le 200 \1≤len≤200  ，每个节点的值满足 |val| <= 1000∣val∣<=1000
    //要求：时间复杂度 O(nlogk)O(nlogk)
    //示例1
    //输入：
    //[{1,2,3},{4,5,6,7}]
    
    //返回值：
    //{1,2,3,4,5,6,7}
    
    //示例2
    //输入：
    //[{1,2},{1,4,5},{6}]
    
    //返回值：
    //{1,1,2,4,5,6}

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

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
      return  mergeKLists(lists,0,lists.size()-1);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists,int left,int right) {

        if (left > right) {
            return null;
        } else if (left == right) {
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        return ST_Merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
    }



    public static void main(String[] args) {
//        ListNode l1 = TreePrintUtil.makeListNode(new Integer[]{4,10,18,20});
//        ListNode l2 = TreePrintUtil.makeListNode(new Integer[]{2, 4, 6,11});
//        ListNode l3 = TreePrintUtil.makeListNode(new Integer[]{7,9});
//        ArrayList<ListNode> nodes=new ArrayList<>();
//        nodes.add(l1);
//        nodes.add(l2);
//        nodes.add(l3);
//        ListNode ret = new  Solution().mergeKLists(nodes);
//        TreePrintUtil.printListNode(ret);
//
//
//        TreeNode tree = TreePrintUtil.makeTree(new Integer[]{4,10,9,0,10,20,32,18,20});
//        TreePrintUtil.printTree(tree);

//        List<Integer> collect = Stream.of(4, 10, 9, 0, 10, 20, 32, 18, 20).sorted().collect(Collectors.toList());
//        System.out.println(collect);

        List<String> collect = Stream.of("cat", "ca", "c").collect(Collectors.toList());
    }


}