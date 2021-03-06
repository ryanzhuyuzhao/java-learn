package org.java8.part2.stream;

import org.java8.part3.stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DishStreamTest {

    public static void main(String[] args) {
        /*List<Dish> menu = Arrays.asList(new Dish("hot pot",342.0),new Dish("Beijing Roast Duck",432.0),new Dish("Chilli Fish Head",232.0));

        List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalories() < 400)
                                                            .sorted(Comparator.comparing(Dish::getCalories))
                                                            .map(Dish :: getName)
                                                            .collect(Collectors.toList());

        List<String> lowCaloricDishesName = menu.parallelStream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish :: getName)
                .collect(Collectors.toList());
        System.out.println(lowCaloricDishesName);*/

        List<Dish> menu = Arrays.asList(new Dish("Chongqing hot and sour powder",true,300, Dish.Type.OTHER),
                new Dish("Changsha stinky tofu",true,249, Dish.Type.OTHER),
                new Dish("Beijing Roast Duck",false,800, Dish.Type.MEAT),
                new Dish("Chilli Fish Head",false,780, Dish.Type.FISH),
                new Dish("roast fish",false,798, Dish.Type.FISH),
                new Dish("Dongpo Braised Pork",false,934, Dish.Type.MEAT),
                new Dish("Yangzhou Fried Rice",true,345, Dish.Type.OTHER));



        /*List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);*/

        /*int calories = menu.stream().mapToInt(Dish::getCalories)
                .sum();
        System.out.println("All of calories: " + calories);*/

        /*IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());*/

        /*Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1,100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1== 0)
                        .mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
                );
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));*/

        /*long howManyDishes = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);*/

        /*long howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);*/

        /**
         * ????????????????????????????????????
         */
        /*Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish.get().getCalories());*/

        /**
         * ??????
         */
        /*int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("All calories of dishes:" + totalCalories);*/

        /**
         * ????????????
         */
        /*double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("the average of calories:" + avgCalories);*/

        /**
         * summarizingInt???????????????IntSummaryStatistics???????????????????????????????????????????????????
         */
        /*IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);*/

        /**
         * ???????????????
         */
        /*String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);*/

        /*int totalCalories = menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
        System.out.println(totalCalories);*/

        /**
         * ??????
         */
        /*Map<Dish.Type,List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        dishesByType.forEach((k,v) -> {
            String names = v.stream().map(Dish::getName).collect(Collectors.joining(","));
            System.out.println(k + "=[" + names + "]");
        });*/

        /*Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            }else if (dish.getCalories() <= 700) {
                return  CaloricLevel.NORMAL;
            }else {
                return  CaloricLevel.FAT;
            }
        }));

        dishesByCaloricLevel.forEach((k,v) -> {
            String names = v.stream().map(Dish::getName).collect(Collectors.joining(","));
            System.out.println(k + "=[" + names + "]");
        });*/


        /**
         * ????????????
         */
        /*Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.groupingBy(dish -> {
                  if (dish.getCalories() <= 400) {
                      return CaloricLevel.DIET;
                  }else if (dish.getCalories() <= 700) {
                      return  CaloricLevel.NORMAL;
                  }else {
                      return  CaloricLevel.FAT;
                  }
                })));

        dishesByTypeCaloricLevel.forEach((k,v) -> {
            v.forEach((k2,v2) -> {
                String names2 = v2.stream().map(Dish::getName).collect(Collectors.joining(","));
            });
        });*/

        /*Map<Dish.Type,Long> typesCount = menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
        typesCount.forEach((k,v) -> {
            System.out.println(k + "=" + v);
        });*/

        /*Map<Dish.Type,Optional<Dish>> mostCaloricByType = menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        mostCaloricByType.forEach((k,v) -> {
            System.out.println(k + "=" + v.get().getName());
        });*/


        /**
         * ??????
         */
        /*Map<Boolean,List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));*/

    }

    public enum CaloricLevel {DIET,NORMAL,FAT}
}
