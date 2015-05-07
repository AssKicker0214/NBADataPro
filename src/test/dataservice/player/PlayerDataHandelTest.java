package test.dataservice.player;

import data.DataInitial;
import data.saver.PlayerScoreSaver;
import dataservice.player.PlayerDataHandel;
import dataservice.player.sortParam;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vo.playervo.HotPlayersVO;
import vo.playervo.PlayerVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * PlayerDataHandel Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 6, 2015</pre>
 */
public class PlayerDataHandelTest {

    @Before
    public void before() throws Exception {
        DataInitial.init();
    }

    @After
    public void after() throws Exception {
//        DataInitial.end();
    }

    /**
     * Method: findPlayerData(int playerId)
     */
    @Test
    public void testFindPlayerDataPlayerId() throws Exception {
        PlayerVO playerVO = new PlayerDataHandel().findPlayerData(70);
//    System.out.println(playerVO.name);
        assertEquals("Chauncey Billups", playerVO.name);
//    System.out.println(playerVO.minute);
        assertEquals(18568, playerVO.minute);
//    System.out.println(playerVO.start);
        assertEquals(7, playerVO.start);
//    System.out.println(playerVO.numOfGame);
        assertEquals(19, playerVO.numOfGame);
//    System.out.println(playerVO.shot);
        assertEquals(0.3038, playerVO.shot, 0.0001);
//    System.out.println(playerVO.penalty);
        assertEquals(0.8333, playerVO.penalty, 0.0001);
//    System.out.println(playerVO.three);
        assertEquals(0.2917, playerVO.three, 0.0001);
//    System.out.println(playerVO.stealEfficient);
        assertEquals(0.013080681913, playerVO.stealEfficient, 0.0001);
//    System.out.println("faultEfficient:"+playerVO.faultEfficient);
        assertEquals(0.4080, playerVO.faultEfficient, 0.0001);
//    System.out.println(playerVO.efficiency);
        assertEquals(69, playerVO.efficiency, 0.0001);
//    System.out.println(playerVO.gmSc);
        assertEquals(38.6, playerVO.gmSc, 0.0001);
//    System.out.println(playerVO.blockShotEfficient);
        assertEquals(0.002537750646, playerVO.blockShotEfficient, 0.00001);
//    System.out.println(playerVO.assistEfficient);
        assertEquals(0.1889, playerVO.assistEfficient, 0.0001);
//    System.out.println(playerVO.defendReboundEfficient);
        assertEquals(0.042842218223, playerVO.defendReboundEfficient, 0.0001);
//    System.out.println(playerVO.offendReboundEfficient);
        assertEquals(0.007140369704, playerVO.offendReboundEfficient, 0.0001);
//    System.out.println(playerVO.reboundEfficient);
        assertEquals(0.049982587927, playerVO.reboundEfficient, 0.0001);
//    System.out.println(playerVO.frequency);
        assertEquals(0.15132839190556, playerVO.frequency, 0.0001);
//    System.out.println(playerVO.realShot);
        assertEquals(0.4271, playerVO.realShot, 0.0001);
//    System.out.println(playerVO.shotEfficient);
        assertEquals(0.39241, playerVO.shotEfficient, 0.0001);
//    System.out.println(playerVO.teamName);


//    System.out.println(playerVO.assistEfficient);
//    System.out.println(playerVO.assistEfficient);
//    System.out.println(playerVO.name);
//    System.out.println(playerVO.name);
//    System.out.println(playerVO.name);

//    PlayerSaver.getPlayerSaver().show();
    }

