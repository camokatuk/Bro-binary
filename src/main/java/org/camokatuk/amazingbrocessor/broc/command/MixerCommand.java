package org.camokatuk.amazingbrocessor.broc.command;

public class MixerCommand implements BrocessorHttpCommand
{
    public static class State
    {
        private String in;
        private String out;
        private String value;

        public State(int in, int out, String value)
        {
            this.in = String.valueOf(in);
            this.out = String.valueOf(out);
            this.value = value;
        }

        public static State in(int in, String value)
        {
            return new State(in, 0, value);
        }

        public static State out(int out, String value)
        {
            return new State(0, out, value);
        }
    }


    private String target = "mixer";
    private String index;
    private State[] state;

    public MixerCommand(int index, State[] state)
    {
        this.index = String.valueOf(index);
        this.state = state;
    }
}
