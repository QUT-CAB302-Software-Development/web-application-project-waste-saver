package example.data;

public enum Ranks {
    RANK_ONE(   10,   "Budding Saver",      "reward description for this level"),
    RANK_TWO(   20,   "Rookie Saver",       "reward description for this level"),
    RANK_THREE( 50,   "Novice Saver",       "reward description for this level"),
    RANK_FOUR(  100,  "Apprentice Saver",   "reward description for this level"),
    RANK_FIVE(  200,  "Veteran Saver",      "reward description for this level"),
    RANK_SIX(   500,  "Master Saver",       "reward description for this level"),
    RANK_SEVEN( 1000, "Grandmaster Saver",  "reward description for this level");


    private int pointsScore;
    private String rankTitle;
    private String rewardDescription;


    private Ranks(int pointsScore, String rankTitle, String rewardDescription){
        this.pointsScore = pointsScore;
        this.rankTitle = rankTitle;
        this.rewardDescription = rewardDescription;
    }

    public int getPointsScore(){
        return pointsScore;
    }

    public String getRankTitle(){
        return rankTitle;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public String progressString(int points){
        if (points >= pointsScore){
            return "Rank Achieved \u2705"; //Maybe \u2714
        }
        else {
            return String.format("%,d points remaining", (pointsScore - points));
        }
    }

    public boolean achieved(int points){
        return (points >= pointsScore);
    }
}
