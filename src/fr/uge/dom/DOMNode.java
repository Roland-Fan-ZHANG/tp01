package fr.uge.dom;

public sealed interface DOMNode permits DOMElement{
    String name();
}
