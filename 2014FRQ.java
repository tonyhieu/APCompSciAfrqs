public class 2014FRQ {
    //1a
    private String recombine (String word1, String word2) {
        return word1.substring(0, word1.length())/2 + word2.substring(word2.length()/2, word2.length());
    }
    //1b
    private String[] mixedWords (String[] words) {
        for (int i = 0; i < words.length; i += 2) {
            String w1 = recombine(words[i], words[i+1]);
            String w2 = recombine(words[i+1], words[i]);
            words[i] = w1;
            words[i+1] = w2;
        }
        return words;
    }

    //2a
    public static int getPeakIndex (int[] array) {
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] > array[i-1] && array[i] > array[i+1])
                return i;
        }
        return -1;
    }
    //2b
    public static boolean isMountain (int[] array) {
        int peak = getPeakIndex(array);
        if (peak != -1) 
            return isIncreasing(array, peak) && isDecreasing(array, peak);
        return false;
    }
    //3a
    private double computeTemp (int row, int col) {
        if (row == 0 || row == temps.length - 1 || col == 0 || col == temps[0].length - 1) 
            return temp[row][col];
        return ( (temp[row-1][col] + temp[row+1][col] + temp[row][col-1] + temp[row][col+1])/4 );
    }
    //3b
    public boolean updateAllTemps (double tolerance) {
        boolean t = true;
        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[0].length; j++) {
                if (Math.abs(temps[i][j] - computeTemp(i, j)) > tolerance) 
                    t = false;
                temps[i][j] = computeTemp(i, j);
            }
        }
        return t;
    }
    //4a
    public boolean record (int score) {
        int index = -1;
        for (int i = 0; i < scoreList.size(); i++) {
            if (score == scoreList.get(i).getScore()) {
                scoreList.get(i).increment();
            } else if (i != scoreList.size() - 1) {
                if (scoreList.get(i).getScore() < score && score < scoreList.get(i+1)) {
                    index = i;
                }
            } else {
                index = scoreList.size() - 1
            }
        }
        if (index != -1) {
            scoreList.add(index,  new ScoreInfo(score, 1));
            return true;
        }
        return false;
    }
    //4b
    public void recordScores (int[] stuScores) {
        boolean b;
        for (int score : stuScores) 
            b = record(score);
    }
}
