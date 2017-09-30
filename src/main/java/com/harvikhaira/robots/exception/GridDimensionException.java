package com.harvikhaira.robots.exception;

public class GridDimensionException extends Exception {
    public GridDimensionException() {
        super("com.harvikhaira.robots.service.Grid setup dimensions exceed maximum of 50");
    }
}
