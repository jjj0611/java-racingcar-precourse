package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int DEFAULT_POSITION = 0;

    private List<Car> cars;

    public Cars(List<String> names) {
        cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void runOneTime(Random random) {
        for (Car car : cars) {
            car.proceedOrStop(generateRandomNumber(random));
        }
    }

    private int generateRandomNumber(Random random) {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void showCarsStatus() {
        for (Car car : cars) {
            System.out.println(car.currentStatus());
        }
    }

    public int measureFirstPosition() {
        int first = DEFAULT_POSITION;
        for (Car car : cars) {
            if (car.getPosition() > first) {
                first = car.getPosition();
            }
        }
        return first;
    }

    public List<Car> takeCarsInFirstPosition(int position) {
        List<Car> carsInFirstPosition = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(position)) {
                carsInFirstPosition.add(car);
            }
        }
        return carsInFirstPosition;
    }

}
