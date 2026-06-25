import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    private int operationsBeforeTest;
    private int expectedOperationsInTest;

    @BeforeAll
    static void initAll() {
        Calculator.resetOperationCount();
        System.out.println("Запуск всех тестов Calculator");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        operationsBeforeTest = Calculator.getOperationCount();
        expectedOperationsInTest = 0;
    }

    @AfterEach
    void tearDown() {
        assertEquals(
                operationsBeforeTest + expectedOperationsInTest,
                Calculator.getOperationCount()
        );
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Все тесты Calculator завершены. Всего операций: "
                + Calculator.getOperationCount());
    }

    @Test
    @DisplayName("Сложение 2 + 3 = 5")
    void shouldAddTwoNumbers() {
        double result = calculator.add(2, 3);
        expectedOperationsInTest = 1;

        assertEquals(5.0, result, 0.001);
        assertEquals(5.0, calculator.getLastResult(), 0.001);
    }

    @Test
    @DisplayName("Деление 10 / 2 = 5")
    void shouldDivideTenByTwo() {
        double result = calculator.divide(10, 2);
        expectedOperationsInTest = 1;

        assertEquals(5.0, result, 0.001);
        assertEquals(5.0, calculator.getLastResult(), 0.001);
    }

    @Test
    @DisplayName("Деление на 0 возвращает NaN")
    void shouldReturnNaNWhenDivideByZero() {
        double result = calculator.divide(10, 0);
        expectedOperationsInTest = 1;

        assertTrue(Double.isNaN(result));
        assertTrue(Double.isNaN(calculator.getLastResult()));
    }

    @Test
    @DisplayName("Несколько операций увеличивают счетчик")
    void shouldCountSeveralOperations() {
        calculator.add(2, 3);
        calculator.subtract(10, 4);
        calculator.multiply(3, 5);
        calculator.divide(20, 2);

        expectedOperationsInTest = 4;

        assertEquals(10.0, calculator.getLastResult(), 0.001);
    }
}