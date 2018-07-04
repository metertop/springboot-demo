package com.example.demo.exception;

/**
 * Created by haoyuexun on 2018/6/27.
 */
public class DemoError implements BaseError {

    private String errorMsg;

    public DemoError(){
        super();
    }

    public DemoError(String errorMsg) {
        super();
        this.errorMsg = errorMsg;
    }

    @Override
    public String toErrorMessage(String error) {
        return this.errorMsg;
    }
}
