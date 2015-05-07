package test.dataservice.match;

import data.DataInitial;
import dataservice.match.MatchDataHandel;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import vo.matchvo.MatchContentPlayerVO;
import vo.matchvo.MatchVO;

import java.util.ArrayList;

/**
 * MatchDataHandel Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 6, 2015</pre>
 */
public class MatchDataHandelTest {

    @Before
    public void before() throws Exception {
        DataInitial.init();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: FindRecentMatches_p(int num, String playerName)
     */
    @Test
    public void testFindRecentMatches_pForNumPlayerName() throws Exception {

    }

    /**
     * Method: FindRecentMatches_t(String teamName)
     */
    @Test
    public void testFindRecentMatches_t() throws Exception {
        ArrayList<MatchVO> arrayList = new MatchDataHandel().FindRecentMatches_t("Celtics");
        System.out.println(arrayList.size()+"::::::::::");
        for (int i = 0; i < arrayList.size();i++){
            arrayList.get(i).show();
        }
    }

    /**
     * Method: findMatch(int matchID)
     */
    @Test
    public void testFindMatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByDate(String start, String end)
     */
    @Test
    public void testFindByDate() throws Exception {
        ArrayList<MatchVO> arrayList = new MatchDataHandel().findByDate("14-04-16", "14-04-16");
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).show();
        }
    }

    /**
     * Method: FindRecentMatches_p(String playerName)
     */
    @Test
    public void testFindRecentMatches_pPlayerName() throws Exception {
//    ArrayList<MatchContentPlayerVO> arrayList = new MatchDataHandel().FindRecentMatches_p("Kevin Durant");
//    for (int i = 0; i < arrayList.size();i++){
//        arrayList.get(i).show();
//    }
    }

    /**
     * Method: findByDP(String start, String end, String playerName)
     */
    @Test
    public void testFindByDP() throws Exception {
//    ArrayList<MatchContentPlayerVO> arrayList = new MatchDataHandel().findByDP("13-11-01","13-12-30","Kevin Durant");
//    for (int i = 0; i < arrayList.size();i++){
//        arrayList.get(i).show();
//    }
    }

    /**
     * Method: findByDT(String start, String end, String teamName)
     */
    @Test
    public void testFindByDT() throws Exception {
    ArrayList<MatchVO> arrayList = new MatchDataHandel().findByDT("13-04-15","15-05-11","Hawks");
    System.out.println(arrayList.size());
    for (int i = 0; i < arrayList.size();i++){
        arrayList.get(i).show();
    }
    }

    /**
     * Method: findRecent20()
     */
    @Test
    public void testFindRecent20() throws Exception {
        ArrayList<MatchVO> arrayList = new MatchDataHandel().findRecent20();
//    for (int i = 0;i < arrayList.size();i++){
//        MatchVO matchVO = arrayList.get(i);
////        matchVO.show();
//    }
    }


} 
