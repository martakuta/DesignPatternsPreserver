package examples.mediator;

import processor.mediator.MediatorPattern;

@MediatorPattern.Component
public class NameInput extends Component {
    NameInput(Mediator dialog) {
        super(dialog);
        this.visible = false;
    }

    public void keypress() {
        dialog.notify(NameInput.class, "keypress");
    }
}
