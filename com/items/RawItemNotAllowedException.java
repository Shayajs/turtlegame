package com.items;

public class RawItemNotAllowedException extends Exception {
    public RawItemNotAllowedException() {
        super("Raw item are not allowed");
    }
}
