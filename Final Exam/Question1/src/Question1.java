public class Question1 {

    public static void main(String[] args) {
	// write your code here
        char[][] body = {{'0','0','X','0'},{'X','0','X','X'},{'X','0','0','0'}};
        System.out.println(getResult(body,5));

        char[][] body2 = {{'0','X'},{'X','0'}};
        System.out.println(getResult(body2,3));
    }

    // Time Complexity O(M*N), M = row num of body, N = column num of body
    // Space Complexity O(M*N) a m*n array needs to be initialized
    private static String getResult(char[][] body, int maxTime){
        // There is no body array, infection cannot start
        if(body.length == 0) return "Cannot Infect.";

        // Only one weak cell
        if(body.length == 1 && body[0].length == 1 && body[0][0] == '0'){
            return "Can Infect";
        }
        // The left-top corner is strong cell, the infection cannot start
        if(body[0][0] == 'X') return "Cannot Infect.";

        int[][] dp = new int[body.length][body[0].length];

        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[i].length; j++){
                if(i==0 && j == 0){
                    dp[i][j] = 0;
                }

                if(body[i][j] == '0'){
                    if(i != dp.length-1 && body[i+1][j] != 'X'){
                        dp[i+1][j] +=1;
                    }
                    if(j != dp[i].length -1 && body[i][j+1] != 'X'){
                        dp[i][j+1] +=1;
                    }
                }
            }
        }

        if(dp[dp.length-1][dp[0].length-1]  <= maxTime  && dp[dp.length-1][dp[0].length-1] !=0){
            return "Can infect.";
        }
        return "Cannot infect.";
    }
}
