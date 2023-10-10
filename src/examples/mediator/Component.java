package examples.mediator;

import processor.mediator.MediatorPattern;

@MediatorPattern.Component
public class Component {
    protected Mediator dialog;
    protected boolean visible;

    Component(Mediator dialog) {
        this.dialog = dialog;
        this.visible = true;
    }

    public boolean getVisible() {return visible;}

    public void setVisible(boolean v) {visible = v;}
}