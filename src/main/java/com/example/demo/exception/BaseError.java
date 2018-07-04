package com.example.demo.exception;

import java.io.Serializable;

/**
 * Created by haoyuexun on 2018/6/27.
 */
public interface BaseError extends Serializable{
    String toErrorMessage(String errorCode);
}
