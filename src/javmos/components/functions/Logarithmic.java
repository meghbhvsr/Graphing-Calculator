package javmos.components.functions;

import javmos.JavmosGUI;
import javmos.enums.FunctionType;

public class Logarithmic extends Function {

    public double a;
    public double base;
    public double k;

    public Logarithmic(JavmosGUI gui, String function) {
        super(gui);
        a = Double.parseDouble(function.substring(0, function.indexOf("l")));
        if ((function.substring(function.indexOf("l"), function.indexOf("("))).equals("ln")) {
            base = Math.E;
        } else {
            base = Double.parseDouble(function.substring(function.indexOf("g") + 1, function.indexOf("(")));
        }
        function = function.substring(function.indexOf("=") + 1);
        k = Double.parseDouble(function.substring(function.indexOf("(") + 1, function.indexOf("x")));
    }

    @Override
    public String getFirstDerivative() {
        if (base == Math.E) {
            return "" + a + "/x";
        }
        return "" + a + "/xln" + base;
    }

    @Override
    public String getSecondDerivative() {
        if (base == Math.E) {
            return "" + -a + "/x^2";
        }
        return "" + -a + "/x^2ln" + base;
    }

    @Override
    public double getValueAt(double x, FunctionType functionType) {
        switch (functionType) {
            case FIRST_DERIVATIVE:
                return a / (x * Math.log(base));
            case SECOND_DERIVATIVE:
                return -a / (x * x * Math.log(base));
            case THIRD_DERIVATIVE:
                return 2 * a / (x * x * x * Math.log(base));
            default:
                return a * Math.log(k * x) / Math.log(base);
        }
    }
}
