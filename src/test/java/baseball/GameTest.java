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

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
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


    @Test
    @DisplayName("숫자_세개가_전부_일치_할_경우_3_strike")
    public void returnSolvedResultIfMatchedNumber  () {
        game.question = "123";
        GuessResult result = game.guess("123");

        assertNotNull(result);
        assertEquals(true, result.isSolved());
        assertEquals(3, result.getStrikes());
        assertEquals(0, result.getBalls());

    }

    @Test
    @DisplayName("숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball")
    public void returnSolvedResultIfUnMatchedNumber() {
        game.question = "123";
        GuessResult result = game.guess("456");

        assertNotNull(result);
        assertEquals(false, result.isSolved());
        assertEquals(0, result.getStrikes());
        assertEquals(0, result.getBalls());
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
