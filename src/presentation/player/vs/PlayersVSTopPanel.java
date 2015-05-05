package presentation.player.vs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import vo.playervo.PlayerVO;


public class PlayersVSTopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel localPlayerPhotoLabel;
	JLabel anotherPlayerPhotoLabel;
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

	public PlayersVSTopPanel(JPanel middle){
		this.setLayout(null);
		this.setBounds(0, 0, 1280,197);
		this.setBackground(Color.WHITE);
		setLocalPlayerPhotoLabel();
		setAnotherPlayerPhotoLabel();
		setLocalTeamPhotoLabel();
		setAnotherTeamPhotoLabel();
		setVSUpLabel();
		setVSDownLabel();
		setLocalInfoGroupsLabel();
		setAnotherInfoGroupsLabel();
		setSearchLabel();
		searchLabel.setVisible(false);
		this.main = middle;
		
		
//		ArrayList<PlayerVO> list = new ArrayList<PlayerVO>();
//		PlayerDataService pds = new PlayerData_stub();
//		list = pds.findPlayers(searchText.getText());
//		setChooseList(list);
	}
	
	public void setLocalPlayerPhotoLabel (){
		localPlayerPhotoLabel = new PhotoLabel(new ImageIcon("1.png").getImage());
		localPlayerPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localPlayerPhotoLabel.setBounds(300,-5,230,150);
		localPlayerPhotoLabel.setBackground(Color.WHITE);
		localPlayerPhotoLabel.setOpaque(true);
		localPlayerPhotoLabel.setVisible(true);
		this.add(localPlayerPhotoLabel);
	}
	
	public void setLocalTeamPhotoLabel (){
		localTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		localTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		localTeamPhotoLabel.setBounds(140,-10,250,120);
		localTeamPhotoLabel.setBackground(Color.WHITE);
		localTeamPhotoLabel.setOpaque(true);
		localTeamPhotoLabel.setVisible(true);
		this.add(localTeamPhotoLabel);
	}

	public void setVSUpLabel(){
		VSUpLabel = new JLabel("球员对比",JLabel.CENTER);
		VSUpLabel.setFont(new Font("Dialog",1,30));
		VSUpLabel.setForeground(Color.GRAY);
		VSUpLabel.setBounds(535,35,180,60);
		this.add(VSUpLabel);
	}
	
	public void setAnotherTeamPhotoLabel (){
		anotherTeamPhotoLabel = new PhotoLabel(new ImageIcon("teamsPNG/ATL.png").getImage());
		anotherTeamPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherTeamPhotoLabel.setBounds(955,-10,250,120);
		anotherTeamPhotoLabel.setBackground(Color.WHITE);
		anotherTeamPhotoLabel.setOpaque(true);
		anotherTeamPhotoLabel.setVisible(true);
		this.add(anotherTeamPhotoLabel);
	}

	public void setAnotherPlayerPhotoLabel (){
		anotherPlayerPhotoLabel = new PhotoLabel(new ImageIcon("1.png").getImage());
		anotherPlayerPhotoLabel.setHorizontalAlignment(JLabel.RIGHT);
		anotherPlayerPhotoLabel.setBounds(730,-5,230,150);
		anotherPlayerPhotoLabel.setBackground(Color.WHITE);
		anotherPlayerPhotoLabel.setOpaque(true);
		anotherPlayerPhotoLabel.setVisible(true);
		this.add(anotherPlayerPhotoLabel);
	}
		
	public void setLocalInfoGroupsLabel(){
		localInfoGroupsLabel = new JLabel();
		localInfoGroupsLabel.setBounds(0,145,535,55);
		localInfoGroupsLabel.setOpaque(true);
		localInfoGroupsLabel.setBackground(light);

		JLabel playerNum = new JLabel("4",JLabel.CENTER);
		playerNum.setFont(new Font("Dialog",1,30));
		playerNum.setForeground(Color.WHITE);
		playerNum.setBackground(darkest);
		playerNum.setOpaque(true);
		playerNum.setBounds(0,0,100,60);
		localInfoGroupsLabel.add(playerNum);

		JLabel playerName = new JLabel("Jordan-Adams",JLabel.CENTER);
		playerName.setFont(new Font("Dialog",1,18));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(355,5,180,30);
		localInfoGroupsLabel.add(playerName);
		
		JLabel playerPos = new JLabel("前锋"+" / "+"纽约",JLabel.CENTER);
		playerPos.setFont(new Font("Dialog",1,13));
		playerPos.setForeground(Color.WHITE);
		playerPos.setBounds(390,32,180,15);
		localInfoGroupsLabel.add(playerPos);

		this.add(localInfoGroupsLabel);
	}
	
	public void setAnotherInfoGroupsLabel(){
		anotherInfoGroupsLabel = new JLabel();
		anotherInfoGroupsLabel.setBounds(715,145,565,55);
		anotherInfoGroupsLabel.setOpaque(true);
		anotherInfoGroupsLabel.setBackground(light);
		
		JLabel anotherNum = new JLabel("4",JLabel.CENTER);
		anotherNum.setFont(new Font("Dialog",1,30));
		anotherNum.setForeground(Color.WHITE);
		anotherNum.setBackground(darkest);
		anotherNum.setOpaque(true);
		anotherNum.setBounds(415,0,100,60);
		anotherInfoGroupsLabel.add(anotherNum);
		
		JLabel anotherName = new JLabel("Jordan-Adams");
		anotherName.setFont(new Font("Dialog",1,18));
		anotherName.setForeground(Color.WHITE);
		anotherName.setBounds(15,5,180,30);
		anotherInfoGroupsLabel.add(anotherName);
		
		JLabel anotherPos = new JLabel("前锋"+" / "+"纽约");
		anotherPos.setFont(new Font("Dialog",1,13));
		anotherPos.setForeground(Color.WHITE);
		anotherPos.setBounds(15,32,180,15);
		anotherInfoGroupsLabel.add(anotherPos);
		settingLabel();
		this.add(anotherInfoGroupsLabel);
	}
	
	public void settingLabel(){
		settingLabel = new PhotoLabel(new ImageIcon("setting.png").getImage());
//		settingLabel.setHorizontalAlignment(JLabel.RIGHT);
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
					// TODO Auto-generated method stub
					
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
//		jf.add(new PlayersVSTopPanel());
		jf.setVisible(true);
	}
}
