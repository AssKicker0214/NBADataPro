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
            "    establishmenttime double, PRIMARY KEY (tid)" +
            ")";
    static final String createPlayerTable = "create table player(" +
            "    pid int not null generated always as identity," +
            "    name varchar(30)," +
            "    number double," +
            "    position varchar(5)," +
            "    heightfoot double," +
            "    heightinch double," +
            "    weight double," +
            "    birth date," +
            "    age double," +
            "    exp double," +
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
            "    allscoref double," +
            "    allscorel double, PRIMARY KEY (mid)" +
            ")";
    static final String createMatchscoreTable = "create table matchscore(" +
            "    mid int ," +
            "    mindex double," +
            "    scoref double," +
            "    scorel double" +
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
            "    throwin double ," +
            "    throwall double ," +
            "    throw3in double ," +
            "    throw3all double ," +
            "    penaltyin double ," +
            "    penaltyall double ," +
            "    attackbas double ," +
            "    defencebas double ," +
            "    allbas double ," +
            "    helpatt double ," +
            "    interp double ," +
            "    block double ," +
            "    mistake double ," +
            "    foul double ," +
            "    score double ," +
            "    serialid double " +
            ")";
    static final String createViewAllPid = "create view allpid(pid) as (select pid from player)";

    static final String createViewPid2Tidtemp = "create view pidwithtid(pid,tid) as " +
            "(select playerscore.pid,playerscore.tid from " +
            "playerscore ,matchinfo where matchinfo.mid=playerscore.mid " +
            "and matchinfo.matchtime >= all (select matchinfo.matchtime " +
            "from matchinfo,playerscore p where p.pid = playerscore.pid " +
            "and p.mid = matchinfo.mid ) order by pid)";

    static final String createViewPid2Tnametemp = "create view pidwithtname(pid,tname) " +
            "as (select pidwithtid.pid,team.fullname from pidwithtid natural JOIN team)";

    static final String createViewPid2SStemp = "create view pid2SStemp(pid,startSession) as " +
            "(select pid,count(mid) from playerscore where playerscore.serialid<6 group by playerscore.pid)";

    static final String createViewPid2SS = "create view pid2SS(pid,startSession) as " +
            "(select allpid.pid,Pid2SStemp.startSession from allpid  left outer join Pid2SStemp)";

    static final String createViewPid2DDtemp = "create view pid2DDtemp(pid,DD) as " +
            "(select pid,count(mid) as DD from playerscore where (score>10 and allbas>10)or(score>10 and helpatt>10)or" +
            "(score>10 and interp>10)or(score>10 and block>10)or" +
            "(allbas>10 and helpatt>10)or(allbas>10 and interp>10)or" +
            "(allbas>10 and block>10)or(helpatt>10 and interp>10)or" +
            "(helpatt>10 and block>10)or(interp>10 and block>10) group by pid)";

    static final String createViewPid2DD = "create view pid2DD(pid,DD) as " +
            "(select allpid.pid,pid2DDtemp.DD from allpid left outer JOIN pid2DDtemp)";
    static final String createViewAllPlayerscore = "create view allplayerscore as (select allpid.pid,playerscore.mid,playerscore.tid from allpid  left outer JOIN playerscore)";
    static final String createViewPidMid2matchtime = "create view pidmid2matchtime(pid,mid,matchtime) as (select playerscore.pid,playerscore.mid" +
            ",matchinfo.matchtime from playerscore,matchinfo " +
            "where playerscore.mid = matchinfo.mid )";
    static final String createViewPid2L5Mid = "create view pid2l5mid(pid,mid) as (" +
            "select a.pid,a.mid from pidmid2matchtime a,pidmid2matchtime b where a.pid=b.pid and a.matchtime<=b.matchtime group by a.pid,a.mid having count(*) <= 5)";
    static final String createViewl5Playerscore = "create view l5playerscore as (" +
            "select playerscore.* from (select a.pid,a.mid from pidmid2matchtime a,pidmid2matchtime b where a.pid=b.pid and a.matchtime<=b.matchtime group by a.pid,a.mid having count(*) <= 5) as pid2l5midtemp,playerscore where pid2l5midtemp.pid = playerscore.pid and pid2l5midtemp.mid = playerscore.mid)";

    static final String createViewPid2lMtime = "create view pid2lmtime(pid,matchtime) as ("+
            "select pid,max(matchtime) from playerscore,matchinfo where playerscore.mid=matchinfo.mid group by pid)";

    static final String createViewPlayerscre2Matchinfo = "create view playerscore2matchinfo as (" +
            "select playerscore.*,matchinfo.matchtime from playerscore,matchinfo where playerscore.mid = matchinfo.mid)";
}
