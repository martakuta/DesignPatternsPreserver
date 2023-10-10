package examples.mediator;

import processor.mediator.MediatorPattern;

@MediatorPattern.Component
public class AgreeCookiesCheckbox extends Component {
    AgreeCookiesCheckbox(Mediator dialog) {
        super(dialog);
    }

    public void check() {
        dialog.notify(AgreeCookiesCheckbox.class, "check");
    }
}
