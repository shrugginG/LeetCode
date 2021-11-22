/**
 * @author shrugginG
 * @date 2021-11-03 08:48:02
 * @ question [167]两数之和 II - 输入有序数组
 * @description Soultion to the leetcode questions.
 */

//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。 
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 👍 609 👎 0


package cn.shrugging.leetcode.editor.cn;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

public class TwoSumIiInputArrayIsSorted {
		public static void main(String[] args) {
				Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
				int[] a = {1, 2, 3, 4, 5, 6, 7};
				int[] b = Arrays.copyOfRange(a, 1, 5);
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		// 1. BinarySearch
//		class Solution {
//				public int[] twoSum(int[] numbers, int target) {
//						for (int i = 0; i < numbers.length; i++) {
//								int flag = BinarySearch(target - numbers[i], Arrays.copyOfRange(numbers, i + 1, numbers.length));
//								if (flag >= 0)
//										return new int[]{i + 1, flag + (i+1)+1};
//						}
//						return null;
//				}
//
//				public int BinarySearch(int key, int[] nums) {
//						int lo = 0;
//						int hi = nums.length - 1;
//						while (lo <= hi) {
//								int mid = (lo + hi) / 2;
//								if (key > nums[mid])
//										lo = mid + 1;
//								else if (key < nums[mid])
//										hi = mid - 1;
//								else
//										return mid;
//						}
//						return -1;
//				}
//		}

		// 2. TwoPointers
		class Solution {
				public int[] twoSum(int[] numbers, int target) {
						int lo = 0;
						int hi = numbers.length - 1;
						while (lo < hi) {
								if (numbers[lo] + numbers[hi] < target)
										lo++;
								else if (numbers[lo] + numbers[hi] > target)
										hi--;
								else
										return new int[]{lo + 1, hi + 1};

						}
						return null;
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}