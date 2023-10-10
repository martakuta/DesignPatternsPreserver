package examples.mediator;

import processor.mediator.MediatorPattern;

import java.util.Objects;

@MediatorPattern.ConcreteMediator
public class CookieConfirmationDialog implements Mediator {

    private AgreeCookiesCheckbox checkbox;
    private NameInput input;
    private SendButton button;

    @MediatorPattern.NotifyMethod
    @Override
    public void notify(Class<? extends Component> sender, String event) {
        if (sender == AgreeCookiesCheckbox.class && Objects.equals(event, "check")) {
            input.setVisible(true);
            button.setVisible(true);
        } else if (sender == SendButton.class && Objects.equals(event, "click")) {
            // save confirmation
        }
    }
}
