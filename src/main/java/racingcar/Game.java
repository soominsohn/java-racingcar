package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private final Input input = new Input();
    private final Output output = new Output();

    private static final int RANDOM_RANGE = 10;

    public void start() {
        String[] names = inputCarNames();
        List<Car> cars = generateCar(names);
        int coin = inputCoin();
        race(coin, cars);
        List<String> winners = getWinner(cars);
        output.printWinner(winners);
    }

    private void race(int coin, List<Car> cars) {
        output.printResultMessage();
        for (int index = 0; index < coin; index++) {
            moveCar(cars);
            output.printPosition(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.movePosition(makeRandom());
        }
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    private List<Car> generateCar(String[] names) {
        List<Car> cars = new ArrayList<>();
        checkDuplicate(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void checkDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NAME_ERROR);
        }
    }

    private List<String> getWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = findWinnerByPosition(maxPosition, cars);
        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        return cars.stream()
            .max(comparatorByPosition).get().getPosition();
    }

    private List<String> findWinnerByPosition(int maxPosition, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private String[] inputCarNames() {
        output.inputCarNameMessage();
        return input.getNames();
    }

    private int inputCoin() {
        output.inputCoinMessage();
        return input.getCoin();
    }
}
