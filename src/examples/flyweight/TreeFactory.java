package examples.flyweight;

import processor.flyweight.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

@FlyweightPattern.FlyweightFactory
public class TreeFactory {
    Map<String, Tree> trees;
    TreeFactory() {
        trees = new HashMap<>();
    }
    @FlyweightPattern.GetFlyweightMethod
    public Tree getTree(String name) {
        if (trees.containsKey(name)) {
            return trees.get(name);
        } else {
            Tree tree = new TreeType(name);
            trees.put(name, tree);
            return tree;
        }
    }
}
