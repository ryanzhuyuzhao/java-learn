package org.java8.part3.progress_api;

public interface Resizable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    default void setRelativeSize(int wFactor, int hFactor) {
        System.out.println(wFactor + " " + hFactor);
    }
}
