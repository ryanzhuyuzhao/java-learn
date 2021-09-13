package org.java8.part3.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionTest {

    public static void main(String[] args) {
        Trader Ryan = new Trader("Ryan","New York");
        Trader Jane = new Trader("Jane","Cambridge");
        Trader Jack = new Trader("Jack","Milan");
        Trader Mary = new Trader("Mary","London");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(Ryan,2011,2300),
                new Transaction(Ryan,2012,2780),
                new Transaction(Ryan,2013,3590),
                new Transaction(Ryan,2014,3890),
                new Transaction(Ryan,2015,4129),
                new Transaction(Ryan,2016,4678),
                new Transaction(Ryan,2017,5018),
                new Transaction(Jane,2011,300),
                new Transaction(Jane,2012,349),
                new Transaction(Jack,2011,1200),
                new Transaction(Jack,2012,789),
                new Transaction(Mary,2011,1300),
                new Transaction(Mary,2012,1100),
                new Transaction(Mary,2013,1320),
                new Transaction(Mary,2014,1480),
                new Transaction(Mary,2105,1800)
        );

        /*List<Transaction> tr2011 = transactions.stream().filter( transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        tr2011.stream().forEach(System.out::println);*/

        /*List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        cities.stream().forEach(System.out::println);*/

        /*List<Trader> traders = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        traders.stream().forEach(System.out::println);*/

        /*
         *以下代码执行效率不高：所有字符串都被反复连接，每次迭代的时候都要建立一个新的String对象
         */
        /*String tradersStr = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(a,b) -> a + b);

        System.out.println(tradersStr);*/

        /*String tradersStr = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(tradersStr);*/

        /*boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("AnyBody live in Milan? True or False: " + milanBased);*/

        /*transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);*/

        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("the highest of value: " + highestValue.get());

        Optional<Transaction> lowestValue = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println("the lowest of value: " + lowestValue.get().getValue());


    }
}
