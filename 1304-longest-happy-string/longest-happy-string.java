class Solution {
    // MAX HEAP
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    private void push(char chr, int count) {
        if(count > 0) {
            q.offer(new int[] {count, chr});
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        push('a', a);
        push('b', b);
        push('c', c);

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currCount = curr[0];
            char currCharacter = (char) curr[1];

            if(
                str.length() >= 2 &&
                str.charAt(str.length() - 1) == str.charAt(str.length() - 2) &&
                str.charAt(str.length() - 1) == currCharacter
            ) {
                if(q.isEmpty()) break;

                int[] next = q.poll();
                int nextCount = next[0];
                char nextCharacter = (char) next[1];

                str.append(nextCharacter);
                nextCount--;
                push(nextCharacter, nextCount);
                push(currCharacter, currCount);
            } else {
                str.append(currCharacter);
                currCount--;
                push(currCharacter, currCount);
            }
        }
        return str.toString();
    }
}