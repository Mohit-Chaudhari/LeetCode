class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        Set<String> set = new HashSet<>();
        int maxD = Integer.MIN_VALUE;
        int x = 0, y = 0; // Robot standing at starting position
        int[] direction = new int[] {0 , 1}; // Robot facing north direction

        for(int[] obs: obstacles) {
            set.add(obs[0] + "_" + obs[1]);
        }

        for(int command: commands) {

            if(command == -2) {
                // turn left 90 degree
                direction = new int[] {-direction[1], direction[0]};
            } else if(command == -1) {
                // turn right 90 degree
                direction = new int[] {direction[1], -direction[0]};
            } else {
                // Visit point one by one until obstacle comes
                for(int steps = 0; steps < command; steps++) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    String nextKey = newX + "_" + newY;

                    if(set.contains(nextKey)) break;

                    x = newX;
                    y = newY;
                }
            }

            maxD = Math.max(maxD, x*x + y*y);
        }

        return maxD;
    }
}