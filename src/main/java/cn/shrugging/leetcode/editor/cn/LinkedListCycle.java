/**
 * @ author  shrugginG
 * @ date  2021-11-04 16:40:30
 * @ question [141]环形链表
 * @ description Soultion to the leetcode questions.
 */

//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 哈希表 链表 双指针 👍 1243 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
		public static void main(String[] args) {
				Solution solution = new LinkedListCycle().new Solution();
		}

		class ListNode {
				int val;
				ListNode next;

				ListNode(int x) {
						val = x;
						next = null;
				}
		}
		//leetcode submit region begin(Prohibit modification and deletion)

		// 1. HashMap
//		public class Solution {
//				public boolean hasCycle(ListNode head) {
//						Set<ListNode> set = new HashSet<ListNode>();
//						while (head != null) {
//								if (set.contains(head))
//										return true;
//								set.add(head);
//								head = head.next;
//						}
//						return false;
//				}
//		}

		// 2.
//		public class Solution {
//				public boolean hasCycle(ListNode head) {
//						if (head == null) {
//								return false;
//						}
//						ListNode l1 = head, l2 = head.next;
//						while (l1 != null && l2 != null && l2.next != null) {
//								if (l1 == l2) {
//										return true;
//								}
//								l1 = l1.next;
//								l2 = l2.next.next;
//						}
//						return false;
//				}
//		}

		// 1. do while 快慢指针的起点都是head
//		public class Solution {
//				public boolean hasCycle(ListNode head) {
//						if (head == null || head.next == null)
//								return false;
//						ListNode fast = head, slow = head;
//						do {
//								if (fast.next != null && fast.next.next != null) {
//										slow = slow.next;
//										fast = fast.next.next;
//								} else
//										return false;
//						} while (slow != fast);
//						return true;
//				}
//		}

		// 2. while 快指针的起点是head.next
		public class Solution {
				public boolean hasCycle(ListNode head) {
						if (head == null || head.next == null)
								return false;
						ListNode fast = head.next, slow = head;
						while (fast != slow) {
								if (fast.next != null && fast.next.next != null) {
										slow = slow.next;
										fast = fast.next.next;
								} else
										return false;
						}
						return true;
				}
		}


//leetcode submit region end(Prohibit modification and deletion)

}