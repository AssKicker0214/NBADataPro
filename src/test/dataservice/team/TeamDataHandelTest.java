package test.dataservice.team;

import data.DataInitial;
import data.input.Team;
import data.saver.PlayerScoreSaver;
import dataservice.team.TeamDataHandel;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import vo.playervo.PlayerVO;
import vo.teamvo.TeamVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * TeamDataHandel Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 5, 2015</pre>
 */
public class TeamDataHandelTest {
    public TeamDataHandelTest() {

    }

    @Before
    public void before() throws Exception {
        DataInitial.init();
//        PlayerScoreSaver.getPlayerScoreSaver().getPlayerDataDefault().showPidTid();
    }

    @After
    public void after() throws Exception {
        DataInitial.end();
    }

    /**
     * Method: hotTeams(int num, String sortBy)
     */
    @Test
    public void testHotTeams() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findTeamInfo(int teamId)
     */
    @Test
    public void testFindTeamInfoTeamId() throws Exception {
        TeamVO teamVO = new TeamDataHandel().findTeamInfo(5);
        PlayerScoreSaver.getPlayerScoreSaver().getPlayerDataDefault().showPidTid();
        if (teamVO.teamName.equals("Bulls")) {
            System.out.println("-------------find--------Bulls");
            assertEquals(teamVO.avgAssist, 22.5732, 0.0001);
            assertEquals(teamVO.penalty, 0.7789, 0.0001);
            assertEquals(teamVO.offendRound, 7447.135191, 0.0001);
            assertEquals(24.8552, teamVO.assistEfficient, 0.0001);
            assertEquals(0.3490, teamVO.three, 0.0001);
            assertEquals(0.4323, teamVO.shot, 0.0001);
            assertEquals(102.6435, teamVO.offendEfficient, 0.0001);
            assertEquals(99.9353, teamVO.defendEfficient, 0.0001);
            assertEquals(0.5854, teamVO.winRate, 0.0001);
            assertEquals(7.8967, teamVO.stealEfficient, 0.0001);
        }
    }

    /**
     * Method: findTeamInfo(String teamName)
     */
    @Test
    public void testFindTeamInfoTeamName() throws Exception {
        TeamVO teamVO = new TeamDataHandel().findTeamInfo("Bulls");
        assertEquals(teamVO.avgAssist, 22.5732, 0.0001);
        assertEquals(teamVO.penalty, 0.7789, 0.0001);
        assertEquals(teamVO.offendRound, 7447.135191, 0.0001);
        assertEquals(24.8552, teamVO.assistEfficient, 0.0001);
        assertEquals(0.3490, teamVO.three, 0.0001);
        assertEquals(0.4323, teamVO.shot, 0.0001);
        assertEquals(102.6435, teamVO.offendEfficient, 0.0001);
        assertEquals(99.9353, teamVO.defendEfficient, 0.0001);
        assertEquals(0.5854, teamVO.winRate, 0.0001);
        assertEquals(7.8967, teamVO.stealEfficient, 0.0001);
    }

