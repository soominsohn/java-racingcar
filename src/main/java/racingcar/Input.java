package racingcar;

import java.io.IOError;
import java.util.Scanner;

public class Input {
    private Scanner scanner;
    private InputValidator inputValidator;

    // Validator
    public Input() {
        scanner = new Scanner(System.in);
        inputValidator = new InputValidator();
    }

    public String[] getNames() {
        String[] names = splitByComma(scanner.nextLine());
        inputValidator.isValidLength(names);
        inputValidator.isDuplicate(names);
        return names;
    }

    public String[] splitByComma(String input) {
        inputValidator.isValidPattern(input);
        return input.split(",");
    }

    public int getCoin() {
        String input = scanner.nextLine();
        inputValidator.isNumeric(input);
        int coin = Integer.parseInt(input);
        inputValidator.isNaturalNumber(coin);
        return coin;
    }

}
