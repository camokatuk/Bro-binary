package org.camokatuk.amazingbrocessor.broc.command;

public class DeviceCommand implements BrocessorHttpCommand
{
    public static class State
    {
        private String control;
        private String value;

        public State(String control, String value)
        {
            this.control = control;
            this.value = value;
        }
    }

    private String target;
    private String index;
    private State[] state;

    public DeviceCommand(String target, int index, String control, String value)
    {
        this(target, index, new State[]{new State(control, value)});
    }

    public DeviceCommand(String target, int index, State[] state)
    {
        this.target = target;
        this.index = String.valueOf(index);
        this.state = state;
    }
}
