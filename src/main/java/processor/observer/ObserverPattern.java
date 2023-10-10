package processor.observer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface ObserverPattern {

//    PUBLISHER

    @Target(ElementType.TYPE)
    @interface Publisher {}

    @Target(ElementType.METHOD)
    @interface SubscribeMethod {}

    @Target(ElementType.METHOD)
    @interface UnsubscribeMethod {}

    @Target(ElementType.METHOD)
    @interface NotifyMethod {}

    @Target(ElementType.FIELD)
    @interface SubscribersField {}

//    SUBSCRIBER

    @Target(ElementType.TYPE)
    @interface ISubscriber {}

    @Target(ElementType.TYPE)
    @interface ConcreteSubscriber {}

    @Target(ElementType.METHOD)
    @interface UpdateMethod {}


}
