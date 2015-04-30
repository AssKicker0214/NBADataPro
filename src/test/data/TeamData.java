package test.data;

import data.saver.MatchInfoSaver;
import data.saver.MatchScoreSaver;
import data.saver.PlayerScoreSaver;
import data.saver.TeamSaver;

/**
 * Created by chenghao on 15/4/27.
 */
public class TeamData implements Runnable{
    private PlayerScoreSaver playerScoreSaver;
    private MatchScoreSaver matchScoreSaver;
    private TeamSaver teamSaver;
    private MatchInfoSaver matchInfoSaver;
    private long lastModifiedTime;

    private int[] a_throwin;
    private int[] a_throwall;
    private int[] a_throw3in;
    private int[] a_throw3all;
    private int[] a_penaltyin;
    private int[] a_penaltyall;
    private int[] a_attackbas;
    private int[] a_defencebas;
    private int[] a_allbas;
    private int[] a_helpatt;
    private int[] a_interp;
    private int[] a_mistake;
    private int[] a_foul;
    private int[] a_score;
    private int[] b_throwin;
    private int[] b_throwall;
    private int[] b_throw3in;
    private int[] b_throw3all;
    private int[] b_penaltyin;
    private int[] b_penaltyall;
    private int[] b_attackbas;
    private int[] b_defencebas;
    private int[] b_allbas;
    private int[] b_helpatt;
    private int[] b_interp;
    private int[] b_mistake;
    private int[] b_foul;
    private int[] b_score;
    private int[] a_block;
    private double[] FPG;
    private double[] TPSP;
    private double[] FTP;
    private double[] leg;
    private double[] legB;
    private double[] assistP;
    private double[] stealP;
    private double[] ORtg;
    private double[] DRtg;


    public TeamData(PlayerScoreSaver playerScoreSaver,
                    MatchScoreSaver matchScoreSaver,
                    TeamSaver teamSaver,
                    MatchInfoSaver matchInfoSaver) {
        this.playerScoreSaver = playerScoreSaver;
        this.matchInfoSaver = matchInfoSaver;
        this.matchScoreSaver = matchScoreSaver;
        this.teamSaver = teamSaver;

        init();

    }

    public void init(){
        setAllbas();
        setAttackbas();
        setBlock();
        setDefencebas();
        setFoul();
        setHelpatt();
        setInterp();
        setMistake();
        setPenaltyall();
        setPenaltyin();
        setScore();
        setThrow3in();
        setThrow3all();
        setThrowall();
        setThrowin();
        setDefencebasB();
        setAttackbasB();
        setMistakeB();
        setPenaltyallB();
        setThrowallB();
        setThrowinB();
        setScoreB();

        setLeg();
        setLegB();

        setDRtg();
        setFGP();
        setFTP();
        setTPSP();
        setAssistP();
        setStealP();
        setORtg();
        setDRtg();
        refreshTime();
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (matchInfoSaver.getLastModifiedTime() > lastModifiedTime ||
                teamSaver.getLastModifiedTime() > lastModifiedTime)
            init();
    }

    private void refreshTime() {
        lastModifiedTime = System.currentTimeMillis();
    }

    public int[] getMatchNum() {
        return null;
    }

    private void setThrowin() {
        a_throwin = playerScoreSaver.get_sum_a_throwins(playerScoreSaver.getPidDefaultMid());
    }

    private void setThrowinB() {
        b_throwin = playerScoreSaver.get_sum_b_throwins(playerScoreSaver.getPidDefaultMid());
    }

    private void setThrowall() {
        a_throwall = playerScoreSaver.get_sum_a_throwalls(playerScoreSaver.getPidDefaultMid());
    }

    private void setThrowallB() {
        b_throwall = playerScoreSaver.get_sum_b_throwalls(playerScoreSaver.getPidDefaultMid());
    }

    private void setFGP() {
        FPG = new double[teamSaver.getNum()];
        for (int i = 0; i < a_throwin.length; i++) {
            FPG[i] = ((double) a_throwin[i]) / a_throwall[i];
        }
    }

    public double[] getFGP() {
        return FPG;
    }

    private void setThrow3in() {
        a_throw3in = playerScoreSaver.get_sum_a_throw3ins(playerScoreSaver.getPidDefaultMid());
    }

    private void setThrow3all() {
        a_throw3all = playerScoreSaver.get_sum_a_throw3alls(playerScoreSaver.getPidDefaultMid());
    }

    private void setTPSP() {
        TPSP = new double[teamSaver.getNum()];
        for (int i = 0; i < a_throw3in.length; i++) {
            TPSP[i] = ((double) a_throw3in[i]) / a_throw3all[i];
        }
    }

    public double[] getTPSP() {

        return TPSP;
    }

    private void setPenaltyin() {
        a_penaltyin = playerScoreSaver.get_sum_a_penaltyins(playerScoreSaver.getPidDefaultMid());
    }

    private void setPenaltyall() {
        a_penaltyall = playerScoreSaver.get_sum_a_penaltyalls(playerScoreSaver.getPidDefaultMid());
    }

