class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (digits.isEmpty()) return list;
        char c = digits.charAt(0);
        if (c == '2') {
            q.add(new Node(0, "a"));
            q.add(new Node(0, "b"));
            q.add(new Node(0, "c"));
        }
        if (c == '3') {
            q.add(new Node(0, "d"));
            q.add(new Node(0, "e"));
            q.add(new Node(0, "f"));
        }
        if (c == '4') {
            q.add(new Node(0, "g"));
            q.add(new Node(0, "h"));
            q.add(new Node(0, "i"));
        }
        if (c == '5') {
            q.add(new Node(0, "j"));
            q.add(new Node(0, "k"));
            q.add(new Node(0, "l"));
        }
        if (c == '6') {
            q.add(new Node(0, "m"));
            q.add(new Node(0, "n"));
            q.add(new Node(0, "o"));
        }
        if (c == '7') {
            q.add(new Node(0, "p"));
            q.add(new Node(0, "q"));
            q.add(new Node(0, "r"));
            q.add(new Node(0, "s"));
        }
        if (c == '8') {
            q.add(new Node(0, "t"));
            q.add(new Node(0, "u"));
            q.add(new Node(0, "v"));
        }
        if (c == '9') {
            q.add(new Node(0, "w"));
            q.add(new Node(0, "x"));
            q.add(new Node(0, "y"));
            q.add(new Node(0, "z"));
        }
        while(digits.length() > 1 && !q.isEmpty()) {
            Node n = q.poll();
            
            int nextDepth = n.depth + 1;
            if (nextDepth == digits.length()) break;

            c = digits.charAt(nextDepth);
            String str = n.str;
            System.out.println(str);
            if (c == '2') {
                q.add(new Node(nextDepth, str + "a"));
                q.add(new Node(nextDepth, str + "b"));
                q.add(new Node(nextDepth, str + "c"));
            }
            if (c == '3') {
                q.add(new Node(nextDepth, str + "d"));
                q.add(new Node(nextDepth, str + "e"));
                q.add(new Node(nextDepth, str + "f"));
            }
            if (c == '4') {
                q.add(new Node(nextDepth, str + "g"));
                q.add(new Node(nextDepth, str + "h"));
                q.add(new Node(nextDepth, str + "i"));
            }
            if (c == '5') {
                q.add(new Node(nextDepth, str + "j"));
                q.add(new Node(nextDepth, str + "k"));
                q.add(new Node(nextDepth, str + "l"));
            }
            if (c == '6') {
                q.add(new Node(nextDepth, str + "m"));
                q.add(new Node(nextDepth, str + "n"));
                q.add(new Node(nextDepth, str + "o"));
            }
            if (c == '7') {
                q.add(new Node(nextDepth, str + "p"));
                q.add(new Node(nextDepth, str + "q"));
                q.add(new Node(nextDepth, str + "r"));
                q.add(new Node(nextDepth, str + "s"));
            }
            if (c == '8') {
                q.add(new Node(nextDepth, str + "t"));
                q.add(new Node(nextDepth, str + "u"));
                q.add(new Node(nextDepth, str + "v"));
            }
            if (c == '9') {
                q.add(new Node(nextDepth, str + "w"));
                q.add(new Node(nextDepth, str + "x"));
                q.add(new Node(nextDepth, str + "y"));
                q.add(new Node(nextDepth, str + "z"));
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll().str);
        }
        return list;
    }
    static class Node {
        int depth;
        String str;

        Node(int depth, String str) {
            this.depth = depth;
            this.str = str;
        }
    }
}