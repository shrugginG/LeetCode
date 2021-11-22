/**
 * @ author  shrugginG
 * @ date  2021-11-04 18:20:09
 * @ question [524]通过删除字母匹配到字典里最长单词
 * @ description Soultion to the leetcode questions.
 */

//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 263 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.ArrayList;

public class LongestWordInDictionaryThroughDeleting {
		public static void main(String[] args) {
				Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
				System.out.println(solution.isContain("abpcplea", "apple"));
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		class Solution {
				// ArrayList -> List
				public String findLongestWord(String s, ArrayList<String> dictionary) {
						String longestString = "";
						for (String target : dictionary) {
								int l1 = longestString.length(), l2 = target.length();
								if (l1 > l2 || (l1 == l2 && longestString.compareTo(target) < 0)) {
										continue;
								}
								if (isContain(s, target)) {
										longestString = target;
								}
						}
						return longestString;
				}

				public boolean isContain(String s, String sub) {
						char[] chars = s.toCharArray();
						char[] subChars = sub.toCharArray();
						int pointer1 = chars.length - 1;
						int pointer2 = subChars.length - 1;
						while (pointer1 >= 0) {
								if (pointer2 < 0)
										return true;

								else if (chars[pointer1] != subChars[pointer2]) {
										pointer1--;
								} else if (chars[pointer1] == subChars[pointer2]) {
										pointer1--;
										pointer2--;
										if (pointer2 < 0)
												return true;
								}
						}
						return false;
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}