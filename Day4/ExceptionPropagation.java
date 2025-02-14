//8. Exception Propagation in Methods
public class ExceptionPropagation {

    // method1: Throws ArithmeticException (10 / 0)
    public static void method1() {
        // This will throw ArithmeticException (division by zero)
        int result = 10 / 0;
    }

    // method2: Calls method1
    public static void method2() {
        method1();  // Calling method1, which throws an exception
    }

    public static void main(String[] args) {
        try {
            // Calling method2, which propagates the exception from method1
            method2();
        } catch (ArithmeticException e) {
            // Handle the exception in main
            System.out.println("Handled exception in main");
        }
    }
}
