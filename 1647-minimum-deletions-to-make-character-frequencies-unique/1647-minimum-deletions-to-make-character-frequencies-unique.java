class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> usedFreqs = new HashSet<>();
        int deletions = 0;

        for (int count : freq) {
            while (count > 0 && usedFreqs.contains(count)) {
                count--;
                deletions++;
            }
            //If it's still greater than 0, save it
            if (count > 0) {
                usedFreqs.add(count);
            }
        }

        return deletions;
    }
}