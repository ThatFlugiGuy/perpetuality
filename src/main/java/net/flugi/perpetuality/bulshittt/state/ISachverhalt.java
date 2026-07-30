package net.flugi.perpetuality.bulshittt.state;

public interface ISachverhalt {
    void enable();

    void disable();

    void enableFor(int ticks);

    void tick();

    boolean isActive();

    int ticksLeft();
}
