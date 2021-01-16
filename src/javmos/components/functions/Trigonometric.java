package javmos.components.functions;

import javmos.JavmosGUI;

public abstract class Trigonometric extends Function {

    protected double a;
    protected double k;
    public String trigFunction;
    public final String name;

    public Trigonometric(JavmosGUI gui, String trigFunction, String name) {
        super(gui);
        this.trigFunction = trigFunction;
        this.name = name;
    }
}
