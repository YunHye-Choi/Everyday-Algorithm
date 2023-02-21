class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c + "");
            if (c == '{' || c == '(' || c == '[' ) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    ans = false;
                    break;
                }
                char cStack = stack.peek();
                switch (cStack) {
                    case '{' -> {
                        if (c != '}') {
                            ans = false;
                            break;
                        }
                    }
                    case '(' -> {
                        if (c != ')') {
                            ans = false;
                            break;
                        }
                    }
                    case '[' -> {
                        if (c != ']') {
                            ans = false;
                            break;
                        }
                    }
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return ans;
    }
}