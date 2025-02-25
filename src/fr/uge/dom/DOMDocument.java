package fr.uge.dom;

import java.util.Objects;

public final class DOMDocument{
    public DOMNode createElement(String name){
        Objects.requireNonNull(name);
        return new DOMElement(this, name);
    }
}
