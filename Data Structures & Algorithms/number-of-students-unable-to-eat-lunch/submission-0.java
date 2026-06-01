class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        if(students.length == 0) {
            return 0;
        }
        if(sandwiches.length == 0) {
            return students.length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        

        for(int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        int sandwichIndex = 0;
        int swaps = 0;

        while(!queue.isEmpty() && swaps<queue.size()) {
            int currStud = queue.poll();

            if(currStud == sandwiches[sandwichIndex]){
                sandwichIndex++;
                swaps=0;
            } else {
                queue.offer(currStud);
                swaps++;
            }
        }
        return queue.size();

    }
}