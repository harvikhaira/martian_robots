package main.java.harvikhaira.robots.enums;

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
        return OrientationEnum.getEnum(this.leftValue);
    }

    public OrientationEnum getRightValue() { return OrientationEnum.getEnum(this.rightValue); }

    public static OrientationEnum getEnum(String val) {
        for (OrientationEnum e : OrientationEnum.values()) {
            if (val.equals(e.getValue())) {
                return e;
            }
        }

        return null;
    }
}
