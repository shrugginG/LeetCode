/**
 * @ author  shrugginG
 * @ date  2021-11-04 10:11:15
 * @ question [345]反转字符串中的元音字母
 * @ description Soultion to the leetcode questions.
 */

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 229 👎 0


package cn.shrugging.leetcode.editor.cn;

import java.util.*;

public class ReverseVowelsOfAString {
		public static void main(String[] args) {
				Solution solution = new ReverseVowelsOfAString().new Solution();
				char[] vowelChars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
				List<Character> chars = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
				Set<Character> charSet = new HashSet<>(chars);
				System.out.println(charSet.contains('a'));
		}

		//leetcode submit region begin(Prohibit modification and deletion)
		// 1. DoublePointer
//		class Solution {
//				public String reverseVowels(String s) {
//						String vowels = "AEIOUaeiou";
//						char[] charArray = s.toCharArray();
//						int lo = 0;
//						int hi = charArray.length - 1;
//						boolean loFlag = false;
//						boolean hiFlag = false;
//						while (lo < hi) {
//								if (vowels.contains(charArray[lo] + ""))
//										loFlag = true;
//								else
//										lo++;
//								if (vowels.contains(charArray[hi] + ""))
//										hiFlag = true;
//								else
//										hi--;
//								if (loFlag && hiFlag) {
//										char temp = charArray[lo];
//										charArray[lo] = charArray[hi];
//										charArray[hi] = temp;
//										loFlag = false;
//										hiFlag = false;
//										lo++;
//										hi--;
//								}
//
//						}
//						return String.valueOf(charArray);
//				}
//		}

		// 2. Use the HasHmap for the vowelchar search.
		class Solution {
				Character[] vowelChars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
				List<Character> chars = Arrays.asList(vowelChars);
				Set<Character> vowels = new HashSet<>(chars);

				public String reverseVowels(String s) {
						char[] charArray = s.toCharArray();
						int lo = 0;
						int hi = charArray.length - 1;
						boolean loFlag = false;
						boolean hiFlag = false;
						while (lo < hi) {
								if (vowels.contains(charArray[lo]))
										loFlag = true;
								else
										lo++;
								if (vowels.contains(charArray[hi]))
										hiFlag = true;
								else
										hi--;
								if (loFlag && hiFlag) {
										char temp = charArray[lo];
										charArray[lo] = charArray[hi];
										charArray[hi] = temp;
										loFlag = false;
										hiFlag = false;
										lo++;
										hi--;
								}

						}
						return String.valueOf(charArray);
				}
		}
//leetcode submit region end(Prohibit modification and deletion)

}