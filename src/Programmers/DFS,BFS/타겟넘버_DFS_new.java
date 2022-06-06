// 풀이 참고: https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4
// 내가 조금 더 개선함!
class Solution {
    public int dfs(int prev, int index, int[] numbers, int target) {
        if(index == numbers.length){
            if (prev == target) return 1;
            else return 0;
        }
        int ans = 0;
        ans += dfs (prev + numbers[index], index + 1, numbers, target);
        ans += dfs(prev - numbers[index], index + 1, numbers, target);
        return ans;
    }
    public int solution(int[] numbers, int target) {
        int answer = dfs (0, 0, numbers, target);
        return answer;
    }
}