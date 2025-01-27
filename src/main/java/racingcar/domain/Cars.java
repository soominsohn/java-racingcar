package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.ErrorMassage;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        checkDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return findWinnerByPosition(findMaxPosition());
    }

    public void move() {

        for (Car car : cars) {
            car.movePosition();
        }

    }

    private int findMaxPosition() {

        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        return cars.stream()
            .max(comparatorByPosition).get().getPosition();

    }

    private List<String> findWinnerByPosition(int maxPosition) {

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());

    }

    private void checkDuplicate(List<Car> cars) {

        Set<String> uniqueNames = cars.stream()
            .map(Car::getName)
            .collect(Collectors.toSet());

        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(ErrorMassage.DUPLICATE_NAME_ERROR);
        }

    }

}
