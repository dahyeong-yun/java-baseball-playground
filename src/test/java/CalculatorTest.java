import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;
    private Scanner scanner;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void closeScanner() {
        scanner.close();
    }

    @Test
    @DisplayName("사용자 입력을 저장한다.")
    void calculableInput() {
        String data = "1 + 1 + 1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calculator.input(input);

        assertThat(data.split(" ")).isEqualTo(calculator.getOrder());
    }

    @Test
    @DisplayName("잘못된 명령을 입력하면 예외가 발생한다.")
    void isValidOrder() {
        String data = "1 + 1 + 1 +";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        assertThrows(IllegalArgumentException.class, () -> calculator.input(input));
    }

    @Test
    @DisplayName("명령이 입력되어 있으면 계산을 할 수 있다.")
    void calculate() {
        String data = "1 + 1 + 1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calculator.input(input);

        assertThat(calculator.interpretOrders()).isEqualTo(3);
    }
    //TODO 명령이 입력되기 전이면 계산을 할 수 없다.
    //TODO 연산자에 알맞는 계산을 한다.(각각 4개)
}
