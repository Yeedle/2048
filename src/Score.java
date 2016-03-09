/**
 * Created by Modi on 2/10/2016.
 */
public class Score {

    static int recordScore;
    int currentScore;

    public static int getRecordScore() {
        return recordScore;
    }

    public static void setRecordScore(int recordScore) {
        Score.recordScore = recordScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void addToScore(int addition){
        currentScore += addition;
    }

    public Score() {
        currentScore = 0;

    }

    public Score(int currentScore) {
        this.currentScore = currentScore;
    }
    //TODO: we need to figure out what how to construct the scores.
    //TODO: For persistency and records keeping we can either serialize the whole program (so a player will be able to pickup exactly where he or she left), or we can just save the scores into a file.

}