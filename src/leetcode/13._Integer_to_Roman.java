class Solution {
    public String intToRoman(int num) {
        String str = num + "";
        String arr[] = str.split("");
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            int dec = str.length() - i - 1;
            char c = str.charAt(i);
            switch (c) {
                case '1'-> {
                    if (dec == 3){
                        answer += "M";
                    } else if (dec == 2) {
                        answer += "C";
                    } else if (dec == 1) {
                        answer += "X";
                    } else {
                        answer += "I";
                    }
                }
                case '2'-> {
                    if (dec == 3){
                        answer += "MM";
                    } else if (dec == 2) {
                        answer += "CC";
                    } else if (dec == 1) {
                        answer += "XX";
                    } else {
                        answer += "II";
                    }
                }
                case '3'-> {
                    if (dec == 3){
                        answer += "MMM";
                    } else if (dec == 2) {
                        answer += "CCC";
                    } else if (dec == 1) {
                        answer += "XXX";
                    } else {
                        answer += "III";
                    }
                }
                case '4'-> {
                    if (dec == 2) {
                        answer += "CD";
                    } else if (dec == 1) {
                        answer += "XL";
                    } else {
                        answer += "IV";
                    }
                }
                case '5'-> {
                    if (dec == 2) {
                        answer += "D";
                    } else if (dec == 1) {
                        answer += "L";
                    } else {
                        answer += "V";
                    }
                }
                case '6'-> {
                    if (dec == 2) {
                        answer += "DC";
                    } else if (dec == 1) {
                        answer += "LX";
                    } else {
                        answer += "VI";
                    }
                }
                case '7'-> {
                    if (dec == 2) {
                        answer += "DCC";
                    } else if (dec == 1) {
                        answer += "LXX";
                    } else {
                        answer += "VII";
                    }
                }
                case '8'-> {
                    if (dec == 2) {
                        answer += "DCCC";
                    } else if (dec == 1) {
                        answer += "LXXX";
                    } else {
                        answer += "VIII";
                    }
                }
                case '9'-> {
                    if (dec == 2) {
                        answer += "CM";
                    } else if (dec == 1) {
                        answer += "XC";
                    } else {
                        answer += "IX";
                    }
                }
            }
         
        }
        return answer;
    }
}