class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();

        for(int candy: candies) {
            maxi = Math.max(maxi, candy);
        }

        for(int candy: candies) {
            if(candy + extraCandies >= maxi) result.add(true);
            else result.add(false);
        }

        return result;
    }
}