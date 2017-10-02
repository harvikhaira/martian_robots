package main.java.harvikhaira.robots.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InstructionEnum {
    FORWARD("F"),
    LEFT("L"),
    RIGHT("R");

    private final String instruction;

    public static InstructionEnum getEnum(String val) {
        for (InstructionEnum e : InstructionEnum.values()) {
            if (val.equals(e.getInstruction())) {
                return e;
            }
        }

        return null;
    }
}
