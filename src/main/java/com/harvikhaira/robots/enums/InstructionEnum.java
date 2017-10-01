package com.harvikhaira.robots.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InstructionEnum {
    FORWARD("F"),
    LEFT("L"),
    RIGHT("R");

    private final String instruction;
}
