package examples.memento;

import processor.memento.MementoPattern;

import java.util.Stack;

@MementoPattern.Caretaker
public class Command {
    private TextEditor textEditor;
    @MementoPattern.HistoryField
    private Stack<TextEditor.Snapshot> history;

    Command(TextEditor t) {
        textEditor = t;
        history = new Stack<>();
    }

    @MementoPattern.RestoreMethod
    public void undo() {
        TextEditor.Snapshot s = history.pop();
        textEditor.undo(s);
    }

    @MementoPattern.CreateMementoMethod
    public void doSomething() {
        TextEditor.Snapshot s = textEditor.doBackup();
        history.push(s);
        // do something ...
    }
}
