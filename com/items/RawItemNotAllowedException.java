package com.items;

public class RawItemNotAllowedException extends Exception {
    /**
     * To avoid big error and some minimal exception, we do not authorized Objet Item in Raw in the game.
     */
    public RawItemNotAllowedException() {
        super("Raw item are not allowed");
    }
}
