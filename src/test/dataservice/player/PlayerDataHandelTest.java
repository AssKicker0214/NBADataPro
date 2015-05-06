package test.dataservice.player; 

import data.DataInitial;
import data.input.Player;
import data.saver.PlayerSaver;
import dataservice.player.PlayerDataHandel;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.playervo.PlayerVO;

import java.util.ArrayList;

/** 
* PlayerDataHandel Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 6, 2015</pre> 
* @version 1.0 
*/ 
public class PlayerDataHandelTest { 

@Before
public void before() throws Exception {
    DataInitial.init();
} 

@After
public void after() throws Exception {
    DataInitial.end();
} 

/**
* 
* Method: findPlayerData(int playerId) 
* 
*/ 
@Test
public void testFindPlayerDataPlayerId() throws Exception {
    PlayerVO playerVO = new PlayerDataHandel().findPlayerData(33);
    System.out.println(playerVO.name);
    System.out.println(playerVO.minute);
    System.out.println(playerVO.start);
    System.out.println(playerVO.numOfGame);
    System.out.println(playerVO.shot);
    System.out.println(playerVO.penalty);
    System.out.println(playerVO.three);
    System.out.println(playerVO.stealEfficient);
    System.out.println(playerVO.faultEfficient);
    System.out.println(playerVO.efficiency);
    System.out.println(playerVO.gmSc);
    System.out.println(playerVO.blockShotEfficient);
    System.out.println(playerVO.assistEfficient);
    System.out.println(playerVO.defendReboundEfficient);
    System.out.println(playerVO.offendReboundEfficient);
    System.out.println(playerVO.reboundEfficient);
//    System.out.println(playerVO.assistEfficient);
//    System.out.println(playerVO.assistEfficient);
//    System.out.println(playerVO.name);
//    System.out.println(playerVO.name);
//    System.out.println(playerVO.name);

//    PlayerSaver.getPlayerSaver().show();
}

/** 
* 
* Method: findPlayerData(String name) 
* 
*/ 
@Test
public void testFindPlayerDataName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPlayers(String msg) 
* 
*/ 
@Test
public void testFindPlayers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortPlayerInfo(ArrayList<sortParam> sortBy) 
* 
*/ 
@Test
public void testSortPlayerInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortPlayerNormal(ArrayList<sortParam> sortBy) 
* 
*/ 
@Test
public void testSortPlayerNormal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortPlayerNormalAvg(ArrayList<sortParam> sortBy) 
* 
*/ 
@Test
public void testSortPlayerNormalAvg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getToday() 
* 
*/ 
@Test
public void testGetToday() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTeamPlayerVOs(int teamID) 
* 
*/ 
@Test
public void testGetTeamPlayerVOs() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortPlayerHigh(ArrayList<sortParam> sortBy) 
* 
*/ 
@Test
public void testSortPlayerHigh() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: filterInfo(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) 
* 
*/ 
@Test
public void testFilterInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: filterNormal(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) 
* 
*/ 
@Test
public void testFilterNormal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: filterNormalAvg(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) 
* 
*/ 
@Test
public void testFilterNormalAvg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: filterHigh(ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) 
* 
*/ 
@Test
public void testFilterHigh() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: DailyKing(int num, String sortBy) 
* 
*/ 
@Test
public void testDailyKing() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: SeasonKing(int num, String sortBy) 
* 
*/ 
@Test
public void testSeasonKing() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: hotPlayer(int num, String sortBy) 
* 
*/ 
@Test
public void testHotPlayer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: avgLeague() 
* 
*/ 
@Test
public void testAvgLeague() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: compare(PlayerVO o1, PlayerVO o2) 
* 
*/ 
@Test
public void testCompare() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: findPlayer() 
* 
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
* 
* Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, ArrayList<sortParam> sortBy) 
* 
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
* 
* Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, sortParam sortParam) 
* 
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
* 
* Method: compare(PlayerVO playerVO1, PlayerVO playerVO2, String field) 
* 
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
* 
* Method: filter(ArrayList<String> attributes, ArrayList<sortParam> sortBy, ArrayList<String> position, ArrayList<String> league, int numS, int numE) 
* 
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
* 
* Method: isInPosition(ArrayList<String> position, PlayerVO playerVO) 
* 
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
* 
* Method: isInLeague(ArrayList<String> league, PlayerVO playerVO) 
* 
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
* 
* Method: isInAge(int numS, int numE, PlayerVO playerVO) 
* 
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
