package fr.uge.dom;

import java.util.Objects;

final class DOMElement implements DOMNode{
    private final String name;
    private final DOMDocument parent;

    DOMElement(DOMDocument parent, String name){
        Objects.requireNonNull(name);
        Objects.requireNonNull(parent);
        this.name = name;
        this.parent = parent;
    }
    @Override
    public String name() {
        return name;
    }
}
