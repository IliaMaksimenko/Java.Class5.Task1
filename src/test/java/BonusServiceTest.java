import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test   // Нулевые значения переменных
    void shouldCalculateForUnRegisteredAndZeroAmount() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test   // Нулевые значения переменных
    void shouldCalculateForRegisteredAndZeroAmount() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test    //Минимальное целое положительное число
    void shouldCalculateForUnRegisteredAndMinimalAmount() {
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test   //Максимально допустимое значение стоимости (предел для переменных типа int)
    void shouldCalculateForUnRegisteredAndMaximumAmount() {
        BonusService service = new BonusService();

        long amount = 2147483647;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test   //Граничные значения максимально допустимого значение стоимости (предел для переменных типа int)
    void shouldCalculateForUnRegisteredAndMaximumAmountMinusOne() {
        BonusService service = new BonusService();

        long amount = 2147483646;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }


    @org.junit.jupiter.api.Test   //Отрицательное значение и самое минимальное значение типа int
    void shouldCalculateForUnRegisteredAndNegativeMeaning() {
        BonusService service = new BonusService();

        long amount = -2147483647;
        boolean registered = false;
        long expected = -21474836;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }


    @org.junit.jupiter.api.Test    //Тестируем на отказ
    void shouldCalculateForUnRegisteredAndFailureTesting() {
        BonusService service = new BonusService();

        long amount = 100000;
        boolean registered = false;
        long expected = 1000;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }
}
