package com.solvd.farm.exception;

import java.io.IOException;

public class DuplicateEntryException extends RuntimeException {
    public DuplicateEntryException(String message) {
        super(message);
    }
}
