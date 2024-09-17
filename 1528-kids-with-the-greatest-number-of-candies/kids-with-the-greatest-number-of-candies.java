class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();

        for(int candy: candies) {
            maxi = Math.max(maxi, candy);
        }

        for(int candy: candies) {
            result.add(candy + extraCandies >= maxi);
        }

        return result;
    }
}