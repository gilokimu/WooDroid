package me.gilo.woodroid.firebasecart.common;

public enum Status {
    EMPTY,
    SUCCESS,
    ERROR,
    LOADING;

    public Status isLoading(){
        return LOADING;
    }
}
