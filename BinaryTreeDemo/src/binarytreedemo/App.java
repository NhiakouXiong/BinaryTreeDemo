package binarytreedemo;

import net.datastructures.*;
import dsaj.trees.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        makeATree();
    }

    public static void makeATree() {
        LinkedBinaryTree<String> airports = new LinkedBinaryTree<>();
        Position<String> atwPos = airports.addRoot("ATW");
        Position<String> oshPos = airports.addLeft(atwPos, "OSH");
        airports.addLeft(oshPos, "IMT");
        Position<String> grbPos = airports.addRight(airports.root(), "GRB");
        airports.addLeft(grbPos, "MKE");

        Iterable<Position<String>> airportsIT = airports.preorder();

        for(Position<String> pos : airportsIT){
        System.out.printf("%s\n", pos.getElement());
        }
        Iterator<String> airportsIterator = airports.iterator(); // what type of traversal is done here? Let'se find out ...

        while (airportsIterator.hasNext()) {
            System.out.printf("%s\n", airportsIterator.next());
        }

        java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
        TraversalExamples.printPreorderLabeled(airports, airports.root(), path);

    }
}