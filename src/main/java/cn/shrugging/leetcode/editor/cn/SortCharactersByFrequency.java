/**
 * @ author  shrugginG
 * @ date  2021-11-10 16:24:14
 * @ question [451]根据字符出现频率排序
 * @ description Soultion to the leetcode questions.
 */

//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 347 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

public class SortCharactersByFrequency {
		public static void main(String[] args) {
				Solution solution = new SortCharactersByFrequency().new Solution();
//				String s = "shrugging";
//				char[] chars = s.toCharArray();
//				HashMap<Character, Integer> frequencyForS = new HashMap<>();
//				for (char singleChar : chars)
//						frequencyForS.put(singleChar, frequencyForS.getOrDefault(singleChar, 0) + 1);
//				System.out.println(frequencyForS);

//				ArrayList<Character> test=new ArrayList<>();
//				test.add('a');
//				test.add('b');
//				String str = test.stream().map(e->e.toString()).reduce((acc, e) -> acc  + e).get();
//				System.out.println(str);

				String test = "tree";
				System.out.println(solution.frequencySort(test));
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		class Solution {
				public String frequencySort(String s) {
						char[] chars = s.toCharArray();
						HashMap<Character, Integer> frequencyForS = new HashMap<>();
						for (char singleChar : chars)
								frequencyForS.put(singleChar, frequencyForS.getOrDefault(singleChar, 0) + 1);
						ArrayList<Character>[] buckets = new ArrayList[chars.length + 1];
						for (char key : frequencyForS.keySet()) {
								int frequency = frequencyForS.get(key);
								if (buckets[frequency] == null)
										buckets[frequency] = new ArrayList<>();
								buckets[frequency].add(key);
						}
						StringBuilder res = new StringBuilder();
						for (int i = buckets.length - 1; i > 0; i--) {
								if (buckets[i] == null)
										continue;
								for (char singleChar : buckets[i]) {
										for (int j = 0; j < i; j++)
												res.append(singleChar);
								}
						}
//						return resChars.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get();
						return res.toString();
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}