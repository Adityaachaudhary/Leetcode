class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        boolean shouldPush = true;

        for (int i = 0; i < a.length; i++) {
            shouldPush = true;
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek > 0 && peek == a[i] * -1) {
                    stack.pop();
                    shouldPush = false;
                    break;
                } 
                else if (peek==a[i] || peek * a[i]>0 || (peek < 0 && a[i]> 0)){
                    break;
                }
                else if (Math.abs(peek) > Math.abs(a[i])) {
                    shouldPush = false;
                    break;
                } 
                else if (Math.abs(peek) < Math.abs(a[i])) {
                    stack.pop();
                }
            }

            if (shouldPush) {
                stack.push(a[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
