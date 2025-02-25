package fr.uge.dom;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DOMDocument{
    private final Map<String, DOMNode> elements = new HashMap<>();

    public DOMNode createElement(String name){
        Objects.requireNonNull(name);
        return new DOMElement(this, name, Map.of());
    }

    public DOMNode createElement(String name, Map<String, Object> attributes){
        Objects.requireNonNull(name);
        Objects.requireNonNull(attributes);
        checkValues(attributes);
        var element = new DOMElement(this, name, attributes);
        checkId(attributes, element);
        return element;
    }

    private void checkValues(Map<String, Object> attributes){
        Objects.requireNonNull(attributes);
        for(var value : attributes.values()){
            switch (value){
                case String _, Boolean _, Integer _, Long _, Float _, Double _ -> {}
                default -> throw new IllegalArgumentException("Map value must be a String, Boolean, Integer, Long, Float or Double");
            }
        }
    }

    private void checkId(Map<String, Object> attributes, DOMElement element) {
        Objects.requireNonNull(attributes);
        Objects.requireNonNull(element);
        switch (attributes.get("id")) {
            case String id -> {
                if (id.isEmpty()) {
                    throw new IllegalArgumentException("value for id can't be empty");
                }
                elements.putIfAbsent(id, element);
            }
            case null -> {}
            default -> throw new IllegalArgumentException("id value needs to be a String");
        }
    }

    public DOMNode getElementById(String id){
        Objects.requireNonNull(id);
        return elements.get(id);
    }
}
