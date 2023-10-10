package examples.memento;

import processor.memento.MementoPattern;

@MementoPattern.Originator
public class TextEditor {
    private String text;
    private int cursorX;
    private int cursorY;
    private int selectionWidth;

    TextEditor() {
        text = "";
        cursorX = 0;
        cursorY = 0;
        selectionWidth = 0;
    }

    @MementoPattern.CreateMementoMethod
    public Snapshot doBackup() {
        return new Snapshot(text, cursorX, cursorY, selectionWidth);
    }

    @MementoPattern.RestoreMethod
    public void undo(Snapshot s) {
        text = s.text;
        cursorX = s.cursorX;
        cursorY = s.cursorY;
        selectionWidth = s.selectionWidth;
    }

    @MementoPattern.Memento
    public class Snapshot {
        private final String text;
        private final int cursorX;
        private final int cursorY;
        private final int selectionWidth;

        Snapshot(String t, int x, int y, int sw) {
            text = t;
            cursorX = x;
            cursorY = y;
            selectionWidth = sw;
        }
    }

}
