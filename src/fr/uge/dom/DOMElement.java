package fr.uge.dom;

import java.util.Map;
import java.util.Objects;

final class DOMElement implements DOMNode{
    private final String name;
    private final DOMDocument parent;
    private final Map<String, Object> attributes;

    DOMElement(DOMDocument parent, String name, Map<String, Object> attributes){
        Objects.requireNonNull(name);
        Objects.requireNonNull(parent);
        this.name = name;
        this.parent = parent;
        this.attributes = Map.copyOf(attributes);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Object> attributes(){
        return attributes;
    }
}
