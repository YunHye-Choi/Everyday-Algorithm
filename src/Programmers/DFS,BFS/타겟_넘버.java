class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = number.length;
        
        int sum = 0;
        for(int temp:numbers) {
            sum+=temp;
        }
        
        // 1. �� ���޴µ� ���� ��� -> 0����
        if (sum < target) return 0;
        
        // 2. �� ���ؼ� ���� ��� -> 1����
        if (sum == target) return 1;
        
        // 3. �� ���ؼ� ū ��� (nCi�� �ݺ�.. i�� 0~n-1)
        for (int i = 0; i < n; i++) {
            for ()
        }
        // ù ��° ��Һ��� ������� ������
        // ������ �� ���� answer++
        // ��2 �Ͽ� ������� ������
        // ������ �� ���� answer++
        
        
        return answer;
    }
    public static combination (int n, int i) {
        
    }
}