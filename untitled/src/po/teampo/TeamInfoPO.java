package po.teampo;
/*
 * 基本信息
 */
public class TeamInfoPO {
	
	public TeamInfoPO(){}
	public int id;					//球队ID
	public String photo;			//球队图片
	public String teamName;			//球队名称
	public String abridge;			//球队名称缩写
	public String location;			//所在地
	public String conference;		//赛区
	public String division;			//分区
	public String homeCourt;		//主场
	public int foundTime;			//建立时间
	
	public TeamInfoPO(int id, String photo, String teamName, String abridge,
			String location, String conference, String division,
			String homeCourt, int foundTime) {
		this.id = id;
		this.photo = photo;
		this.teamName = teamName;
		this.abridge = abridge;
		this.location = location;
		this.conference = conference;
		this.division = division;
		this.homeCourt = homeCourt;
		this.foundTime = foundTime;
	}
	
	public int getId() {
		return id;
	}
	public String getPhoto() {
		return photo;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getAbridge() {
		return abridge;
	}
	public String getLocation() {
		return location;
	}
	public String getConference() {
		return conference;
	}
	public String getDivision() {
		return division;
	}
	public String getHomeCourt() {
		return homeCourt;
	}
	public int getFoundTime() {
		return foundTime;
	}
	
}