    /**
     * Method: findTeamNormal()
     */
    @Test
    public void testFindTeamNormal() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().findTeamNormal();
        assertEquals(30, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            TeamVO teamVO = arrayList.get(i);
            if (teamVO.teamName.equals("Spurs")) {
                System.out.println("Spurs-----------id-------" + teamVO.id);
                assertEquals(2063, teamVO.assist);
                assertEquals(419, teamVO.blockShot);
                assertEquals(2778, teamVO.defendRebound);
                assertEquals(1152, teamVO.fault);
                assertEquals(1491, teamVO.foul);
                assertEquals(82, teamVO.numOfGame);
                assertEquals(761, teamVO.offendRebound);
                assertEquals(8629, teamVO.point);
                assertEquals(3539, teamVO.rebound);
                assertEquals(604, teamVO.steal);
            }
        }
    }

    /**
     * Method: findTeamNormalAvg()
     */
    @Test
    public void testFindTeamNormalAvg() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().findTeamNormalAvg();
        assertEquals(30, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            TeamVO teamVO = arrayList.get(i);
            if (teamVO.teamName.equals("Rockets")) {
                System.out.println("Rockets-----------id--------------" + teamVO.id);
                assertEquals(21.3902, teamVO.avgAssist, 0.0001);
                assertEquals(5.6220, teamVO.avgBlockShot, 0.0001);
                assertEquals(34.0488, teamVO.avgDefendRebound, 0.0001);
                assertEquals(15.4146, teamVO.avgFault, 0.0001);
                assertEquals(20.4146, teamVO.avgFoul, 0.0001);
                assertEquals(11.1951, teamVO.avgOffendRebound, 0.0001);
                assertEquals(107.4878, teamVO.avgPoint, 0.0001);
                assertEquals(45.2439, teamVO.avgRebound, 0.0001);
                assertEquals(7.5732, teamVO.avgSteal, 0.0001);
            }
        }
    }

    /**
     * Method: findTeamBasic()
     */
    @Test
    public void testFindTeamBasic() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().findTeamBasic();
        for (int i = 0; i < arrayList.size(); i++) {
            TeamVO teamVO = arrayList.get(i);
            if (teamVO.teamName.equals("Warriors")) {
                assertEquals("GSW", teamVO.abridge);
                assertEquals("Golden State", teamVO.location);
                assertEquals('W', teamVO.league);
                assertEquals("Pacific", teamVO.division);
                assertEquals("Oracle Arena", teamVO.homeCourt);
                assertEquals(1946, teamVO.foundTime);
            }
        }

    }

    /**
     * Method: findTeamHigh()
     */
    @Test
    public void testFindTeamHigh() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().findTeamHigh();
        assertEquals(30, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            TeamVO teamVO = arrayList.get(i);
            if (teamVO.teamName.equals("Bucks")) {
                System.out.println("bucks-----------id-------" + teamVO.id);
                assertEquals(23.0825, teamVO.assistEfficient, 0.0001);
                assertEquals(111.4609, teamVO.defendEfficient, 0.0001);
                assertEquals(102.6442, teamVO.offendEfficient, 0.0001);
                assertEquals(0.1829, teamVO.winRate, 0.0001);
                assertEquals(7620.500261, teamVO.offendRound, 0.0001);
                assertEquals(7.0919, teamVO.stealEfficient, 0.00001);
                assertEquals(0.2715, teamVO.offendReboundEfficient, 0.0001);
                assertEquals(0.7140, teamVO.defendReboundEfficient, 0.0001);
            }
        }
    }

    /**
     * Method: sortTeamNormal(int num, String sortBy, boolean desc)
     */
    @Test
    public void testSortTeamNormal() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().sortTeamNormal(5, "blockShot", true);
        assertEquals(522, arrayList.get(0).blockShot);
        assertEquals(501, arrayList.get(1).blockShot);
        assertEquals(461, arrayList.get(2).blockShot);
        assertEquals(459, arrayList.get(3).blockShot);
        assertEquals(446, arrayList.get(4).blockShot);
    }

    /**
     * Method: sortTeamNormalAvg(int num, String sortBy, boolean desc)
     */
    @Test
    public void testSortTeamNormalAvg() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().sortTeamNormalAvg(5, "avgFault", true);
        assertEquals(16.3659, arrayList.get(0).avgFault, 0.0001);
        assertEquals(15.4146, arrayList.get(1).avgFault, 0.0001);
        assertEquals(15.3659, arrayList.get(2).avgFault, 0.0001);
        assertEquals(14.9390, arrayList.get(3).avgFault, 0.0001);
        assertEquals(14.8293, arrayList.get(4).avgFault, 0.0001);

    }

    /**
     * Method: sortTeamHigh(int num, String sortBy, boolean desc)
     */
    @Test
    public void testSortTeamHigh() throws Exception {
        ArrayList<TeamVO> arrayList = new TeamDataHandel().sortTeamHigh(5, "winRate", true);
        assertEquals(0.7561, arrayList.get(0).winRate, 0.0001);
        assertEquals(0.7195, arrayList.get(1).winRate, 0.0001);
        assertEquals(0.6951, arrayList.get(2).winRate, 0.0001);
        assertEquals(0.6829, arrayList.get(3).winRate, 0.0001);
        assertEquals(0.6585, arrayList.get(4).winRate, 0.0001);
    }

    /**
     * Method: teamMemberList(int teamID)
     */
    @Test
    public void testTeamMemberList() throws Exception {
        ArrayList<PlayerVO> arrayList = new TeamDataHandel().teamMemberList(3);
        for (int i = 0; i < arrayList.size();i++){
            PlayerVO playerVO = arrayList.get(i);
            System.out.println(playerVO.id+" "+ playerVO.teamName+" "+playerVO.name);
        }
    }

}