    /**
     * Method: findPlayerData(String name)
     */
    @Test
    public void testFindPlayerDataName() throws Exception {
        PlayerVO playerVO = new PlayerDataHandel().findPlayerData("Gerald Green");
        //    System.out.println(playerVO.name);
        assertEquals("Gerald Green", playerVO.name);
//    System.out.println(playerVO.minute);
        assertEquals(139792, playerVO.minute);
//    System.out.println(playerVO.start);
        assertEquals(48, playerVO.start);
//    System.out.println(playerVO.numOfGame);
        assertEquals(82, playerVO.numOfGame);
//    System.out.println(playerVO.shot);
        assertEquals(0.4453, playerVO.shot, 0.0001);
//    System.out.println(playerVO.penalty);
        assertEquals(0.8478, playerVO.penalty, 0.0001);
//    System.out.println(playerVO.three);
        assertEquals(0.4000, playerVO.three, 0.0001);
//    System.out.println(playerVO.stealEfficient);
        assertEquals(0.014969938462, playerVO.stealEfficient, 0.0001);
//    System.out.println("faultEfficient:"+playerVO.faultEfficient);
        assertEquals(0.1954, playerVO.faultEfficient, 0.0001);
//    System.out.println(playerVO.efficiency);
        assertEquals(1066, playerVO.efficiency, 0.0001);
//    System.out.println(playerVO.gmSc);
        assertEquals(809.5, playerVO.gmSc, 0.0001);
//    System.out.println(playerVO.blockShotEfficient);
        assertEquals(0.013676021425, playerVO.blockShotEfficient, 0.00001);
//    System.out.println(playerVO.assistEfficient);
        assertEquals(0.0858, playerVO.assistEfficient, 0.0001);
//    System.out.println(playerVO.defendReboundEfficient);
        assertEquals(0.054673008249, playerVO.defendReboundEfficient, 0.0001);
//    System.out.println(playerVO.offendReboundEfficient);
        assertEquals(0.011560812317, playerVO.offendReboundEfficient, 0.0001);
//    System.out.println(playerVO.reboundEfficient);
        assertEquals(0.066233820566, playerVO.reboundEfficient, 0.0001);
//    System.out.println(playerVO.frequency);
        assertEquals(0.23745623717720, playerVO.frequency, 0.0001);
//    System.out.println(playerVO.realShot);
        assertEquals(0.5848, playerVO.realShot, 0.0001);
//    System.out.println(playerVO.shotEfficient);
        assertEquals(0.54672, playerVO.shotEfficient, 0.0001);
//    System.out.println(playerVO.teamName);
    }

