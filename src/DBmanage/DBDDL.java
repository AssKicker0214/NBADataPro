package DBmanage;

/**
 * Created by chenghao on 15/4/12.
 */
public class DBDDL {
    static final String createFileInputTable = "create table fileinput(filename varchar(32),date TIMESTAMP default CURRENT_TIMESTAMP)";
    static final String createTeamTable = "create table team(" +
            "    tid int not null generated always as identity," +
            "    fullname varchar(16)," +
            "    abbreviation char(3)," +
            "    location varchar(15)," +
            "    area char(1) not null," +
            "    subarea char(9) not null," +
            "    homefield varchar(30)," +
            "    establishmenttime int, PRIMARY KEY (tid)" +
            ")";
    static final String createPlayerTable = "create table player(" +
            "    pid int not null generated always as identity," +
            "    name varchar(30)," +
            "    number int," +
            "    position varchar(5)," +
            "    heightfoot int," +
            "    heightinch int," +
            "    weight int," +
            "    birth date," +
            "    age int," +
            "    exp int," +
            "    school varchar(40)," +
            "    imgsrc varchar(30), PRIMARY KEY (pid)" +
            ")";
    static final String createMatchinfoTable = "create table matchinfo(" +
            "    mid int not null generated always as identity," +
            "    seasonf int," +
            "    seasonl int," +
            "    matchtime date," +
            "    teamf int ," +
            "    teaml int ," +
            "    allscoref int," +
            "    allscorel int, PRIMARY KEY (mid)" +
            ")";
    static final String createMatchscoreTable = "create table matchscore(" +
            "    mid int ," +
            "    mindex int," +
            "    scoref int," +
            "    scorel int" +
            ")";
    static final String createPlayerpositionTable = "create table playerposition(" +
            "    pid int," +
            "    position varchar(1)" +
            ")";

    static final String createPlayerScoreTable = "create table playerscore(" +
            "    mid int ," +
            "    tid int ," +
            "    pid int ," +
            "    position char(3)," +
            "    inplacetime time," +
            "    throwin int ," +
            "    throwall int ," +
            "    throw3in int ," +
            "    throw3all int ," +
            "    penaltyin int ," +
            "    penaltyall int ," +
            "    attackbas int ," +
            "    defencebas int ," +
            "    allbas int ," +
            "    helpatt int ," +
            "    interp int ," +
            "    block int ," +
            "    mistake int ," +
            "    foul int ," +
            "    score int ," +
            "    serialid int " +
            ")";
}
