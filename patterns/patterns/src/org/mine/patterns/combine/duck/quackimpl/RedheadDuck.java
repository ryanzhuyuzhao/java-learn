package org.mine.patterns.combine.duck.quackimpl;

import org.mine.patterns.combine.Observable;
import org.mine.patterns.combine.Observer;
import org.mine.patterns.combine.duck.Quackable;

/**
 * @ClassName RedheadDuck
 * @Description
 * @Author Administrator
 * @Date 2021/4/7 0007 20:48
 * @Version 1.0
 */
public class RedheadDuck implements Quackable {
    private Observable observable;

    public RedheadDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        observable.notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
