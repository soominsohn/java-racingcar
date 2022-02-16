package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

@SuppressWarnings("NonAsciiCharacters")
public class InputTest {

    InputView input = new InputView();

    @Test
    void splitByComma_쉼표구분자_성공() {
        String[] tokens = input.splitByComma("a,b,c");
        assertThat(tokens).containsExactly("a", "b", "c");
    }

    @Test
    void splitByComma_쉼표_없음() {
        String[] tokens = input.splitByComma("abc");
        assertThat(tokens).containsExactly("abc");
    }

}