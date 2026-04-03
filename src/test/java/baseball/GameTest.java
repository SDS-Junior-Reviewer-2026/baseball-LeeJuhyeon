package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("입력값이 이상한 경우")
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12S");
        assertIllegalArgument("121");
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    @DisplayName("숫자_세개가_전부_일치_할_경우_3_strike")
    public void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    @DisplayName("숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball")
    public void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    private void generateQuestion(String guessNumber) {
        game.question = guessNumber;
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strike, int balls) {
        assertNotNull(result);
        assertEquals(solved, result.isSolved());
        assertEquals(strike, result.getStrikes());
        assertEquals(balls, result.getBalls());
    }

    @Test
    public void 스트라이크만_있을_경우_1_strike_0_ball() {

    }

    @Test
    public void 볼만_있을_경우_0_strike_1_ball() {

    }

    @Test
    public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

    }
}
