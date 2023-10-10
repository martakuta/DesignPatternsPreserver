package examples.composite;

import processor.composite.CompositePattern;

import java.util.ArrayList;

@CompositePattern.Composite
public class CompoundGraphic implements Graphic {

    @CompositePattern.ComponentsListField
    private ArrayList<Graphic> children;
    private static final int PICTURE_SIZE = 10;
    @CompositePattern.ExecuteMethod
    @Override
    public int[][] draw() {
        int[][] array = new int[PICTURE_SIZE][PICTURE_SIZE];
        for (Graphic child : children) {
            int[][] childArray = child.draw();
            for (int i=0; i<PICTURE_SIZE; i++) {
                for (int j=0; j<PICTURE_SIZE; j++) {
                    if (childArray[i][j] > array[i][j])
                        array[i][j] = childArray[i][j];
                }
            }
        }
        return array;
    }

    @CompositePattern.AddComponentMethod
    public void addChildren(Graphic g) {
        children.add(g);
    }

    @CompositePattern.RemoveComponentMethod
    public void removeChildren(Graphic g) {
        children.remove(g);
    }

    @CompositePattern.GetComponentMethod
    public Graphic addChildren(int index) {
        return children.get(index);
    }
}
