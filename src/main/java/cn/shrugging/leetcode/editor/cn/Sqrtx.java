/**
 * @ author  shrugginG
 * @ date  2021-11-05 10:44:13
 * @ question [69]Sqrt(x)
 * @ description Soultion to the leetcode questions.
 */

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 817 👎 0


package cn.shrugging.leetcode.editor.cn;

public class Sqrtx {
		public static void main(String[] args) {
				Solution solution = new Sqrtx().new Solution();
		}

		//leetcode submit region begin(Prohibit modification and deletion)

		// 对于x的sqrt，x/sqrt==sqrt
		class Solution {
				public int mySqrt(int x) {
						if (x == 0 || x == 1)
								return x;
						int lo = 1;
						int hi = x;
						while (lo <= hi) {
								// 避免溢出
								int mid = lo + (hi - lo) / 2;
								int sqrt = x / mid;
								if (mid > sqrt)
										hi = mid - 1;
								else if (mid < sqrt)
										lo = lo + 1;
								else
										return mid;
						}

						return hi;
				}
		}

//		class Solution {
//				public int mySqrt(int x) {
//						return (int) Math.sqrt(x);
//				}
//		}
//leetcode submit region end(Prohibit modification and deletion)

}