import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    private BankAccount account;
    @BeforeAll
    static void initAll() {
        System.out.println("Запуск всех тестов BankAccount");}
    @BeforeEach
    void setUp() {
        account = new BankAccount("Иван Петров", 1000.0);
        System.out.println("Создан новый счет с балансом 1000.0");}
    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");}
    @AfterAll
    static void tearDownAll() {
        System.out.println("Все тесты BankAccount завершены");}
    @Test
    @DisplayName("Пополнение счета увеличивает баланс")
    void testDeposit() {
        double balanceBefore = account.getBalance();
        account.deposit(500.0);
        assertEquals(balanceBefore + 500.0, account.getBalance(), 0.001);}
    @Test
    @DisplayName("Снятие средств уменьшает баланс")
    void testWithdrawSuccess() {
        boolean result = account.withdraw(300.0);
        assertTrue(result);
        assertEquals(700.0, account.getBalance(), 0.001);}
    @Test
    @DisplayName("Снятие средств больше баланса невозможно")
    void testWithdrawFail() {
        boolean result = account.withdraw(1500.0);
        assertFalse(result);
        assertEquals(1000.0, account.getBalance(), 0.001);}}