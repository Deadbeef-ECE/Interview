//start from 0
//opeation1: +1
//operation2: *3
//reach target with minimum operations

public class NumberDp {
	public static int calDP(int target){
		if(target == 0)	return 0;
		if(target == 1)	return 1;
		if(target == 2) return 2;
		if(target == 3)	return 2;
		int[] dp = new int[target+1];
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 2;
		for(int i = 4; i <= target; i++){
			int firstBlood = Math.min(Math.min(dp[i-1]+1, dp[i-2]+2), dp[i-3]+3);
			int doubleKill = Integer.MAX_VALUE;
			int tripleKill = Integer.MAX_VALUE;
			if((i / 3 % 1) == 0 && i % 3 == 0){
				int temp = i/3;
				doubleKill = Math.min(firstBlood, dp[temp] + 1);
			}
			if(logOfBase(3, i) % 1 == 0){
//				System.out.println("wtf " + i + " "+ logOfBase(3, i));
				tripleKill = Math.min(doubleKill, dp[1] + (int)logOfBase(3, i));
			}
			dp[i] = Math.min(Math.min(firstBlood, doubleKill), tripleKill);
			System.out.println("i: "+i + ", dp[" + i + "] " + dp[i]);

		}
		return dp[target];

	}
	
	public static double logOfBase(int base, int num) {
	    return Math.log(num) / Math.log(base);
	}
	
	public static void main(String[] args){
		int target = 27;
		printRet("The min step to get target is: ", target);
	}
	
	public static void printRet(String str, int target){
		System.out.println("target is " + target);
		System.out.println(str);
		System.out.println(calDP(target));
	}
}
