package fr.uge.dom;

import java.util.*;
import java.util.stream.Collectors;

final class
DOMElement implements DOMNode {
    private final String name;
    private final DOMDocument parent;
    private final Map<String, Object> attributes;
    private final List<DOMNode> children;

    DOMElement(DOMDocument parent, String name, Map<String, Object> attributes) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(parent);
        this.name = name;
        this.parent = parent;
        this.attributes = Map.copyOf(attributes);
        this.children = new ArrayList<>();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Object> attributes() {
        return attributes;
    }

    @Override
    public void appendChild(DOMNode child) {
        Objects.requireNonNull(child);
        switch (child) {
            case DOMElement childElement -> {
                if (childElement.parent != this.parent) {
                    throw new IllegalStateException("Child must belong to the same document as the parent.");
                }
                children.add(child);
            }
            default -> throw new IllegalArgumentException("Only DOMElement instances can be added.");
        }
    }

    @Override
    public List<DOMNode> children() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        var attributesTag = attributes.entrySet().stream()
                .map(tag -> " " + tag.getKey() + "=\"" + tag.getValue() + "\"")
                .collect(Collectors.joining());
        var childrenStr = children.stream()
                .map(DOMNode::toString)
                .collect(Collectors.joining());
        return "<" + name + attributesTag + ">" + childrenStr + "</" + name + ">";
    }
}