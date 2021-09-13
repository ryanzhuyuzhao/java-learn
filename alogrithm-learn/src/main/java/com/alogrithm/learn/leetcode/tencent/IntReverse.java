package com.alogrithm.learn.leetcode.tencent;


/**
 * @filename IntReverse
 * @description 整数回转
 * @author朱愈曌
 * @date 2021/9/13 16:37
 */
public class IntReverse {

	/**
	 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
	 *
	 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/reverse-integer
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
				return 0;
			}
			int digit = x % 10;
			x /= 10;
			rev = rev * 10 + digit;
		}
		return rev;
	}

	public static void main(String[] args) {
		IntReverse intReverse = new IntReverse();
		System.out.println(intReverse.reverse(1224214219));
	}

}
