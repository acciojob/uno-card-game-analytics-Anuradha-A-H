package com.driver;

import java.util.*;

public class ScoreDataRepository {
    private Map<String, List<Score>> playerScores;

    public ScoreDataRepository() {
        this.playerScores = new HashMap<>();
    }

    public void storeScore(Score score) {
    	//your code goes here
        String name = score.getPlayerName();
        if(playerScores.containsKey(name))
        {
            List<Score> scoreList = playerScores.get(name);
            scoreList.add(score);
            playerScores.put(name,scoreList);
        }else{
            List<Score> scoreList = new ArrayList<>();
            scoreList.add(score);
            playerScores.put(name,scoreList);
        }
    }

    public List<Score> getScoresByPlayer(String playerName) {
    	//your code goes here
        if(playerScores.containsKey(playerName))
        {
            List<Score> ans = playerScores.get(playerName);
             Collections.sort(ans,(s1,s2)->Integer.compare(s2.getScore(),s1.getScore()));
            return ans;
        }
        return playerScores.getOrDefault(playerName, new ArrayList<>());
    }

    public List<Score> getAllScores() {

    	//your code goes here
        List<Score> allScores= new ArrayList<>();
        for(String name : playerScores.keySet())
        {
            for(Score s : playerScores.get(name))
                allScores.add(s);
        }

        return allScores;
    }
}

