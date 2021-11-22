/**
 * @author shrugginG
 * @date 2021-11-02 13:44:22
 * @ question [1]两数之和
 * @ solutions TODO
 * @description Soultion to the leetcode questions.
 */

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 12484 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
		public static void main(String[] args) {

				Solution solution = new TwoSum().new Solution();
				int[] nums = {3,2,4};
				int target = 6;
				System.out.println(Arrays.toString(solution.twoSum(nums, target)));

		}


		//leetcode submit region begin(Prohibit modification and deletion)
		// 1. double for()
//		class Solution {
//				public int[] twoSum(int[] nums, int target) {
//						int[] result = new int[2];
//						for (int i = 0; i < nums.length; i++) {
//								for (int j = i + 1; j < nums.length; j++) {
//										if (nums[i] + nums[j] == target) {
//												result[0] = i;
//												result[1] = j;
//												break;
//										}
//								}
//						}
//						return result;
//				}
//		}

		// 2. HashMap
		class Solution {
				public int[] twoSum(int[] nums, int target) {
						HashMap<Integer, Integer> numsHashMap = new HashMap<>();
						for (int i = 0; i < nums.length; i++) {
								if (numsHashMap.containsKey(target - nums[i])) {
										return new int[]{numsHashMap.get(target - nums[i]), i};
								} else {
										numsHashMap.put(nums[i], i);
								}
						}
						return null;
				}
		}

		// 3.  BinarySearch TODO
//		class Solution {
//				public int[] twoSum(int[] nums, int target) {
//						for (int i = 0; i < nums.length; i++) {
//								int flag = BinarySearch(target - nums[i], nums);
//								if (flag >= 0)
//										return new int[]{i, flag};
//								break;
//						}
//						return null;
//				}
//
//				// BinarySearch
//				public int BinarySearch(int key, int[] nums) {
//						Arrays.sort(nums);
//						int lo = 0;
//						int hi = nums.length - 1;
//						while (lo <= hi) {
//								int mid = (lo + hi) / 2;
//								if (nums[mid] > key)
//										hi = mid - 1;
//								else if (nums[mid] < key)
//										lo = mid + 1;
//								else
//										return mid;
//						}
//						return -1;
//				}
//		}

//leetcode submit region end(Prohibit modification and deletion)

}