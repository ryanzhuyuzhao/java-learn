package org.java8.part4.thinkinfunction;

/**
 * 破坏式更新和函数式更新的比较
 */
public class TrainJourney {
    public int price;
    public TrainJourney onward;

    public TrainJourney(int price, TrainJourney onward) {
        this.price = price;
        this.onward = onward;
    }

    /**
     * 破坏式更新
     * @param a
     * @param b
     * @return
     */
    public static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (a == null) {
            return b;
        }
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    /**
     * 函数式更新
     * @param a
     * @param b
     * @return
     */
    public static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }
}
