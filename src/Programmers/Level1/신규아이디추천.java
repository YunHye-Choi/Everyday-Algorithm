// 정규식 사용!!!!
// https://minhamina.tistory.com/121
class Solution {
    public String solution(String new_id) {
        // 정규식 이용!!
        String id = new_id.toLowerCase();
        id = id.replaceAll("[^-_.a-z0-9]", "");
        id = id.replaceAll("[.]{2,}", ".");
        id = id.replaceAll("^[.]|[.]$", "");
        
        if (id.equals("")){
            id = "a";
        }
        
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", "");
        }
        while(id.length() < 3){
            id += id.charAt(id.length()-1);
        } 
        
        return id;
    }
}