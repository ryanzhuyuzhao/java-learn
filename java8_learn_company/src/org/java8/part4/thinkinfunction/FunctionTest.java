package org.java8.part4.thinkinfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FunctionTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,9);
        List<List<Integer>> answer = subsets(list);
        answer.stream().forEach(System.out::println);
    }

    /**
     * 求集合的所有子集
     * @param list
     * @return
     */
    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {//如果输入为空，它就只有包含一个子集，既空列表自身
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.EMPTY_LIST);
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1,list.size());

        List<List<Integer>> subans = subsets(rest);//取出一个元素first，找出剩余部分的所有子集，并将其赋予subans。subans构成了结果的一半
        List<List<Integer>> subans2 = insertAll(first,subans);
        return concat(subans, subans2);//将两个答案整合在一起就完成了任务

    }

    public static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    public static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
}
