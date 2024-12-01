class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxcandies = 0;
        for(int candy : candies){
            maxcandies = Math.max(maxcandies, candy);
        }

        for(int candy : candies){
            if(candy + extraCandies >= maxcandies){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}