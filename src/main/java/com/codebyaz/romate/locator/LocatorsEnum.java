package com.codebyaz.romate.locator;

public enum LocatorEnum {

    ID("id"),
    NAME("name"),
    CLASS("className"),
    CSS_SELECTOR("css"),
    TAG("tagName"),
    LINK_TEXT("linkText"),
    PARTIAL_LINK_TEXT("partialLinkText"),
    XPATH("xpath");

    private final String locator;

    LocatorEnum(String locator) {
        this.locator = locator;
    }

    public String get() {
        return this.locator;
    }
}
