package godVille;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GeographyGUI{
	
	//private String[] start = {"Plains", "Highlands", "Coastal"};
	private String[] gcreate = {"Mountain Range", "River", "Lake", "Forest"};
	private ImageIcon mtn = new ImageIcon("C:\\Users\\starl\\workspace\\Rico Challenges\\src\\godVille\\mountain.jpg");
	
	public boolean mtnrng = false;
	public boolean river = false;
	public boolean lake = false;
	public boolean forest = false;
	
	public GeographyGUI(){
	}
	
	public void died(){
		Image remtn = mtn.getImage();
		Image newmtn = remtn.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		mtn = new ImageIcon(newmtn);
		int choice = JOptionPane.showOptionDialog(null, "What geographical feature would you like to create?", "Geography Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, mtn, gcreate, gcreate[0]);
		if(choice==0){
			getMountain();
		}
		else if(choice==1){
			getRiver();
		}
		else if(choice == 2){
			getLake();
		}
		else if(choice==3){
			getForest();
		}
	}
	
	public boolean getMountain(){
		return mtnrng = true;
	}
	
	public boolean getRiver(){
		return river = true;
	}
	
	public boolean getLake(){
		return lake = true;
	}
	
	public boolean getForest(){
		return forest = true;
	}
	
	public void resetbomb(){
		mtnrng = false;
		river = false;
		lake = false;
		forest = false;
	}
	

}
