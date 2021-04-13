class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> x_zero = new ArrayList<>();
        List<Integer> y_zero = new ArrayList<>();
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    if(!x_zero.contains((Integer)j)){
                        x_zero.add(j);
                    }
                    if(!y_zero.contains((Integer) i )){
                        y_zero.add(i);
                    }
                }
            }
        }
        
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[i].length;j++){
                if(x_zero.contains(j) || y_zero.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}