/**
 * @author shrugginG
 * @date 2021-11-03 15:43:56
 * @ question [15]三数之和
 * @description Soultion to the leetcode questions.
 */

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3936 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
		public static void main(String[] args) {
				Solution solution = new ThreeSum().new Solution();
				int[] nums = {-1, 0, 1, 2, -1, -4};
				System.out.println(solution.threeSum(nums).toString());

		}

		//leetcode submit region begin(Prohibit modification and deletion)
		// 1. 简单的三重循环，这样做会导致超时
//		class Solution {
//				public List<List<Integer>> threeSum(int[] nums) {
//						Arrays.sort(nums);
//						List<List<Integer>> result = new ArrayList<List<Integer>>();
//						for (int i = 0; i < nums.length; i++) {
//								if (i == 0 || nums[i] != nums[i - 1])
//										for (int j = i + 1; j < nums.length; j++) {
//												if (j == i + 1 || nums[j] != nums[j - 1])
//														for (int a = j + 1; a < nums.length; a++) {
//																if (a == j + 1 || nums[a] != nums[a - 1])
//																		if (nums[i] + nums[j] + nums[a] == 0) {
//																				List<Integer> temp = new ArrayList<Integer>();
//																				temp.add(nums[i]);
//																				temp.add(nums[j]);
//																				temp.add(nums[a]);
//																				if (!result.contains(temp))
//																						result.add(temp);
//																		} else
//																				continue;
//
//														}
//												else
//														continue;
//										}
//								else
//										continue;
//
//						}
//						return result;
//				}
//
//
//		}

		//  2. a+b+c=0，固定a后就转换为了b+c=-a的双指针问题
		class Solution {
				public List<List<Integer>> threeSum(int[] nums) {
						List<List<Integer>> result = new ArrayList<List<Integer>>();
						Arrays.sort(nums);
						for (int i = 0; i < nums.length; i++) {
								if (i > 0 && nums[i] == nums[i - 1])
										continue;
								int lo = i + 1, hi = nums.length - 1;
								while (lo < hi) {
										if (nums[lo] + nums[hi] < -nums[i] || (lo != i + 1 && nums[lo] == nums[lo - 1]))
												lo++;
										else if (nums[lo] + nums[hi] > -nums[i] || (hi != nums.length - 1 && nums[hi] == nums[hi + 1]))
												hi--;
										else {
												List<Integer> temp = new ArrayList<Integer>();
												temp.add(nums[i]);
												temp.add(nums[lo]);
												temp.add(nums[hi]);
												result.add(temp);
												lo++;
												hi--;
										}


								}
						}
						return result;
				}
		}


//leetcode submit region end(Prohibit modification and deletion)

}