package examples.mediator;

import processor.mediator.MediatorPattern;

@MediatorPattern.IMediator
public interface Mediator {
    @MediatorPattern.NotifyMethod
    void notify(Class<? extends Component> sender, String event);
}
