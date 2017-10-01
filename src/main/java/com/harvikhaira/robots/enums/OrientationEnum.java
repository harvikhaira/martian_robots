package com.harvikhaira.robots.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrientationEnum {
    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E", "N", "S"),
    WEST("W", "S", "N");

    private final String value;
    private final String leftValue;
    private final String rightValue;

    public OrientationEnum getLeftValue() {
        return OrientationEnum.valueOf(this.leftValue);
    }

    public OrientationEnum getRightValue() {
        return OrientationEnum.valueOf(this.rightValue);
    }
}
