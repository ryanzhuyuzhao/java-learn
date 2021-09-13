package org.java8.part3.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S",shops));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    public static List<String> findPrices(String product, List<Shop> shops) {
        //普通流  耗时4133ms
        /*return shops.stream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());*/

        //并行流  耗时1111ms
        /*return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());*/

        //使用CompletableFuture  耗时2059ms
        /*List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " +
                                shop.getPrice(product)
                ))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());*/
        //耗时8594 msecs
        /*return shops.stream().map(shop -> shop.getPrice(product))//取得每个shop对象中商品的原始价格
                .map(Quote::parse)//在Quote对象中对shop返回的字符串进行转换
                .map(Discount::applyDiscount)//联系Discount服务，为每个Quote申请折扣s
                .collect(Collectors.toList());*/

        //使用同步和异步操作 耗时2138ms
        Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);//使用守护线程--这种方式不会阻止程序的关停
                return t;
            }
        });
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product),executor
                ))//以异步方式取得每个shop中指定产品的原始价格
                .map(future -> future.thenApply(Quote::parse))//Quote对象存在时，对其返回的值进行转换
                .map(future -> future.thenCompose(//使用另一个异步任务构造期望的Future，申请折扣
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote),executor
                        )
                ))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)//等待流中的所有Future执行完毕，并提取各自的返回值
                .collect(Collectors.toList());

    }
}
