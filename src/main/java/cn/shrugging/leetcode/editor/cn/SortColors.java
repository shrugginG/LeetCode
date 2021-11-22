/**
 * @ author  shrugginG
 * @ date  2021-11-11 09:31:17
 * @ question [75]颜色分类
 * @ description Soultion to the leetcode questions.
 */

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1068 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
		public static void main(String[] args) {
				Solution solution = new SortColors().new Solution();
				int[] nums = {0, 1, 2, 1, 1, 0};
				solution.sortColors(nums);
				System.out.println(Arrays.toString(nums));
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		class Solution {
				//				public void exch(int[] a, int i, int j) {
//						int temp = a[j];
//						a[j] = a[i];
//						a[i] = temp;
//				}
//
//				public void sortColors(int[] nums) {
//						// 我们使用1作为pivot
//						int temp = nums[0];
//						nums[0] = 1;
//						int lt = 0, i = 1, gt = nums.length - 1;
//						int pivot = 1;
//
//						// TODO
//						while (i <= gt) {
//								if (nums[i] < pivot)
//										exch(nums, lt++, i++);
//								else if (nums[i] > pivot)
//										exch(nums, i, gt--);
//								else
//										i++;
//						}
//						if (temp == 0)
//								nums[lt] = temp;
//						if (temp == 2)
//								nums[gt] = temp;
//
//
//				}
				public void sortColors(int[] nums) {
						int zero = -1, one = 0, two = nums.length;
						while (one < two) {
								if (nums[one] == 0) {
										swap(nums, ++zero, one++);
								} else if (nums[one] == 2) {
										swap(nums, --two, one);
								} else {
										++one;
								}
						}
				}

				private void swap(int[] nums, int i, int j) {
						int t = nums[i];
						nums[i] = nums[j];
						nums[j] = t;
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}