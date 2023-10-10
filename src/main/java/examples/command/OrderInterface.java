package examples.command;

import processor.command.CommandPattern;

@CommandPattern.ICommand
public interface OrderInterface {
    @CommandPattern.ExecuteMethod
    void order();
}
