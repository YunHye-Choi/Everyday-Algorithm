class Solution {
    public int reverse(int x) {
        
        System.out.println("??");
        String str = String.valueOf(x);
        boolean isNeg = false;
        if (str.startsWith("-")) {
            str = str.substring(1, str.length());
            isNeg = true;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        int y = isNeg ? ((-1) * (int)(Long.parseLong(sb.toString()))) : (int)Long.parseLong(sb.toString());

        if (y < (-1)*(Math.pow(2, 31)) && y > Math.pow(2, 31)-1) return 0;
        return y;
    }
}