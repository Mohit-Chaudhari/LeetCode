class Car {
    int position;
    double timeToTarget;

    public Car(int position, double timeToTarget) {
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int counter = 0;
        int n = speed.length;
        Car cars[] = new Car[n];

        // Create cars object array
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (target - position[i] * 1.0) / speed[i]);
        }

        // Sort array as per positions
        Arrays.sort(cars, new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return a.position - b.position;
            }
        });

        // Check if time to travel of i th position car is <= i - 1 th position
        for (int i = n - 1; i >= 1; i--) {
            if (cars[i].timeToTarget >= cars[i - 1].timeToTarget) cars[i - 1] = cars[i];
            else counter++;
        }

        return counter + 1;
    }
}