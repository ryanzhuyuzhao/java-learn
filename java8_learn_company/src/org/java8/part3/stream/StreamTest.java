package org.java8.part3.stream;

import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        /*
         *构建流
         */

        /**
         * 由值创建流
         */
        /*Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);*/

        /**
         * 由数组创建流
         */
        /*int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);*/

        /**
         * 由文件生成流
         */
        /*long uniqueWords = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get("D:\\workspace_ideal\\workspace_practice_mine\\out\\production\\workspace_practice_mine\\org\\java8\\stream\\data.txt"), Charset.defaultCharset());
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("total unique words:" + uniqueWords);*/

        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }
}
