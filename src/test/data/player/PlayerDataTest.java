package test.data.player; 

import data.player.PlayerData;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* PlayerData Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 22, 2015</pre> 
* @version 1.0 
*/ 
public class PlayerDataTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findPlayerData(int playerId) 
* 
*/ 
@Test
public void testFindPlayerData() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPlayerList(ArrayList<String> list) 
* 
*/ 
@Test
public void testFindPlayerList() throws Exception {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("FGP");
    arrayList.add("GmSc");
    arrayList.add("stealP");
    new PlayerData().findPlayerList(arrayList);
}

/** 
* 
* Method: sortPlayerList(ArrayList<String> list, String mainProperty, boolean order) 
* 
*/ 
@Test
public void testSortPlayerList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTop50(ArrayList<String> list, String mainProperty, ArrayList<String> position, ArrayList<String> division) 
* 
*/ 
@Test
public void testFindTop50ForListMainPropertyPositionDivision() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTop50_pos(ArrayList<String> list, String mainProperty, ArrayList<String> position) 
* 
*/ 
@Test
public void testFindTop50_pos() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTop50_div(ArrayList<String> list, String mainProperty, ArrayList<String> division) 
* 
*/ 
@Test
public void testFindTop50_div() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findTop50(ArrayList<String> list, String mainProperty) 
* 
*/ 
@Test
public void testFindTop50ForListMainProperty() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPlayerInfo(int playerId) 
* 
*/ 
@Test
public void testFindPlayerInfo() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: getPlayerDataPO(ArrayList<String> list, Object[] objects) 
* 
*/ 
@Test
public void testGetPlayerDataPO() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getPlayerDataPO", ArrayList<String>.class, Object[].class); 
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
* Method: setValue(PlayerPO dataPO, String string, Object object) 
* 
*/ 
@Test
public void testSetValue() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("setValue", PlayerPO.class, String.class, Object.class); 
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
* Method: getTime(int timeS) 
* 
*/ 
@Test
public void testGetTime() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getTime", int.class); 
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
* Method: getSql(ArrayList<String> list) 
* 
*/ 
@Test
public void testGetSqlList() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getSql", ArrayList<String>.class); 
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
* Method: getSql(ArrayList<String> list, String wheres) 
* 
*/ 
@Test
public void testGetSqlForListWheres() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getSql", ArrayList<String>.class, String.class); 
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
* Method: getSql(ArrayList<String> list, String wheres, String froms) 
* 
*/ 
@Test
public void testGetSqlForListWheresFroms() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getSql", ArrayList<String>.class, String.class, String.class); 
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
* Method: queryHandel(ArrayList<String> list, PlayerMaterialSql materialSql) 
* 
*/ 
@Test
public void testQueryHandel() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("queryHandel", ArrayList<String>.class, PlayerMaterialSql.class); 
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
* Method: getQuery(String string, PlayerMaterialSql materialSql) 
* 
*/ 
@Test
public void testGetQuery() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getQuery", String.class, PlayerMaterialSql.class); 
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
* Method: getTOP50(ArrayList<String> list, String mainProperty, String from, String where) 
* 
*/ 
@Test
public void testGetTOP50() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PlayerData.getClass().getMethod("getTOP50", ArrayList<String>.class, String.class, String.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
