package com.harvikhaira.robots.enums;

public enum InstructionEnum {
    FORWARD("F"),
    LEFT("L"),
    RIGHT("R");

    private final String instruction;

    InstructionEnum(String instruction) {
        this.instruction = instruction;
    }
}
