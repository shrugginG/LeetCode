/**
 * @ author  shrugginG
 * @ date  2021-11-09 10:06:37
 * @ question [215]数组中的第K个最大元素
 * @ description Soultion to the leetcode questions.
 */

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1366 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
		public static void main(String[] args) {
				Solution solution = new KthLargestElementInAnArray().new Solution();
				int a[] = {32, 23, 1, 34, 5, 7, 3, 2, 1};
				System.out.println(Arrays.toString(a));
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		class Solution {

				// 1. 经典快排
//				public int findKthLargest(int[] nums, int k) {
//						quickSort(nums, 0, nums.length - 1);
//						return nums[nums.length - k];
//				}
//
//				public void exch(int[] a, int i, int j) {
//						int temp = a[i];
//						a[i] = a[j];
//						a[j] = temp;
//				}
//
//				public int partition(int[] a, int lo, int hi) {
//						int i = lo, j = hi + 1;
//						int v = a[lo];
//						while (true) {
//								while (a[++i] < v)
//										if (i == hi)
//												break;
//								while (a[--j] > v)
//										if (hi == lo)
//												break;
//								if (i >= j)
//										break;
//								exch(a, i, j);
//						}
//						exch(a, lo, j);
//						return j;
//				}
//
//				public void quickSort(int[] a, int lo, int hi) {
//						if (hi <= lo)
//								return;
//						int pivot = partition(a, lo, hi);
//						quickSort(a, lo, pivot - 1);
//						quickSort(a, pivot + 1, hi);
//				}

				public int findKthLargest(int[] nums, int k) {
						// 1. 自己定义的大顶堆方法
//						int[] newHeapNums = new int[nums.length + 1];
//						for (int i = 1; i <= nums.length; i++) {
//								newHeapNums[i] = nums[i - 1];
//						}
//						HeapSort heap = new HeapSort();
//						return heap.find(newHeapNums, k);

						// 2. Java中的优先队列是通过小顶堆实现的
						PriorityQueue<Integer> a = new PriorityQueue<>();
						for (int num : nums) {
								a.add(num);
								if (a.size() > k)
										a.poll();
						}
						return a.peek();
				}

				public class HeapSort {
						public void initHeapAndSorted(int[] nums) {
								int N = nums.length - 1;
								for (int i = N / 2; i >= 1; i--)
										sink(nums, i, N);

								while (N > 1) {
										exch(nums, 1, N--);
										sink(nums, 1, N);
								}
						}

						// 直接查找第k个最大的数
						public int find(int[] nums, int k) {
								int N = nums.length - 1;
								for (int i = N / 2; i >= 1; i--)
										sink(nums, i, N);

								while (N > 1 && k > 0) {
										exch(nums, 1, N--);
										sink(nums, 1, N);
										k--;
								}

								return nums[N - k + 1];

						}


						public void exch(int[] a, int i, int j) {
								int temp = a[i];
								a[i] = a[j];
								a[j] = temp;
						}

						public void sink(int[] nums, int i, int N) {
								while (2 * i <= N) {
										int j = i * 2;
										if (j < N && nums[j] < nums[j + 1])
												j++;
										if (nums[i] >= nums[j])
												break;
										exch(nums, i, j);
										i = j;
								}
						}
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}