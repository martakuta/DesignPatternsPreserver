package examples.mediator;

import processor.mediator.MediatorPattern;

@MediatorPattern.Component
public class SendButton extends Component {
    SendButton(Mediator dialog) {
        super(dialog);
        this.visible = false;
    }

    public void click() {
        dialog.notify(SendButton.class, "click");
    }
}
