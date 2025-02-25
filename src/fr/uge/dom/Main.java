package fr.uge.dom;

import java.util.Map;

public class Main {
    public static void main(String[] args){
        // Q1
//         DOMDocument document = new DOMDocument();
//         DOMNode node = document.createElement("div");
//         System.out.println(node.name());  // div
        // Q2
//        var document = new DOMDocument();
//        var node = document.createElement("div", Map.of("color", "red", "visible", true));
//        System.out.println(node.name());  // div
//        System.out.println(node.attributes());  // {color=red, visible=true}
        // Q3
//        var document = new DOMDocument();
//        var node = document.createElement("div", Map.of("foo", "bar"));
//        System.out.println(node); // <div foo="bar"></div>
        // Q4
        var document = new DOMDocument();
        var node = document.createElement("div", Map.of("id", "foo42"));
        System.out.println(document.getElementById("foo42"));  // <div id="foo42"></div>
    }
}
