import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    private Main sut;

    @BeforeEach
    public void init() {
        System.out.println(" test started");
        sut = new Main();

    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach

    public void finished() {
        System.out.println("test completed");
        sut = null;

    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testTaxEarningsMinusSpendings() {
        int earnings = 100, spending = 50, expected = 7;

        int result = sut.taxEarningsMinusSpendings(earnings, spending);

        assertEquals(expected, result);
    }

    @Test
    public void testTaxEarnings() {

        int earnings = 100, expected = 6;

        int result = sut.taxEarnings(earnings);

        assertEquals(expected, result);
    }

    @Test
    public void testTaxEarningsMinusSpendings2() {
        int earnings = 50, spending = 1000, expected = 0;
        int result = sut.taxEarningsMinusSpendings(earnings, spending);
        assertEquals(expected, result);
    }
}
