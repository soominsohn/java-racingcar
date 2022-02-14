package racingcar;

import java.util.List;

public class Output {

    private static final String POSITION_FLAG = "-";
    private static final String JOIN_REGEX = ", ";

    public void inputCarNameMessage() {
        System.out.println(Constant.PRINT_INPUT_CAR_NAME_MESSAGE);
    }

    public void inputCoinMessage() {
        System.out.println(Constant.PRINT_INPUT_COIN_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(Constant.PRINT_RESULT_MESSAGE);
    }

    public void printPosition(List<Car> cars) {
        for (Car car : cars) {
            String position = makePositionString(car.getPosition());
            System.out.printf("%-5s : %s\n", car.getName(), position);
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        System.out.print(String.join(JOIN_REGEX, winnerNames));
        System.out.println(Constant.PRINT_WINNER_MESSAGE);
    }

    private String makePositionString(int position) {
        String positionFlag = POSITION_FLAG;
        return positionFlag.repeat(position);
    }


}