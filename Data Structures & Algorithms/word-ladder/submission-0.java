class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        if(!wordList.contains(endWord)) {
            return 0;
        }

        // *at -> cat, bat
        Map<String, List<String>> adjacencyList = new HashMap<String, List<String>>();

        for (String word:wordList) { // n
            for(int i = 0; i<word.length(); i++) { // m O(nm)
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                
                if(!adjacencyList.containsKey(pattern)) {
                    adjacencyList.put(pattern, new ArrayList<String>());
                    adjacencyList.get(pattern).add(word);
                } else {
                    adjacencyList.get(pattern).add(word);
                }
            }
        }

        Queue<WStep> queue = new LinkedList<WStep>();
        queue.offer(new WStep(beginWord, 1));

        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            WStep current = queue.poll();
            String word = current.word;
            int length = current.length;

            for(int i = 0; i<word.length(); i++) {
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);

                if(!adjacencyList.containsKey(pattern)) {
                    continue;
                }

                List<String> neighbors = adjacencyList.get(pattern);

                for(String newWord: neighbors) {
                    if(newWord.equals(endWord)) {
                        return length+1;
                    }

                    if(!visited.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(new WStep(newWord, length+1));
                    }

                }

                adjacencyList.put(pattern, new ArrayList<String>());


            }

        }

        return 0;


    }
private static class WStep {
    String word;
    int length;

    WStep(String word, int length) {
        this.word = word;
        this.length=length;
    }

}

}




/*

cat go through the list for all words cat can transform into

key: cat
values: bat


"semi optimal"

loop through all words in the word list
generate patterns for all words in the list 



key: *at
vales: cat, bat


cat -> bat


cat -> *at, c*t, ca*
sag -> *ag, s*g, sa*


bat -> *at, b*t, ba*
bag
sag
dag
dot


*/
