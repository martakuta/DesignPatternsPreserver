package examples.composite;


import processor.composite.CompositePattern;

@CompositePattern.Leaf
public class Dot implements Graphic {

    private int x;
    private int y;

    private int value;

    private static final int PICTURE_SIZE = 10;

    @CompositePattern.ExecuteMethod
    @Override
    public int[][] draw() {
        int[][] array = new int[PICTURE_SIZE][PICTURE_SIZE];
        array[x][y] = value;
        return array;
    }
}
