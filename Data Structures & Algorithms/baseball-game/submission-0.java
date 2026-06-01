class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> score = new ArrayList<Integer>();
        for (int i = 0; i <operations.length; i++) {
            switch(operations[i]) {
                case "+":
                    if(score.size() >1) {
                        score.add(score.get(score.size()-1)+score.get(score.size()-2));
                    }
                    else {
                        score.add(score.get(score.size()-1));
                    }
                    break;
                case "D":
                    score.add(score.get(score.size()-1)*2);
                    break;
                case "C":
                    score.remove(score.size()-1);
                    break;
                default:
                    score.add(Integer.parseInt(operations[i]));
                    break;
            }
        }
        int finalScore = 0;
        for(int k : score) {
            finalScore+=k;
        }
        return finalScore;
    }
}