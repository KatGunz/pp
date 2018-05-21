package com.project.winter.Exceptions;

public class NonUniqueResultException extends Exception{

    private int resultSize;
    public NonUniqueResultException( int resultSize) {

        super(String.format("Expected a result of size 1, but instead found %s results.", resultSize));
        this.resultSize = resultSize;

    }
    public int getResourceName() {
        return resultSize;
    }
}
