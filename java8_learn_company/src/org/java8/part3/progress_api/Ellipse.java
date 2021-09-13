package org.java8.part3.progress_api;

public class Ellipse implements Resizable {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {
        System.out.println(width);
    }

    @Override
    public void setHeight(int height) {
        System.out.println(height);
    }

    @Override
    public void setAbsoluteSize(int width, int height) {
        System.out.println(width + " " + height);
    }
}
