package godVille;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GodActions extends JDialog{

	//Has ArrayList of potential outcomes of speech nd stuff
	//Randomly generated, needs flags to add into potential options.
	
	GeographyGUI geoUI = new GeographyGUI();
	JDialog menu = new JDialog();
	
	public boolean medicine = false;
	public boolean dprotect = false;
	public boolean military = false;
	public boolean fertile = false;
	
	private ArrayList<String> Bspeech = new ArrayList<String>();
	private ArrayList<String> movespeech = new ArrayList<String>();
	private ArrayList<String> influspeech = new ArrayList<String>();
	private ArrayList<String> ndoptions = new ArrayList<String>();
	private ArrayList<String> weatherop = new ArrayList<String>();
	private ArrayList<String> smitespeechpos = new ArrayList<String>();
	private ArrayList<String> smitespeechneg = new ArrayList<String>();
	
	
	private ImageIcon kami = new ImageIcon("C:\\Users\\starl\\workspace\\Rico Challenges\\src\\godVille\\god.jpg");
	private ImageIcon kami2 = new ImageIcon("C:\\Users\\starl\\workspace\\Rico Challenges\\src\\godVille\\yo.gif");
	
	public int bp = 5;
	public int mood = 10;

	private JButton end;
	private JButton commb;
	private JButton commf;
	private JButton move;
	private JButton geo;
	private JButton advance;
	
	private JButton weather;
	private JButton bless;
	private JButton smite;
	private JButton nd;
	private JButton create;
	private JButton puri;
	
	private JLabel text = new JLabel("O God, what is your will?");
	private JLabel text2 = new JLabel("Show them the wrath of the Gods!");
	private JLabel pic;
	private JLabel pic2;
	
	JDialog dead;
	
	
	public GodActions(){
		super(null, ModalityType.APPLICATION_MODAL);
		setModal(true);
		initiate();
		
	}
	

	public void initiate(){
		//frame = new JFrame();
		//panel1 = new JPanel();
		setLayout(null);
		text.setBounds(130, 0, 400, 100);
		text.setFont(new Font("Serif", Font.PLAIN, 24));
		add(text);
		
		Image remtn = kami.getImage();
		Image newmtn = remtn.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		kami = new ImageIcon(newmtn);
		pic = new JLabel(kami);
		pic.setBounds(165,70,120,120);
		
		
		end = new JButton("Armageddon");
		end.setBounds(160-20, 120+60, 170+30, 40);
		endact();
		
		commb = new JButton("Impart wisdom to the Bishop");
		commb.setBounds(160-20, 160+60, 170+30, 40);
		bact();
		
		commf = new JButton("Guide followers");
		commf.setBounds(160-20, 200+60, 170+30, 40);
		cact();
		
		move = new JButton("Influence followers");
		move.setBounds(160-20, 240+60, 170+30, 40);
		moveact();
		
		geo = new JButton("Shape the Earth");
		geo.setBounds(160-20, 280+60, 170+30, 40);
		geoact();
		
		advance = new JButton("Holistic Actions");
		advance.setBounds(160-20,320+60,170+30,40);
		advance.setEnabled(false);
		
		add(end);
		add(commb);
		add(commf);
		add(move);
		add(geo);
		add(pic);	
		
		if(bp==0){
			end.setEnabled(false);
			commb.setEnabled(false);
			commf.setEnabled(false);
			move.setEnabled(false);
			geo.setEnabled(false);
		}
		setTitle("God's Will");
		setSize(500,500);
	}


	private void ndact() {
		fillnd();
		nd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				int i = r.nextInt(ndoptions.size()-1);
				JOptionPane.showMessageDialog(null, ndoptions.get(i));
				subtract10(bp);
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
		
	}

	private void fillnd() {
		ndoptions.add("Typhoon");
		ndoptions.add("Blizzard");
		ndoptions.add("Flood");
		ndoptions.add("Hurricane");
		ndoptions.add("Tornado");
		
	}

	private void smiteposact() {
		fillSmitepos();
		smite.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Random i = new Random();
				
				//CHANGE THIS NUMBER LATER :D
				int r = i.nextInt(smitespeechpos.size()-1);
				System.out.println(r);
				JOptionPane.showMessageDialog(null, smitespeechpos.get(r));
				if(mood==10){
					mood = 10;
				}
				else{
					mood++;
				}
				subtract10(bp);
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
				
			}
			
		});
		
	}
	
	private void smitenegact(){
		fillSmiteneg();
		smite.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Random i = new Random();
				
				//CHANGE THIS NUMBER LATER :D
				int r = i.nextInt(smitespeechneg.size()-1);
				System.out.println(r);
				JOptionPane.showMessageDialog(null, smitespeechneg.get(r));
				mood--;
				subtract10(bp);
				System.out.println(bp);
				
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
	}

	private void blessact() {
		bless.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "You have given your blessings unto the wonderful world!" +
													"\n(English Translation: The Lands are now fertile.)");
				subtract10(bp);
				mood++;
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
	}

	private void weaact() {
		fillwea();
		weather.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				int i = r.nextInt(weatherop.size()-1);
				JOptionPane.showMessageDialog(null, weatherop.get(i));
				subtract10(bp);
				f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
				
			}
			
		});
		
	}

	private void fillwea() {
		weatherop.add("Feeling a bit generous, you have made the skies sunny!"); //MOOD++
		weatherop.add("The skies sudden darken, a deluge of water pours from the dark canopy. Looks like this rain is here to stay for a while."); //RAIN TURN COUNTER?
		weatherop.add("The gale bellows, as if a typhoon is forming. Followers move to pin down what they can." +
				"\nThe bishop prays to you to calm the wind spirits.");
		
	}

	private void geoact() {
		geo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				subtract(bp);
				geoUI.geoMenu();
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
	}

	private void moveact() {
		fillMove();
		move.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//String words = JOptionPane.showInputDialog("What holy words will you bestow upon your people?");
				subtract(bp);
				Random r = new Random();
				int i = r.nextInt(movespeech.size()-1);
				JOptionPane.showMessageDialog(null, movespeech.get(i));
				if(i%2==0){
					mood--;
				}
				else{
					mood++;
				}
				
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
				
			}
			
		});
		
	}

	private int cact() {
		fillCommf();	
		commf.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String words = JOptionPane.showInputDialog("What holy words will you bestow upon your people?");
				subtract(bp);
				Random r = new Random();
				int i = r.nextInt(influspeech.size()-1);
				if(words.contains("herb")){
					JOptionPane.showMessageDialog(null, "The follower feels suddenly compelled to skirt around the fields." +
														"\nShe finds some unique herbs while there, and believes them to be God's guidance." +
														"\nThe villagers gain a surplus of herbs they know nothing of...");
					medicine = true;
				}
				else if(words.contains("bless") || words.contains("pray") || words.contains("god") || words.contains("God")){
					JOptionPane.showMessageDialog(null, "While you may thrive off of the prayers of the church," +
														"\nthe average person's prayers work just as well." +
														"\nThis particular prayer seemed to tug at your pity for some reason." +
														"\nYou grace the city with your divine protection once again, the original" +
														"\nhaving long distintegrated.");
					dprotect = true;
				}
				else if(words.contains("farm") || words.contains("fertility") || words.contains("harvest") || words.contains("food") || words.contains("FOOD")){
					JOptionPane.showMessageDialog(null, "The people decide that now is the day, as dictated by God to...");
					
					JOptionPane.showMessageDialog(null, "Celebrate the land! They thank you and celebrate the bountiful harvests." +
														"\nFor your part, you just make the land more fertile. It's not likely to experience" +
														"\na sad harvest for a long while.");
					
					fertile = true;
				}
				else{
					JOptionPane.showMessageDialog(null, influspeech.get(i));
				}
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
				
			}
			
		});
		return subtract(bp);
	}

	private int bact() {
		fillCommb();
		commb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String words = JOptionPane.showInputDialog("What holy words will you bestow upon your most devout follower?");
				if(words.equalsIgnoreCase("fuck") || words.contains("shit")){
					JOptionPane.showMessageDialog(null, Bspeech.get(2));
					mood--;
				}
				else if(words.contains("gay")){
					JOptionPane.showMessageDialog(null, "Upon hearing your words, the bishop thanks you for wishing him" +
														"\na happy and joyous life. Or was it supposed to mean something else?");
					mood++;
				}
				else if(words.contains("medicine") || words.contains("herb") || words.contains("health")){
					JOptionPane.showMessageDialog(null, "The bishop ponders for a bit. He feels a strong urge to stockpile on medicines." +
														"\nLater, a fellow follower discovered some herbs, claiming that God had told him this herb" +
														"\nwould save the lives of many.");
					medicine = true;
				}
				else if(words.contains("divine") || words.contains("protection") || words.contains("pray") || words.contains("bless")){
					JOptionPane.showMessageDialog(null, "The bishop decides to lead a circle of prayers to you." +
														"\nOn a whim, you decide to grace them with more divine protection." +
														"\nMore protection is always a good thing. It does little for sights better left unseen though." +
														"\nOnly eye bleach can fix that.");
					dprotect = true;
				}
				else if(words.contains("military") || words.contains("fight") || words.contains("army") || words.contains("weapon")){
					JOptionPane.showMessageDialog(null, "At what he believes to be the behest of his God, the bishop goes to tell the" +
														"\ncountry's leaders to improve their defenses and military. While confused," +
														"\nthey choose not to question your divine will.");
					military = true;
					
				}
	
				else{
					Random r = new Random();
					int i = r.nextInt(Bspeech.size()-1);
					JOptionPane.showMessageDialog(null, Bspeech.get(i));
				}
				//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
		return subtract(bp);
		
	}

	private void endact() {
		
		end.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have come to a decision. The people of this world are irredeemable.");
				
				JOptionPane.showMessageDialog(null, "They have strayed too far from your grace, your guidance." +
													"\nTheir arts are a disgrace to your name. Their science is but a mockery, a pale imitation of the genuine branch." +
													"\nThey clash and fight amongst each other despite your best attempts to listen to their pleas and answer them." +
													"\nThey cry for blood, they cry tears of sorrow when blood has shed." +
													"\nThe teachings of compassion superficially reach them." +
													"\nTheir repentance is but a farce." +
													"\nThere is no other choice, though your heart grieves for the failure of your children." +
													"\nLet this tragic tale continue no further.");
				
				JOptionPane.showMessageDialog(null, "Alternatively, you are tired of being a glorified babysitter.");
				
				JOptionPane.showMessageDialog(null, "And so the tale ends.");
				System.exit(0);
				
			}
			
		});
	}	

