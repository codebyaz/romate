package com.codebyaz.romate.locator;

public enum LocatorsEnum {

    ID(1),
    NAME(2),
    CLASS(3),
    CSS_SELECTOR(4),
    TAG(5),
    LINK_TEXT(6),
    PARTIAL_LINK_TEXT(7),
    XPATH(8);

    private final Integer locator;

    LocatorsEnum(Integer locator) {
        this.locator = locator;
    }

    public Integer get() {
        return this.locator;
    }
}
