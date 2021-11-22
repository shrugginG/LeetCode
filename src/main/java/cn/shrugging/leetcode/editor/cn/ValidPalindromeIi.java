/**
 * @ author  shrugginG
 * @ date  2021-11-04 14:32:36
 * @ question [680]验证回文字符串 Ⅱ
 * @ description Soultion to the leetcode questions.
 */

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 410 👎 0


package cn.shrugging.leetcode.editor.cn;

import sun.security.util.ArrayUtil;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

public class ValidPalindromeIi {
		public static void main(String[] args) {
				Solution solution = new ValidPalindromeIi().new Solution();
				String test = "acdba";
				System.out.println(solution.validPalindrome(test));

		}

		//leetcode submit region begin(Prohibit modification and deletion)
		class Solution {
				public boolean validPalindrome(String s) {
						char[] chars = s.toCharArray();
						int lo = 0;
						int hi = chars.length - 1;
						boolean deletedFlag = false;
						while (lo < hi) {
								if (!deletedFlag && (chars[lo] != chars[hi])) {
										deletedFlag = true;
										if (judgePalindrome(Arrays.copyOfRange(chars, lo + 1, hi + 1)) || judgePalindrome(Arrays.copyOfRange(chars, lo, hi)))
												return true;
										else
												return false;
								} else if (deletedFlag && (chars[lo] != chars[hi]))
										return false;
								else {
										lo++;
										hi--;
								}
						}
						return true;
				}

				public boolean judgePalindrome(char[] chars) {
						int lo = 0;
						int hi = chars.length - 1;
						while (lo < hi) {
								if (chars[lo] != chars[hi]) {
										return false;
								}
								lo++;
								hi--;
						}
						return true;
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}