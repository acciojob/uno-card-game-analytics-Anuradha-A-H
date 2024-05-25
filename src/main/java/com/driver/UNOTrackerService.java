package com.driver;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UNOTrackerService {
    private ScoreDataRepository scoreDataRepository;

    public UNOTrackerService(ScoreDataRepository scoreDataRepository) {
        this.scoreDataRepository = scoreDataRepository;
    }

    public void storeScoreData(ScoreDTO scoreDTO) {
    	//your code goes here
        Score sc = new Score(scoreDTO.getPlayerName(),scoreDTO.getScore());
        scoreDataRepository.storeScore(sc);

    }

    public double calculateAverageScore(String playerName) {
    	//your code goes here
        List<Score> scoreList = scoreDataRepository.getScoresByPlayer(playerName);
        double total = scoreList.size();
        double sum = 0.0;
        for(Score s : scoreList)
        {
            sum += s.getScore();
        }
        return sum/total;
    }

    public String identifyTopPlayer() {
    	//your code goes here
        List<Score> allScores = scoreDataRepository.getAllScores();
        String name = "";
         double  avg = 0.0;
        for(Score s : allScores)
        {
            double temp = calculateAverageScore(s.getPlayerName());
            if(temp>avg)
            {
                avg = temp;
                name = s.getPlayerName();
            }
        }
        return name;
    }
}
