import java.util.*;
public class CourseSchedule {
    
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
 
        int[][] prerequisites2 = {{1,0},{0,1}};

        // System.out.println(canFinish(numCourses, prerequisites));
        System.out.println(canFinish(numCourses, prerequisites2));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //Edge case: when there is no prerequisites, always can finish
                if(prerequisites.length == 0){
                    return true;
                }
        
                //Record the prerequisites of courses in 2d matrix
                int[][] map = new int[numCourses][numCourses];
                // Record the degree of courses
                int[] degree = new int[numCourses];
        
                for(int i = 0 ; i < prerequisites.length; i++){
                    int course = prerequisites[i][0];
                    int pre = prerequisites[i][1];
        
                    // Add 1 degree to course that has prerequistes
                    if (map[pre][course] == 0)
                        degree[course]++; //duplicate case
                    // record course relationship
                    map[pre][course] = 1;
                }
        
                // Record the number of courses that have been taken
                int courseTake = 0;
                //Use queue to perform  BFS
                Queue<Integer> queue = new LinkedList<>();
                
                for(int i = 0 ; i < degree.length;i++){
                    if(degree[i] == 0){
                        queue.offer(i);
                    }
                }
        
                while(!queue.isEmpty()){
                    int cur= queue.poll();
                    courseTake += 1;
        
                    for(int i = 0 ; i < numCourses ; i++){
                        // We find the course that have cur as prerequisites
                        int target = map[cur][i];
                        //if this course still has prerequisites
                        if(target != 0){
                            // We minus 1 from number of prerequisites.
                            degree[i] -= 1;
        
                            //If the course has no prerequisites now, we add it to queue
                            // We will find the courses to take after taking this course;
                            if(degree[i] ==0){
                                queue.offer(i);
                        }
                    }
                }
            }
        return courseTake == numCourses; 
    }
}
