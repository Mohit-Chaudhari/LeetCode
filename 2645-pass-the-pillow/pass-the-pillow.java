class Solution {
    public int passThePillow(int n, int time) {
        /*
            Input: n = 4, time = 5
            Output: 2
            Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
            After five seconds, the 2nd person is holding the pillow.

            Input: n = 4, time = 12
            1 > 2 > 3 > 4 > 3 > 2 > 1 > 2 > 3 > 4 > 3 > 2 > 1

            Input: n = 4, time = 10
            1 > 2 > 3 > 4 > 3 > 2 > 1 > 2 > 3 > 4 > 3

            Input: n = 9, time = 4
            1 > 2 > 3 > 4 > 5
        **/

        int chunks = time / (n - 1);
        return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
}