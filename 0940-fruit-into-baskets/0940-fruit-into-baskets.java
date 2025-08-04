class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            // Add the current fruit to the window
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            
            // Shrink window if more than 2 fruit types
            while (map.size() > 2) {
                // Decrease count of the fruit at the left pointer
                int count = map.get(fruits[left]);
                if (count == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count - 1);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, i - left + 1);
        }
        
        return maxFruits;
    }
}