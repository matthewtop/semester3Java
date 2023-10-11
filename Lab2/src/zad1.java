public class zad1 {
    public static void main(String[] args) throws Exception {
       Calculator calculator = new Calculator();
       ScientificCalculator scCalculator = new ScientificCalculator();
        System.out.println(scCalculator.sumTo(5));
        System.out.println(scCalculator.add(4,5));
        System.out.println(scCalculator.subtract(20,4));
    }
}
class ScientificCalculator {
    private Calculator calc;
    ScientificCalculator ( ) {
        calc = new Calculator();
    }
    public int factorial(int b) throws Exception {
        if(b<0) throw new Exception("Factorial not applicable for negatives");
        if(b==0) return 1;
        return b * factorial(b-1);
    }
    public int sumTo(int b) throws Exception {
        if(b<0) throw new Exception("Sum To not applicable for negatives");
        if(b==0) return 0;
        return calc.add(b, sumTo(b-1));
    }
    public int add(int a, int b) {
        return calc.add(a, b);
    }
    public int subtract(int a, int b) {
        return calc.subtract(a, b);
    }
//    public int getVersion() {
//        return calc.version;
//    }

}
class Calculator {
    private int version = 3;
    int add(int a, int b) {
        return a+b;
    }
    public int subtract(int a, int b) {
        return a-b;
    }
    private int multiply(int a, int b) {
        return a * b;
    }
}

