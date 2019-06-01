package iterator;

/**
 * Created by zhivkogeorgiev on 7/15/18.
 */
public final class PowerCalculator {
    //example of singleton
    public static final PowerCalculator INSTANCE = new PowerCalculator();

    private PowerCalculator() {

    }

    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "base can't be < 0";
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
