package org.camokatuk.amazingbrocessor.broc.command;

public class MixerCommand implements BrocessorHttpCommand
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

    public MixerCommand(String target, int index, String control, String value)
    {
        this.target = target;
        this.index = String.valueOf(index);
        this.state = new State[]{new State(control, value)};
    }

    public MixerCommand(String target, int index, State[] state)
    {
        this.target = target;
        this.index = String.valueOf(index);
        this.state = state;
    }
}
