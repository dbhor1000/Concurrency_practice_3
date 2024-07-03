import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ComplexTask {

    private final int taskNumber;

    public ComplexTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void execute() {
        // Пример сложной задачи: вычисление факториала числа
        BigDecimal multiplyBy = BigDecimal.valueOf(Math.random());
        BigDecimal result = BigDecimal.valueOf(factorial(taskNumber)).multiply(multiplyBy).setScale(2, RoundingMode.DOWN);
        System.out.println("Результат задачи " + taskNumber + ": " + result + " Множитель равен:" + multiplyBy);
        if(taskNumber == 7) {
            System.out.println("Lucky number 7.");
        }
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
