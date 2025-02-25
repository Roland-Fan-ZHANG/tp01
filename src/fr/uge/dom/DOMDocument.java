package fr.uge.dom;

import java.util.Map;
import java.util.Objects;

public final class DOMDocument{
    public DOMNode createElement(String name){
        Objects.requireNonNull(name);
        return new DOMElement(this, name, Map.of());
    }

    public DOMNode createElement(String name, Map<String, Object> attributes){
        Objects.requireNonNull(name);
        Objects.requireNonNull(attributes);
        attributesPreconditions(attributes);
        return new DOMElement(this, name, attributes);
    }

    private void attributesPreconditions(Map<String, Object> attributes){
        for(var value : attributes.values()){
            switch (value){
                case String _, Boolean _, Integer _, Long _, Float _, Double _ -> {}
                default -> throw new IllegalArgumentException();
            }
        }
    }
}
