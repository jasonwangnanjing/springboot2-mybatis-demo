package com.jw.exception;

public class ParameterInvalidException extends RuntimeException {

    public ParameterInvalidException(int i)
    {
        System.out.println("id  " +i +" entered is not valid");
    }

    public ParameterInvalidException()
    {
        System.out.println("id  " +" entered is not valid");
    }

    @Override
    public String getMessage() {
        return "id can not be null for update";
    }
}
