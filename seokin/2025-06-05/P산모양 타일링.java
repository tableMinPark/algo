class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n+1][2];
		
		
		// 0 일때 삼각형, 1일때는 마름모로 들어옴
		dp[0][0] = 0;
		if(tops[0]==1) {
			dp[1][0] = 3;
			dp[1][1] = 1;
		}
		if(tops[0]==0) {
			dp[1][0] = 2;
			dp[1][1] = 1;
		}
		
		
		for(int i=2;i<=n;i++) {
			// 위에 뚜껑 있을때
			if(tops[i-1]==1) {
				// 뒤에 삼각형
				dp[i][0] = (dp[i-1][0] * 3 + dp[i-1][1] * 2)%10007;
				// 뒤에 마름모
				dp[i][1] = (dp[i-1][0] + dp[i-1][1])%10007;
			}
			// 위에 뚜껑 없을때
			else {
				dp[i][0] = (dp[i-1][0] * 2 + dp[i-1][1])%10007;
				dp[i][1] = (dp[i-1][0] + dp[i-1][1])%10007;
			}
		}
		int answer = (dp[n][0] + dp[n][1])%10007;
        return answer;
    }
}