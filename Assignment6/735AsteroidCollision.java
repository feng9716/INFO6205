class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<Integer>();
        int length = asteroids.length;

        for(int i = 0 ; i < length;i++){
            int comer = asteroids[i];
            if(stack.isEmpty()) stack.push(comer);
            else{
                int taker = stack.peek();

                // The situation that comer and taker will collide
                while(!stack.isEmpty() && Math.abs(comer) > Math.abs(stack.peek()) && stack.peek() > 0 && comer < 0 ){
                    stack.pop();
                }
                //If the stack is empty after collide, we directly push the asteroid
                if(stack.isEmpty()){
                    stack.push(comer);
                }
                // Else, we check whther to destory both, leave the taker, or two will not collide
                else{
                    if(Math.abs(comer) == Math.abs(stack.peek()) && stack.peek() > 0 && comer < 0){
                        stack.pop();
                    }
                    else if(Math.abs(comer) < Math.abs(stack.peek()) && stack.peek() > 0 && comer < 0){
                        // Do nothing, the taker will not be broken
                    }
                    else{
                        //Two asteroids will not collide
                        stack.push(comer);
                    }
                }
            }
        }
        
        //Transfer from stack to array
        int[] res = new int[stack.size()];
        for(int i = res.length -1 ; i >=0 ;i--){
            res[i] = stack.pop();
        }
        
        return res;
    }
}