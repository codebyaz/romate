package com.codebyaz.romate.action;

public enum ActionsEnum {

    TYPE(1),
    CLICK(2),
    SEND_KEYS(3),
    CLEAR(4),
    SUBMIT(5),
    SELECT(6),
    NAVIGATE(7),
    GET_TEXT(8);

    private final Integer action;

    ActionsEnum(Integer action) {
        this.action = action;
    }
}
