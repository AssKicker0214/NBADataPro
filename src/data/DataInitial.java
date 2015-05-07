package data;

import configure.Configure;
import data.input.Match;
import data.input.Player;
import data.input.Team;
import data.saver.PlayerScoreSaver;
import dataservice.Updatable;


/**
 * Created by cho on 2015/4/30.
 */
public class DataInitial {

    private static DataUpdate dataUpdate;
    private static boolean flag = false;

    private static void initialData() {
        String teamPath = Configure.getTeamPath();
        String playerPath = Configure.getPlayerPath();
        String matchPath = Configure.getMatchPath();
        Team team = new Team(teamPath);
        team.init();
        Player player = new Player(playerPath);
        player.init();
        Match match = new Match(matchPath);
        match.init();
        dataUpdate = new DataUpdate(matchPath);
        PlayerScoreSaver.getPlayerScoreSaver().update();
        dataUpdate.start();
        flag = true;
    }

    public static void setPath(String path) {
        Configure.set(path);
    }

    public static void end() {
        if (dataUpdate != null)
            dataUpdate.end();
    }

    public static void init(){
        if (flag == false){
            initialData();
        }
    }

    public static void addUpdatable(Updatable updatable){
        if (dataUpdate == null){
            init();
        }
        dataUpdate.add(updatable);
    }
}
