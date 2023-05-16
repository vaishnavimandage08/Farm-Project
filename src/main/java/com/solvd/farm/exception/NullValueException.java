package com.solvd.farm.exception;

import java.io.IOException;

public class NullValueException extends IOException {
    public NullValueException(String message) {
        super(message);
    }

}
