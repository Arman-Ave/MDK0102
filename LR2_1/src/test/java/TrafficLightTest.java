import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest {

    private TrafficLight trafficLight;
    private int changesBeforeTest;
    private int expectedChangesInTest;

    @BeforeAll
    static void initAll() {
        TrafficLight.resetTotalChanges();
        System.out.println("Запуск всех тестов TrafficLight");
    }

    @BeforeEach
    void setUp() {
        trafficLight = new TrafficLight();
        changesBeforeTest = TrafficLight.getTotalChanges();
        expectedChangesInTest = 0;
    }

    @AfterEach
    void tearDown() {
        assertEquals(
                changesBeforeTest + expectedChangesInTest,
                TrafficLight.getTotalChanges()
        );
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Все тесты TrafficLight завершены. Всего переключений: "
                + TrafficLight.getTotalChanges());
    }

    @Test
    @DisplayName("Начальный цвет светофора — RED")
    void shouldHaveRedColorAtStart() {
        assertEquals("RED", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isRed());
        assertFalse(trafficLight.isGreen());
        assertFalse(trafficLight.isYellow());
    }

    @Test
    @DisplayName("Переключение из RED в GREEN")
    void shouldChangeColorFromRedToGreen() {
        trafficLight.changeColor();
        expectedChangesInTest = 1;

        assertEquals("GREEN", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isGreen());
    }

    @Test
    @DisplayName("Переключение из GREEN в YELLOW")
    void shouldChangeColorFromGreenToYellow() {
        trafficLight.changeColor();
        trafficLight.changeColor();
        expectedChangesInTest = 2;

        assertEquals("YELLOW", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isYellow());
    }
}