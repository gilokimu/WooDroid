package me.gilo.wc.common;

public enum Status {
    EMPTY,
    SUCCESS,
    ERROR,
    LOADING;

    public Status isLoading(){
        return LOADING;
    }
}