//-------------------------------------------------------------------------
	private void fillSmitepos(){
		smitespeechpos.add("Displaying your displeasure and strength, you toss down a lightning bolt at the sinners who smear your name." +
							"\nTheir agonizing cries are heard, and the people worship your righteous judgement." +
							"\nTheir belief in you grows stronger, the divine Judge.");
		smitespeechpos.add("While making yourself some coffee, one of your lightning bolts seemed to have fallen from the sky." +
							"\nIt was a direct hit on a group of devout worshippers." +
							"\nThe bishop announces that the group must have done nefarious, clandestine actions unbeknownst to the public." +
							"\nThey praise your precise judgement. You bask in the planned glory.");
		smitespeechpos.add("You saw some neighborhood brats vandalizing your favorite statue of your glorious image." +
							"\nNot wanting to be the joke of the Gods, you turn the stunt into one of fame and publicity." +
							"\nShowing your infinite wisdom, you smack the kids with an assortment of nearby objects such as their own buckets." +
							"\nThe parents thank you for the mercy of their insolent children and proceed to scold them." +
							"\nFeels great being on the end that's not being scolded.");
		smitespeechpos.add("It has been some time since you have punished the people. Though, your clergy has certainly performed well for you." +
							"\nTo actually get onto the godly action, you decided to deliver judgement upon the people." +
							"\nCause you clearly can't trust your followers to deliver justice with 100% certaincy like you can." +
							"\nNews breaks out that some prisoners faced divine punishment overnight. The people praise you." +
							"\nThey sacrifice a horse in your name. You aren't sure to call them fanatic or thank their devotion.");
		smitespeechpos.add("On a whimsical look, you notice a battle underway. It seems your followers were engaged in a skirmish." +
							"\nYou notice that the opposition of of another faith, a rather tempermental one. What kind of Holy Being" +
							"\nwould you be if you didn't assist in this case? You know that God never helps out his people, a barbaric one." +
							"\n" +
							"\nAfter the battle, your brave warriors sing praises of your name for watching over their exploits.");
		
	}
	
	private void fillSmiteneg(){
		smitespeechneg.add("It's been a rather dreary decade as your people seem to veer away from pious pursuits." +
							"\nIt seems that a little punishment is in order. You decide to whip some of your high clergy over into some faraway land." +
							"\nLet them be declared some uncouth barbarians. Wait did you toss them into the future?" +
							"\nEh, oh well. " +
							"\n" +
							"\nThe clergy mourns the loss of these followers. They call you a temperamental mistress, a demoness that has forgotten the meaning of mercy.");
		smitespeechneg.add("In a particularily bad mood, you decided to cause a drought to some distant villagers." +
							"\nThey're far from the centers of activities, so news of such shouldn't reach the centers." +
							"\nUnfortunately, your followers have developed much transportation technology you have not heard of." +
							"\nThe priests attemp to assauge the hatred that comes from a sudden drought caused by your pettiness." +
							"\nTheir efforts are partially successful, but the people's idolization of you has faded.");
		smitespeechneg.add("Even gods make mistakes sometimes, it just so happens that people are really judgemental!" +
							"\nAs the country faces infertile land, they turn to conquest to get more land from their neighbors." +
							"\nDuring such conquests, you decided to help them out a little, and totally not out of vengeance on the other people's faith." +
							"\nTurns out flooding the enemy cities only enraged the troops to crush your superior forces. Oops." +
							"\nThe opposing god laughs at your failure as your followers lose hope in your guidance." +
							"\nHey wait! You never told them to go conquer stuff!");
		smitespeechneg.add("You notice some official looking bloke coming over to the city. However, you notice that he seems to be trailed by some hefty army." +
							"\nCertainly, it must be a cowardly sneak attack!" +
							"\nAs the protectorate of the city of Arad, (and eager to regain the people's happiness and belief), you cause a massive tornado to spawn onto the attackers." +
							"\nThe morons and his leader die and the tornado subsides. Feeling rather giddy, you retire for the week to see how/when the people realize" +
							"\nyour glorious deed." +
							"\n" +
							"\nMeanwhile, the officials of Arad face growing tensions with their neighbors as the supposed joint military parade never happens." +
							"\nTheir army depleted, the neighbors no longe consider Arad an ally. Your careless destruction might've" +
							"\ncaused your destruction.");
		smitespeechneg.add("After a Godly council where a law was passed to restrict the usage of killing the people, you were in a rather bad mood." +
							"\nCurses to the human-loving faction, always trying to baby their followers. Well, you disagree with their policies." +
							"\nTo show disapproval, you decided to go around in a (vigilante) spree of divine retribution. The people cower in fear." +
							"\nThe policy is later rescinded when other gods follow your example and the rest are powerless to stop this." +
							"\nYour ruthlessness knows no ends.");
	}
	
	private void fillCommb(){
		Bspeech.add("The high bishop feels as if he heard a whisper in the wind. He shrugs it off. ");
		Bspeech.add("Did he just hear his Almighty Goddess/God curse him? Must've heard wrong. Certainly," +
					"\nhe's done nothing to deserve such judgement.");
		Bspeech.add("If the Almighty is having a rough day, it is the job of the bishop who delivers Her/His words" +
					"\nto..." +
					"\nPretend he never heard such vulgar and crude language come from their tongue!");
		Bspeech.add("'O God, what message do you want this one to deliver to your people?' the bishop pleads as he wonders" +
					"\nabout the influx of these vague, barely noticeable whispers.");
		Bspeech.add("Believing he had just gotten a revelation, the bishop gets on his knees and prays to you." +
					"\nHe thanks you for the blessing you have bestowed upon the people.");
		Bspeech.add("Your bishop just ignored you! The nerve!");
	}
	
	private void fillCommf(){
		influspeech.add("You tried to flirt with a rather pretty follower. They don't respond. " +
						"\nIs this the meaning of love the mortals talk about so much?");
		influspeech.add("Seeing some followers on the verge of despair, you hope to whisper words of hope to them." +
						"\nIt doesn't appear they heard it very well. Oh well, at least they didn't come to see you early.");
		influspeech.add("Some idiot insisted on doing some sort of all-nighter. What a fool." +
						"\nWith some divine nagging, you manage to get him to sleep. That man better be more devout in the future." +
						"\nHis fate would've been a pathetic death, a heart attack for imagining a tractor was a car.");
		influspeech.add("Some people were going about their everyday lives and you were pretending to join in for the funsies." +
						"\nMight've knocked down some people with the wind. Oops. That merry group is now convinced some" +
						"\nevil spirits are in the down. Exorcists are called and salt is brough out. Well...you invigorated trade.");
		influspeech.add("Feeling a little left out after the people had a harvest fest, you decided to give them a little nudge." +
						"\nA god needs to feel appreciated too sometimes. Your incessant nudging might've been too much." +
						"\nThe overzealous bishop created 10 festivals in your name after the people reported a festive urge to" +
						"\nhonor your great name. Even if you just smited his successor. Eh, it'll stop soon enough.");
		influspeech.add("Some gods were challenging your powers. To fight him back, you tried to urge a follower to jump into the lake." +
						"\n....He flopped around on the ground like he was a fish and was immediately quarantined. " +
						"\nIt's the fate of the people to live for their Gods! His sacrifice was totally not in vain.");
		influspeech.add("You slighly nudged some people to entertain you. The workforce seems to be smaller, but the" +
						"entertainment sector is booming with new talents. Praise the Lord for the creation of all the big hits.");
		influspeech.add("You try to nudge a follower into choosing a certain flavor. He chose the another one. Rude." +
						"\nYou make sure to promote the glorious flavor of chocolate later.");
	}
	
	private void fillMove(){
		movespeech.add("An object was falling so you decided to fiddle with it and stop it from falling. It's now awkwardly hanging there." +
						"\nQuite happy that you prevented the catatrophic fall of pottery, you briefly let go of your control to bask in glory." +
						"\nIt fell. ");
		movespeech.add("The random rural farmer now believes his scarecrow is possessed. Then again, is there such thing as good possession?" +
						"\nCause the annoying birds are now cleansed of his fields.");
		movespeech.add("That used to look precious. Now it's just an amalgamation of a bunch of tiny parts. Much better." +
						"\nNothing should look at amazing as you do.");
		movespeech.add("Some sculptor was attempting to capture your glorious visage. His hands weren't rather skilled." +
						"\nThe chiseling needed some work so you smashed the stone with a hammer lying about." +
						"\nThat might have split your image in half. Oops. Let this be a warning to future sculptors.");
		movespeech.add("A monster invasion?! Where? Oh, it's just some children dressed up. Must be that time of the year." +
						"\nThe children get spooked by the levitating candy. You wonder if they'll continue eating such delicacies now." +
						"\nIf they don't, it's all yours after all. If a candy demonizing campaign was launched, would you get all the candy in the world?");
		movespeech.add("Apparently messing around with some random object does magic. " +
						"\nThe witnesses decided it was a warning from you and promptly banned the use of cups." +
						"\nDo buckets count as cups if they don't have a handle?");
	}
	
	private int subtract(int bp){
		return bp--;
	}
	
	private int subtract10(int bp){
		return bp-=10;
	}
	
	public void setup(){
		//JButton obj = (JButton) e.getSource();
		menu.setLayout(null);
		setVisible(false);
		
		text2.setBounds(70, -20, 400, 100);
		text2.setFont(new Font("Serif", Font.PLAIN, 24));
		Image remtn2 = kami2.getImage();
		Image newmtn2 = remtn2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		kami2 = new ImageIcon(newmtn2);
		pic2 = new JLabel(kami2);
		pic2.setBounds(165,30,150,150);
		
		weather = new JButton("Command the Skies");
		weather.setBounds(160-20, 120+60, 170+30, 40);
		weaact();
		
		bless = new JButton("Grace the lands");
		bless.setBounds(160-20, 160+60, 170+30, 40);
		blessact();
		
		smite = new JButton("Divine Judgement");
		smite.setBounds(160-20, 200+60, 170+30, 40);
		if(mood <=5){
			smitenegact();
		}
		else if (mood>5){
			smiteposact();
		}
		
		nd = new JButton("Anger of the Almighty");
		nd.setBounds(160-20, 240+60, 170+30, 40);
		ndact();
		
		create = new JButton("The Gift of Life");
		create.setBounds(160-20, 280+60, 170+30, 40);
		//createact();
		if(bp<1000){
			create.setEnabled(false);
		}
		
		puri = new JButton("Cleanse the lost lambs");
		puri.setBounds(160-20,320+60,170+30,40);
		puri.setEnabled(false);
		
		if(bp<10){
			weather.setEnabled(false);
			bless.setEnabled(false);
			smite.setEnabled(false);
			nd.setEnabled(false);
			create.setEnabled(false);
			puri.setEnabled(false);
		}
		
		menu.add(pic2);
		menu.add(text2);
		menu.add(weather);
		menu.add(bless);
		menu.add(smite);
		menu.add(nd);
		menu.add(create);
		menu.add(puri);
		
		//add(panel2);	
		menu.setSize(500, 500);
	}
	
	
	
}
