package fr.uge.dom;

public class Main {
    public static void main(String[] args){
        // Q1
        DOMDocument document = new DOMDocument();
        DOMNode node = document.createElement("div");
        System.out.println(node.name());  // div
    }
}
