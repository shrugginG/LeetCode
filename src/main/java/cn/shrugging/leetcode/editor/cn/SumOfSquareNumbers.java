/**
 * @ author  shrugginG
 * @ date  2021-11-04 09:49:31
 * @ question [633]平方数之和
 * @ description Soultion to the leetcode questions.
 */

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 二分查找 👍 316 👎 0


package cn.shrugging.leetcode.editor.cn;

public class SumOfSquareNumbers {
		public static void main(String[] args) {
				Solution solution = new SumOfSquareNumbers().new Solution();
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		// 1. 使用sqrt函数
//		class Solution {
//				public boolean judgeSquareSum(int c) {
//						for (long a = 0; a * a <= c; a++) {
//								double b = Math.sqrt(c - a * a);
//								if (b == (int) b) {
//										return true;
//								}
//						}
//						return false;
//				}
//		}

		// 2. DoublePointer
		class Solution {
				public boolean judgeSquareSum(int c) {
						long lo = 0;
						long hi = (int) Math.sqrt(c);
						while (lo <= hi) {
								if (lo * lo + hi * hi > c)
										hi--;
								else if (lo * lo + hi * hi < c)
										lo++;
								else
										return true;
						}
						return false;
				}
		}

//leetcode submit region end(Prohibit modification and deletion)

}