import java.util.Arrays;

class NumOfIslands {

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        for(char[] chars: grid1){
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("Number of Islands in grid: " + numIslands(grid1));

        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        for(char[] chars: grid2){
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("Number of Islands in grid: " + numIslands(grid2));


    }

    private static int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int numOfIslands = 0;
        int i = 0, j = 0;


        for(i = 0; i < grid.length; i++){
            for(j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1')
                    numOfIslands += 1;
                depthFirst(grid,i,j);
            }
        }
        
        return numOfIslands;
    }
    
    private static void depthFirst(char[][] grid, int i, int j){
        // Out of bounds cases
        if(i < 0 || j < 0 ) return;
        if(i >= grid.length|| j >= grid[0].length) return;
        
        // corner cases
        if(grid[i][j] == '0') return;

        
        
        grid[i][j] = '0';
        depthFirst(grid,i-1,j);
        depthFirst(grid,i+1,j);
        depthFirst(grid,i,j-1);
        depthFirst(grid,i,j+1);
    }
}