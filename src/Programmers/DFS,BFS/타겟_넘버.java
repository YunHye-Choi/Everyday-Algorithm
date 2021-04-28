class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = number.length;
        
        int sum = 0;
        for(int temp:numbers) {
            sum+=temp;
        }
        
        // 1. 다 더햇는데 작은 경우 -> 0리턴
        if (sum < target) return 0;
        
        // 2. 다 더해서 같은 경우 -> 1리턴
        if (sum == target) return 1;
        
        // 3. 다 더해서 큰 경우 (nCi번 반복.. i는 0~n-1)
        for (int i = 0; i < n; i++) {
            for ()
        }
        // 첫 번째 요소부터 순서대로 빼보기
        // 같아질 때 마다 answer++
        // 택2 하여 순서대로 빼보기
        // 같아질 때 마다 answer++
        
        
        return answer;
    }
    public static combination (int n, int i) {
        
    }
}