package data;

import data.input.Match;
import data.input.Player;
import data.input.Team;


/**
 * Created by cho on 2015/4/30.
 */
public class DataInitial {
    private String teamPath;
    private String playerPath;
    private String matchPath;
    private DataUpdate dataUpdate;

    public void init(){
        Team team = new Team(teamPath);
        team.init();
        Player player = new Player(playerPath);
        player.init();
        Match match = new Match(matchPath);
        match.init();
        dataUpdate = new DataUpdate(matchPath);
        dataUpdate.start();
    }

    public void end(){
        dataUpdate.end();
    }
}
