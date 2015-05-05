package test.dataservice.team; 

import data.DataInitial;
import data.input.Team;
import dataservice.team.TeamDataHandel;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.teamvo.TeamVO;

/** 
* TeamDataHandel Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 5, 2015</pre> 
* @version 1.0 
*/ 
public class TeamDataHandelTest {
    private DataInitial dataInitial;

@Before
public void before() throws Exception {
    dataInitial = new DataInitial();
    dataInitial.init();
} 

@After
public void after() throws Exception {
    dataInitial.end();
} 

/** 
* 
* Method: hotTeams(int num, String sortBy) 
* 
*/ 
@Test
public void testHotTeams() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTeamInfo(int teamId) 
* 
*/ 
@Test
public void testFindTeamInfoTeamId() throws Exception {
    TeamVO teamVO = new TeamDataHandel().findTeamInfo(1);
    System.out.println(teamVO.abridge +" " + teamVO.teamName);
}

/** 
* 
* Method: findTeamInfo(String teamName) 
* 
*/ 
@Test
public void testFindTeamInfoTeamName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTeamNormal() 
* 
*/ 
@Test
public void testFindTeamNormal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTeamNormalAvg() 
* 
*/ 
@Test
public void testFindTeamNormalAvg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTeamBasic() 
* 
*/ 
@Test
public void testFindTeamBasic() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTeamHigh() 
* 
*/ 
@Test
public void testFindTeamHigh() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortTeamNormal(int num, String sortBy, boolean desc) 
* 
*/ 
@Test
public void testSortTeamNormal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortTeamNormalAvg(int num, String sortBy, boolean desc) 
* 
*/ 
@Test
public void testSortTeamNormalAvg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortTeamHigh(int num, String sortBy, boolean desc) 
* 
*/ 
@Test
public void testSortTeamHigh() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: teamMemberList(int teamID) 
* 
*/ 
@Test
public void testTeamMemberList() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: sortTeam(ArrayList<String> attributes, int num, String sortBy, boolean desc) 
* 
*/ 
@Test
public void testSortTeam() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("sortTeam", ArrayList<String>.class, int.class, String.class, boolean.class); 
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
* Method: serial(TeamVO[] vos, int length, TeamVO vo, String sortBy, boolean desc) 
* 
*/ 
@Test
public void testSerial() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("serial", TeamVO[].class, int.class, TeamVO.class, String.class, boolean.class); 
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
* Method: compare(TeamVO vo1, TeamVO vo2, String sortBy) 
* 
*/ 
@Test
public void testCompare() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("compare", TeamVO.class, TeamVO.class, String.class); 
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
* Method: getHighInfo() 
* 
*/ 
@Test
public void testGetHighInfo() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("getHighInfo"); 
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
* Method: getAvgNormalInfo() 
* 
*/ 
@Test
public void testGetAvgNormalInfo() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("getAvgNormalInfo"); 
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
* Method: getNormalInfo() 
* 
*/ 
@Test
public void testGetNormalInfo() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("getNormalInfo"); 
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
* Method: getInformation() 
* 
*/ 
@Test
public void testGetInformation() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("getInformation"); 
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
* Method: getAllInformation() 
* 
*/ 
@Test
public void testGetAllInformation() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TeamDataHandel.getClass().getMethod("getAllInformation"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
