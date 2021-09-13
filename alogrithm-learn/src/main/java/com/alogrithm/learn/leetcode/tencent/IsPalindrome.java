package com.alogrithm.learn.leetcode.tencent;

/**
 * @filename IsPalindrome
 * @description 一个数是否为回文数
 * @author朱愈曌
 * @date 2021/9/13 17:08
 */
public class IsPalindrome {
	/**
	 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
	 *
	 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/palindrome-number
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int num = x;
		int rev = 0;
		while (num != 0) {
			int digit = num % 10;
			num /= 10;
			rev = rev * 10 + digit;
		}
		return rev == x ? true:false;
	}

	public static void main(String[] args) {
		System.out.println(new IsPalindrome().isPalindrome(121));
	}
}
