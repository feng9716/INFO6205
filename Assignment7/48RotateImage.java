class Solution {
    public void rotate(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = matrix.length;
        
        
        for(int i = 0 ; i < length; i ++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0 ; j < length;j++){
                row.add(matrix[i][j]);
            }
            map.put(i,row);
        }
        
        for(int i = 0 ; i < length;i++){
            List<Integer> row = map.get(length-1-i);
            for(int j = 0 ; j < length;j++){
                
                matrix[j][i] = row.get(j);
            }
        }
    }
}