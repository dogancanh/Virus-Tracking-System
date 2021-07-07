package com.test.tracking.iterator.base;

public interface Iterator<T> {
    // iterate over
    boolean hasNext();

    // returns the next element
    T next();
}
