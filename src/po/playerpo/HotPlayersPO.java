package po.playerpo;

public class HotPlayersPO {
	public String teamPhoto;		//所属球队图片
	public int id;					//球员ID
	public String photo;			//球员图片，数据王第一名全身像，其余为球员头像
	public String name;		//球员名称全名
	public String team;		//所属球队全名
	public double upgradePate;		//近五场的提升率（查询进步最快球员需要，查询热点球员时为null即可）
	public double value;		//热门属性值
	public String position;		//球员位置
}
