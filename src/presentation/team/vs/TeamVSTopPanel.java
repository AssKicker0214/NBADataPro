package presentation.team.vs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataservice.player.PlayerDataService;
import dataservice.player.PlayerData_stub;
import presentation.common.PhotoLabel;
import presentation.player.playerDetail.PlayerMiddlePanel;
import presentation.player.vs.PlayersVSTopPanel;
import vo.playervo.PlayerVO;
import vo.teamvo.TeamVO;

public class TeamVSTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel localTeamPhotoLabel;
	JLabel anotherTeamPhotoLabel;
	JLabel VSUpLabel;
	JLabel VSDownLabel;
	JLabel localInfoGroupsLabel;
	JLabel anotherInfoGroupsLabel;
	
	JLabel chooseList;
	
	JLabel searchLabel;
	JLabel settingLabel;
	
	JTextField searchText;

	Color lightest = new Color(46,110,180);
	Color light = new Color(33,82,138);
	Color darkest = new Color(29,72,121);
	
	public String msg;
	JPanel main;
	
	TeamVO anotherVO = new TeamVO();
	TeamVO localVO;
	
	public TeamVSTopPanel(JPanel middle){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,197);
		this.setBackground(Color.WHITE);
		setLocalTeamPhotoLabel();
		setAnotherTeamPhotoLabel();
		setVSUpLabel();
		setVSDownLabel();
		setLocalInfoGroupsLabel();
		setAnotherInfoGroupsLabel();
		settingLabel();
	}
	
	public void setAttri(String name){
		PlayerDataService pds = new PlayerData_stub();
		PlayerVO voL = pds.avgLeague(); 
		PlayerVO voP = pds.findPlayerData(name); 
		vo = voP;
		setTopPanel(voP);
		player.add(voP.avgPoint);player.add(voP.avgRebound);player.add(voP.avgAssist);
		player.add(voP.three);player.add(voP.penalty);
		leagueAvg.add(voL.avgPoint);leagueAvg.add(voL.avgRebound);leagueAvg.add(voL.avgAssist);
		leagueAvg.add(voL.three);leagueAvg.add(voL.penalty);
		//"年度","球队","场数","先发","分钟","％","三分％","罚球％",
		//"进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"
		avg.add("2012-2013");avg.add(voP.team);avg.add(voP.numOfGame+"");avg.add(voP.start+"");avg.add(voP.avgMinute+"");avg.add(voP.shot+"");avg.add(voP.three+"");
		avg.add(voP.penalty+"");avg.add(voP.avgOffend+"");avg.add(voP.avgDefend+"");avg.add(voP.avgRebound+"");avg.add(voP.avgAssist+"");avg.add(voP.avgSteal+"");
		avg.add(voP.avgBlockShot+"");avg.add(voP.avgFault+"");avg.add(voP.avgFoul+"");avg.add(voP.avgPoint+"");
		total.add("2012-2013");total.add(voP.team);total.add(voP.numOfGame+"");total.add(voP.start+"");total.add(voP.minute+"");total.add(voP.shot+"");total.add(voP.three+"");
		total.add(voP.penalty+"");total.add(voP.offend+"");total.add(voP.defend+"");total.add(voP.rebound+"");total.add(voP.assist+"");total.add(voP.steal+"");
		total.add(voP.blockShot+"");total.add(voP.fault+"");total.add(voP.foul+"");total.add(voP.point+"");
		itemsNeedAdd.add("场均得分");
		itemsNeedAdd.add("场均助攻");
		itemsNeedAdd.add("场均篮板"); 
		itemsNeedAdd.add("三分％"); 
		itemsNeedAdd.add("罚球％");

	}

	
	public void setLocalTeamPhotoLabel (){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(300,-5,230,150);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		this.add(localTeamPhotoLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/BOS.png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(730,-5,230,150);
		anotherTeamPhotoLabel.setBackground(Color.WHITE);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
		this.add(anotherTeamPhotoLabel);
	}

	public void setLocalInfoGroupsLabel(){
		localInfoGroupsLabel = new JLabel();
		localInfoGroupsLabel.setBounds(0,145,535,55);
		localInfoGroupsLabel.setOpaque(true);
		localInfoGroupsLabel.setBackground(light);

		JLabel playerName = new JLabel("亚特兰大",JLabel.RIGHT);
		playerName.setFont(new Font("Dialog",1,13));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(335,5,180,15);
		localInfoGroupsLabel.add(playerName);
		
		JLabel playerPos = new JLabel("凯尔特人",JLabel.RIGHT);
		playerPos.setFont(new Font("Dialog",1,18));
		playerPos.setForeground(Color.WHITE);
		playerPos.setBounds(415,20,100,30);
		localInfoGroupsLabel.add(playerPos);

		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(715,145,565,55);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(light);
		
		JLabel anotherName = new JLabel("波士顿",JLabel.LEADING);
		anotherName.setFont(new Font("Dialog",1,13));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(15,5,180,15);
		anotherInfoGroupsLabel.add(anotherName);
		
		JLabel anotherPos = new JLabel("凯尔特人");
		anotherPos.setFont(new Font("Dialog",1,18));
		anotherPos.setForeground(Color.WHITE);
		anotherPos.setBounds(15,20,180,30);
		anotherInfoGroupsLabel.add(anotherPos);

		this.add(anotherInfoGroupsLabel);
	}
	
	public void settingLabel(){
		settingLabel = new PhotoLabel(new ImageIcon("setting.png").getImage());
		settingLabel.setBounds(525,13,25,25);
		settingLabel.setBackground(light);
		settingLabel.setOpaque(true);
		settingLabel.setVisible(true);
		settingLabel.addMouseListener(new MouseAdapter()
		{	
			int select = 0;
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				select += 1;
				if(select%2 == 1){
					searchLabel.setVisible(true);
				}else{
					searchLabel.setVisible(false);
				}
			}
		});
		anotherInfoGroupsLabel.add(settingLabel);
	}

	public void setSearchLabel(){
		searchLabel = new JLabel();
		searchLabel.setBounds(950,100,330,45);
		searchLabel.setBackground(Color.LIGHT_GRAY);
		searchLabel.setOpaque(true);

		searchText = new JTextField();
		searchText.setBounds(5, 5, 340, 35);
		searchText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				System.out.println(searchText.getText());
				msg = searchText.getText();
//				System.out.println("AAAAAAAAAAA" + msg);
				ArrayList<PlayerVO> list = new ArrayList<PlayerVO>();
				PlayerDataService pds = new PlayerData_stub();
				list = pds.findPlayers(msg);
				setChooseList(list);
				main.add(chooseList,0);
				main.setVisible(true);
			}
		});
		searchLabel.add(searchText);
		this.add(searchLabel,0);
		
	}
	
	public void setChooseList(ArrayList<PlayerVO> list){
		chooseList = new JLabel();
		chooseList.setBounds(950, 145, 330, 50*list.size());
		chooseList.setLayout(new GridLayout(list.size(),1,0,0));
		chooseList.setBackground(Color.LIGHT_GRAY);
		chooseList.setOpaque(true);
		for(int i = 0; i < list.size(); i++){
			JLabel item = new JLabel();
			item.setSize(280, 50);
			item.setBackground(Color.WHITE);
			item.setOpaque(true);

			JLabel name = new JLabel(list.get(i).name,JLabel.LEADING);
			name.setBounds(100,0,100,50);
			name.setForeground(darkest);
			name.setBackground(Color.white);
			name.setOpaque(true);
			item.add(name);
			
			JLabel photo = new PhotoLabel(new ImageIcon("portrait/" + list.get(i).photo + ".png").getImage());
			photo.setBounds(10,0,80,50);
			photo.setBackground(Color.WHITE);
			photo.setOpaque(true);
			photo.setVisible(true);
			item.add(photo);
			
			name.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					TeamVSTopPanel.this.setVisible(false);
					PlayerDataService pds = new PlayerData_stub();
					anotherVO = pds.findPlayerData(name.getText()); 
										
					if(anotherPlayerPhotoLabel != null){
						remove(anotherPlayerPhotoLabel);
					}
					if(anotherTeamPhotoLabel != null){
						remove(anotherTeamPhotoLabel);
					}
					if(anotherInfoGroupsLabel != null){
						remove(anotherInfoGroupsLabel);
					}
					setAnotherInfoGroupsLabel();
					setAnotherPlayerPhotoLabel();
					setAnotherTeamPhotoLabel();
					chooseList.setVisible(false);
					PlayersVSTopPanel.this.setVisible(true);
					PlayersVSTopPanel.this.repaint();

					ArrayList<Double> local = new ArrayList<Double>();
					ArrayList<Double> another = new ArrayList<Double>();
					local.add(localVO.avgPoint);local.add(localVO.avgRebound);local.add(localVO.avgAssist);
					local.add(localVO.three);local.add(localVO.penalty);
					another.add(anotherVO.avgPoint);another.add(anotherVO.avgRebound);another.add(anotherVO.avgAssist);
					another.add(anotherVO.three);another.add(anotherVO.penalty);
					
					main.setVisible(false);
					main.remove(main.getComponentAt(new Point(30,300)));
					((PlayerMiddlePanel) main).setVSPanel(local,another);
					main.setVisible(true);

				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			chooseList.add(item);
		}
		chooseList.setVisible(true);
//		this.add(chooseList,0);
//		main.add(chooseList,0);

	}


	public void setVSUpLabel(){
		VSUpLabel = new JLabel("球队对比",JLabel.CENTER);
		VSUpLabel.setFont(new Font("Dialog",1,30));
		VSUpLabel.setForeground(Color.GRAY);
		VSUpLabel.setBounds(535,35,180,60);
		this.add(VSUpLabel);
	}

	public void setVSDownLabel(){
		VSDownLabel = new JLabel("VS",JLabel.CENTER);
		VSDownLabel.setFont(new Font("Dialog",1,30));
		VSDownLabel.setForeground(Color.WHITE);
		VSDownLabel.setBackground(lightest);
		VSDownLabel.setOpaque(true);
		VSDownLabel.setBounds(535,145,180,55);
		this.add(VSDownLabel);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(1280,700);
		jf.setLocationRelativeTo(null);
		jf.add(new TeamVSTopPanel());
		jf.setVisible(true);
	}

}