    /**
     * Method: findPlayers(String msg)
     */
    @Test
    public void testFindPlayers() throws Exception {
        ArrayList<PlayerVO> arrayList = new PlayerDataHandel().findPlayers("dan");
        assertEquals("Danilo Gallinari",arrayList.get(0).name);
        assertEquals("Danny Granger",arrayList.get(1).name);
        assertEquals("Danny Green",arrayList.get(2).name);
        assertEquals("Dante Cunningham",arrayList.get(3).name);
    }
    /**
     * Method: sortPlayerInfo(ArrayList<sortParam> sortBy)
     */
    @Test
    public void testSortPlayerInfo() throws Exception {
        ArrayList<sortParam> arrayList1 = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam1.isDesc =false;
        sortParam1.field = "avgPoint";
        arrayList1.add(sortParam1);
        ArrayList<PlayerVO> arrayList = new PlayerDataHandel().sortPlayerInfo(arrayList1);
        for (int i = 0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i).name);
        }
    }

    /**
     * Method: sortPlayerNormal(ArrayList<sortParam> sortBy)
     */
    @Test
    public void testSortPlayerNormal() throws Exception {
        ArrayList<sortParam> arrayList1 = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam1.isDesc =true;
        sortParam1.field = "assist";
        sortParam sortParam2 = new sortParam();
        sortParam2.isDesc =true;
        sortParam2.field = "blockShot";
        sortParam sortParam3 = new sortParam();
        sortParam3.isDesc =true;
        sortParam3.field = "shot";
        arrayList1.add(sortParam1);
        arrayList1.add(sortParam2);
        arrayList1.add(sortParam3);
        ArrayList<PlayerVO> arrayList = new PlayerDataHandel().sortPlayerNormal(arrayList1);
        for (int i = 0; i<arrayList.size();i++){
            PlayerVO playerVO = arrayList.get(i);
            System.out.println(playerVO.assist+" "+playerVO.blockShot+" "+playerVO.shot);
        }
    }

    /**
     * Method: sortPlayerNormalAvg(ArrayList<sortParam> sortBy)
     */
    @Test
    public void testSortPlayerNormalAvg() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getToday()
     */
    @Test
    public void testGetToday() throws Exception {
        assertEquals("15-05-07",new PlayerDataHandel().getToday());
    }

    /**
     * Method: getTeamPlayerVOs(int teamID)
     */
    @Test
    public void testGetTeamPlayerVOs() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sortPlayerHigh(ArrayList<sortParam> sortBy)
     */
    @Test
    public void testSortPlayerHigh() throws Exception {
        ArrayList<sortParam> arrayList1 = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam1.isDesc =true;
        sortParam1.field = "assistEfficient";
        sortParam sortParam2 = new sortParam();
        sortParam2.isDesc =true;
        sortParam2.field = "blockShotEfficient";
        sortParam sortParam3 = new sortParam();
        sortParam3.isDesc =true;
        sortParam3.field = "gmSc";
        arrayList1.add(sortParam1);
        arrayList1.add(sortParam2);
        arrayList1.add(sortParam3);
        ArrayList<PlayerVO> arrayList = new PlayerDataHandel().sortPlayerHigh(arrayList1);
        for (int i = 0; i<arrayList.size();i++){
            PlayerVO playerVO = arrayList.get(i);
            System.out.println(playerVO.assistEfficient+" "+playerVO.blockShotEfficient+" "+playerVO.gmSc);
        }
    }

    /**
     * Method: filterInfo(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE)
     */
    @Test
    public void testFilterInfo() throws Exception {
        ArrayList<sortParam> sortBy = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam1.field="name";
        sortParam1.isDesc = true;
        sortBy.add(sortParam1);
        ArrayList<String> position = new ArrayList<>();
        String position1 = "F";
        String position2 = "G";
        position.add(position1);
        position.add(position2);
        ArrayList<String> league = new ArrayList<>();
        league.add("E");
        ArrayList<PlayerVO> playerVOs = new PlayerDataHandel().filterInfo(sortBy,position,league,10,30);
        for (int i = 0; i < playerVOs.size(); i++){
            PlayerVO playerVO = playerVOs.get(i);
            System.out.println(playerVO.name+" "+playerVO.position+" "+playerVO.league+" "+playerVO.age+" "+playerVO.hight+" "+playerVO.weigth);
        }

//        PlayerScoreSaver.getPlayerScoreSaver().show();
    }

    /**
     * Method: filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE)
     */
    @Test
    public void testFilterNormal() throws Exception {
        ArrayList<sortParam> sortBy = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam sortParam2 = new sortParam();
        sortParam sortParam3 = new sortParam();
        sortParam1.field="numOfGame";
        sortParam1.isDesc = true;
        sortParam2.field="shot";
        sortParam2.isDesc = true;
        sortParam3.field="three";
        sortParam3.isDesc = true;
        sortBy.add(sortParam1);
        sortBy.add(sortParam2);
        sortBy.add(sortParam3);
        ArrayList<String> position = new ArrayList<>();
        String position1 = "F";
        String position2 = "G";
        position.add(position1);
        position.add(position2);
        ArrayList<String> league = new ArrayList<>();
        league.add("E");
        ArrayList<PlayerVO> playerVOs = new PlayerDataHandel().filterNormal(sortBy, position, league, 10, 30);
        for (int i = 0; i < playerVOs.size(); i++){
            PlayerVO playerVO = playerVOs.get(i);
            System.out.println(playerVO.numOfGame+" "+playerVO.shot+" "+playerVO.shot+" "+playerVO.three);
//            System.out.println(playerVO.three);
        }
    }

    /**
     * Method: filterNormalAvg(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE)
     */
    @Test
    public void testFilterNormalAvg() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE)
     */
    @Test
    public void testFilterHigh() throws Exception {
        ArrayList<sortParam> sortBy = new ArrayList<>();
        sortParam sortParam1 = new sortParam();
        sortParam sortParam2 = new sortParam();
        sortParam sortParam3 = new sortParam();
        sortParam1.field="assistEfficient";
        sortParam1.isDesc = true;
        sortParam2.field="blockShotEfficient";
        sortParam2.isDesc = true;
        sortParam3.field="faultEfficient";
        sortParam3.isDesc = true;
        sortBy.add(sortParam1);
        sortBy.add(sortParam2);
        sortBy.add(sortParam3);
        ArrayList<String> position = new ArrayList<>();
        String position1 = "F";
        String position2 = "G";
        position.add(position1);
        position.add(position2);
        ArrayList<String> league = new ArrayList<>();
        league.add("E");
        ArrayList<PlayerVO> playerVOs = new PlayerDataHandel().filterHigh(sortBy, position, league, 10, 30);
        for (int i = 0; i < playerVOs.size(); i++){
            PlayerVO playerVO = playerVOs.get(i);
            System.out.println(playerVO.assistEfficient+" "+playerVO.blockShotEfficient+" "+playerVO.faultEfficient);
//            System.out.println(playerVO.three);
        }
    }

    /**
     * Method: DailyKing(int num, String sortBy)
     */
    @Test
    public void testDailyKing() throws Exception {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataHandel().DailyKing(100, "three","13-12-10");
        for (int i = 0; i < arrayList.size();i++){
            HotPlayersVO hotPlayersVO = arrayList.get(i);
            System.out.println(hotPlayersVO.name+" "+hotPlayersVO.value);
        }
    }

    /**
     * Method: SeasonKing(int num, String sortBy)
     */
    @Test
    public void testSeasonKing() throws Exception {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataHandel().SeasonKing(100, "three");
        for (int i = 0; i < arrayList.size();i++){
            HotPlayersVO hotPlayersVO = arrayList.get(i);
            System.out.println(hotPlayersVO.name+" "+hotPlayersVO.value);
        }
    }

    /**
     * Method: hotPlayer(int num, String sortBy)
     */
    @Test
    public void testHotPlayer() throws Exception {
        ArrayList<HotPlayersVO> arrayList = new PlayerDataHandel().hotPlayer(100,"three");
        for (int i = 0; i < arrayList.size();i++){
            HotPlayersVO hotPlayersVO = arrayList.get(i);
            System.out.println(hotPlayersVO.name+" "+hotPlayersVO.value+" "+hotPlayersVO.upgradeRate);
        }
    }

    /**
     * Method: avgLeague()
     */
    @Test
    public void testAvgLeague() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: compare(PlayerVO o1, PlayerVO o2)
     */
    @Test
    public void testCompare() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: findPlayer()
     */
    @Test
    public void testFindPlayer() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("findPlayer"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, ArrayList<sortParam> sortBy)
     */
    @Test
    public void testCompareForPlayerVO1PlayerVO2SortBy() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("compare", PlayerVO.class, PlayerVO.class, ArrayList<sortParam>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, sortParam sortParam)
     */
    @Test
    public void testCompareForPlayerVO1PlayerVO2SortParam() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("compare", PlayerVO.class, PlayerVO.class, sortParam.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, String field)
     */
    @Test
    public void testCompareForPlayerVO1PlayerVO2Field() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("compare", PlayerVO.class, PlayerVO.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: filter(ArrayList<String> attributes, ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE)
     */
    @Test
    public void testFilter() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("filter", ArrayList<String>.class, ArrayList<sortParam>.class, ArrayList<String>.class, ArrayList<String>.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: isInPosition(ArrayList<String> position, PlayerVO playerVO)
     */
    @Test
    public void testIsInPositionForPositionPlayerVO() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("isInPosition", ArrayList<String>.class, PlayerVO.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: isInLeague(ArrayList<String> league, PlayerVO playerVO)
     */
    @Test
    public void testIsInLeagueForLeaguePlayerVO() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("isInLeague", ArrayList<String>.class, PlayerVO.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: isInAge(int numS, int numE, PlayerVO playerVO)
     */
    @Test
    public void testIsInAge() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerDataHandel.getClass().getMethod("isInAge", int.class, int.class, PlayerVO.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
