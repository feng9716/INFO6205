class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> combines = new ArrayList<>();
        int left = 0,right = 0;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n,combines,sb,left,right);
        return combines;
    }
    
    public void generateParenthesis(int n, List<String> list,StringBuilder sb, int left, int right){
        // Base case, when we have the string builder that length == n*2
        // we have a well-formed parentheses
        if(sb.length() == n*2){
            list.add(sb.toString());
            return;
        }
        //if left parenthesis >= right parenthesis, we can only add a left
        if(left >= right){
            // if left < n, we can continue add left parenthesis
            if(left < n){
                sb.append("(");
                generateParenthesis(n,list,sb,left+1,right);
                sb.deleteCharAt(sb.length()-1);
            }
            // else, we can only add right parenthesis
            if(left > right){
                sb.append(")");
                generateParenthesis(n,list,sb,left,right+1);
                sb.deleteCharAt(sb.length()-1);
            }
            
        }
        
    }
}