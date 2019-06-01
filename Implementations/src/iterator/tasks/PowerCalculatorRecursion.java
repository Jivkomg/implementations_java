package iterator.tasks;


/**
 * Created by zhivkogeorgiev on 7/15/18.
 */
public final class PowerCalculatorRecursion {
    //example of singleton
    public static final PowerCalculatorRecursion INSTANCE = new PowerCalculatorRecursion();
    private int result = 1;
    private PowerCalculatorRecursion() {

    }


    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "base can't be < 0";
        result *= base;
        exponent--;
        if(exponent != 0){
            calculate(base, exponent);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE.calculate(3,2));
    }
}