    private void setPenaltyallB() {
        b_penaltyall = playerScoreSaver.get_sum_b_penaltyalls(playerScoreSaver.getPidDefaultMid());
    }

    private void setFTP() {
        FTP = new double[teamSaver.getNum()];
        for (int i = 0; i < a_penaltyall.length; i++) {
            FTP[i] = ((double) a_penaltyin[i]) / a_penaltyall[i];
        }
    }

    public double[] getFTP() {

        return FTP;
    }

    private void setAttackbas() {
        a_attackbas = playerScoreSaver.get_sum_a_attackbass(playerScoreSaver.getPidDefaultMid());
    }

    private void setAttackbasB() {
        b_attackbas = playerScoreSaver.get_sum_b_attackbass(playerScoreSaver.getPidDefaultMid());
    }

    private void setDefencebas() {
        a_defencebas = playerScoreSaver.get_sum_a_defencebass(playerScoreSaver.getPidDefaultMid());
    }

    private void setDefencebasB() {
        b_defencebas = playerScoreSaver.get_sum_b_defencebass(playerScoreSaver.getPidDefaultMid());
    }

    private void setAllbas() {
        a_allbas = playerScoreSaver.get_sum_a_allbass(playerScoreSaver.getPidDefaultMid());
    }

    private void setHelpatt() {
        a_helpatt = playerScoreSaver.get_sum_a_helpatts(playerScoreSaver.getPidDefaultMid());
    }

    private void setInterp() {
        a_interp = playerScoreSaver.get_sum_a_interps(playerScoreSaver.getPidDefaultMid());
    }

    private void setBlock() {
        a_block = playerScoreSaver.get_sum_a_blocks(playerScoreSaver.getPidDefaultMid());
    }

    private void setMistake() {
        a_mistake = playerScoreSaver.get_sum_a_mistakes(playerScoreSaver.getPidDefaultMid());
    }

    private void setMistakeB() {
        b_mistake = playerScoreSaver.get_sum_b_mistakes(playerScoreSaver.getPidDefaultMid());
    }

    private void setFoul() {
        a_foul = playerScoreSaver.get_sum_a_fouls(playerScoreSaver.getPidDefaultMid());
    }

    private void setScore() {
        a_score = playerScoreSaver.get_sum_a_scores(playerScoreSaver.getPidDefaultMid());
    }

    private void setScoreB() {
        b_score = playerScoreSaver.get_sum_b_scores(playerScoreSaver.getPidDefaultMid());
    }

    private void setLegB() {
        legB = new double[teamSaver.getNum()];
        for (int i = 0; i < legB.length; i++) {
            legB[i] =b_throwall[i] + 0.4 * b_penaltyall[i] - 1.07 * (b_attackbas[i] / ((b_attackbas[i] + a_defencebas[i]) * (double) (b_throwall[i] - b_throwin[i]))) + 1.07 * b_mistake[i];
        }
    }

    public int[] getBS() {
        return a_block;
    }

    public int[] getAssist() {
        return a_helpatt;
    }

    private void setB_defencebas(){
        b_defencebas = playerScoreSaver.get_sum_b_defencebass(playerScoreSaver.getPidDefaultMid());
    }

    private void setLeg() {
        leg = new double[teamSaver.getNum()];
        for (int i = 0; i < leg.length; i++) {
            leg[i] =a_throwall[i] + 0.4 * a_penaltyall[i] - 1.07 * (a_attackbas[i] / ((a_attackbas[i] + b_defencebas[i]) * (double) (a_throwall[i] - a_throwin[i]))) + 1.07 * a_mistake[i];
        }
    }

    public double[] getLeg(){
        return leg;
    }

    private void setAssistP(){
        assistP = new double[teamSaver.getNum()];
        for (int i = 0; i < assistP.length; i++){
            assistP[i] = 100 * a_helpatt[i] / leg[i];
        }
    }

    public double[] getAssistP(){
        return assistP;
    }

    public int[] getRebound(){
        return a_allbas;
    }

    public int[] getORebound(){
        return a_attackbas;
    }

    public int[] getDRebound(){
        return a_defencebas;
    }

    public int[] getSteal(){
        return a_interp;
    }

    private void setStealP(){
        stealP = new double[teamSaver.getNum()];
        for (int i = 0; i<stealP.length; i++){
            stealP[i] = 100 * a_interp[i] / legB[i];
        }
    }

    public double[] getStealP(){
        return stealP;
    }

    public int[] getTurnover(){
        return a_mistake;
    }

    public int[] getFoul(){
        return a_foul;
    }

    public int[] getScore(){
        return  a_score;
    }

    private void setORtg(){
        ORtg = new double[teamSaver.getNum()];
        for (int i = 0; i < ORtg.length; i++){
            ORtg[i] = 100 * a_score[i]  / leg[i];
        }
    }

    public double[] getORtg(){
        return  ORtg;
    }

    private void setDRtg(){
        DRtg = new double[teamSaver.getNum()];
        for (int i = 0;i<DRtg.length;i++){
            DRtg[i] = 100 * b_score[i]  / legB[i];
        }
    }

    public double[] getDRtg(){
        return DRtg;
    }
}
