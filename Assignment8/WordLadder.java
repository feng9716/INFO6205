import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution  = new Solution();

        // Answer = 5;
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        for(String s: list){
            wordList.add(s);
        }
        System.out.println("\"hit\" -> \"hot\" -> \"dot\" -> \"dog\" -> \"cog\"");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
        System.out.println();
        // Answer = 0;
        /** 
        String[] list2 = {"hot","dot","dog","lot","log"};
        List<String> wordList2 = new ArrayList<>();
        for(String s: list2){
            wordList2.add(s);
        }
        System.out.println("There is no valid path from beginWord to endWord");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList2));
        System.out.println();
        **/
        String endWord2 = "coc";
        String[] list2 = {"hot","dot","dog","lot","log","cog","coc"};
        List<String> wordList2 = new ArrayList<>();
        for(String s: list2){
            wordList2.add(s);
        }
        System.out.println("\"hit\" -> \"hot\" -> \"dot\" -> \"dog\" -> \"cog\"");
        System.out.println(solution.ladderLength(beginWord, endWord2, wordList2));
        System.out.println();

    }

    private static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    
            
            int step = 1;
            Queue<String> queue = new LinkedList<>();
            
            queue.offer(beginWord);
            queue.offer(null);
            
            while(!queue.isEmpty()){
                // pull the first one from the queue
                String cur = queue.poll();
                // If cur is not null,
                // Search all string that is one letter differerent from cur
                if(cur != null){
                    // Find all strings one letter different
                    List<String> neighbors = findNeighbor(wordList, cur);
                    
                    // Iterate all neighbors, add them to queue
                    // also remove them from wordList
                    for(String s: neighbors){
                        if(s.equals(endWord)){
                            return step + 1;
                        }
                        queue.offer(s);
                        wordList.remove(s);
                    }
                }
                // If the cur is null, we search all current layer of strings
                else{
                    step++;
                    if(queue.isEmpty()) break;
                    queue.offer(null);
                }
            }
            
            // If we do not find endWord, return 0;
            return 0;
        }
        
    
        public List<String> findNeighbor(List<String> list, String cur){
            List<String> res = new ArrayList<>();
            for(String s: list){
                if(isNeighbor(s,cur)){
                    res.add(s);
                }
            }
            return res;
        }
        
        public boolean isNeighbor(String s, String target){
            if(target == null) return false;
            int count = 0;
            for(int i = 0; i < target.length(); i++){
                if(s.charAt(i) != target.charAt(i)){
                    if(count == 0){
                        count ++;
                    }
                    else{
                        return false;
                    }
                }
                
            }
            return count == 1;
            
        }
        
    }
}
