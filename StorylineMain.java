package godVille;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class StorylineMain {

	GodActions godMenu;
	Music track;
	private int health = 80;
	
	private ImageIcon image1 = new ImageIcon(getClass().getResource("icanr.jpg"));
		
	//private boolean lhp = true;
	
	private boolean plague = false;
	public int geowin = 0;
	public int milwin = 0;
	public int dwin = 0;
	public int pwin=0;
	
	
	public StorylineMain(){
		track = new Music();
		decade01();
		decade02();
		decade03();
		decade04();
		decade05();
		decade06();
		decade07();
		decade08();
		decade09();
		decade10();
		end();
	}


	private int decade01() {
		//Raiders
		track.bgm();
		JOptionPane.showMessageDialog(null, "It has been milleniums since you have last embarked on such a venture." +
											"\nWhile many gods have created and decimated followers on a whim...you have evaded such duties for milleniums..." +
											"\nWhatever the case may be, may your people be lead to prosperity." +
											"\nMay their small settlement become a sprawling metropolis one day, as many other" +
											"\nsuccess stories have.", "A God's Life", JOptionPane.PLAIN_MESSAGE, image1);
		
		JOptionPane.showMessageDialog(null, "...");
		JOptionPane.showMessageDialog(null, "It took some additional years before your followers have grown to a certain degree to be considered a 'following'." + 
											"\nThey reside near a lake, but surrounded by people who may be allies or foes. Their band is small, but faithful." +
											"\nFood is bountiful, water plentiful, and religious worship high. " +
											"\nWhat a fortuitous beginning! May they be blessed throughout!");
		
		JOptionPane.showMessageDialog(null, "Every 'turn' you will be able to perform Godly deeds. They will cost belief to perform," +
											"\nas a God's powers is derived from their worship. Some deeds will cost more than others." +
											"\nThe populace's mood will determine the amount of worship, and belief you will gain/have." +
											"\nIf there is no actions you want to take, or can take, simply press 'X'. (Lazy butt)" +
											"\nMay your people be blessed.");
		
		godMenu = new GodActions();
		godMenu.bp--;
		godMenu.setVisible(true);

		JOptionPane.showMessageDialog(null, "One fine morning, as the people gather and mill about their daily lives, raiders suddenly invade!");
		if(godMenu.geoUI.mtnrng){
			JOptionPane.showMessageDialog(null, "Luckily, the mountain range you have set up prevented the attack. The raiders flee to find more easy prey.");
			improvemood();
		}
		else if(godMenu.military){
			JOptionPane.showMessageDialog(null, "Your military might was powerful enough to build a strong force to resist the raiders!" +
												"\nThey'd probably be able to withstand a war years down the line!");
			improvemood();
		}
		else{
			JOptionPane.showMessageDialog(null, "The raiders strike hard and mercilessly. While some survive, many are slain on this day." +
												"\nThe survivors plead to you, begging why you could not save them. They ask for your protection." +
												"\nSome feel their faith waver. Others see it as a trial.");
			losemood();

			health-=10;
		}
		if(godMenu.mood>=5){
			godMenu.bp++;
		}
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		
		return health;
		
	}

	
	private int losemood(){
		return godMenu.mood--;
	}
	
	private int improvemood(){
		return godMenu.mood++;
	}
	
	private int decade02(){
		//God, unavoidable.
		JOptionPane.showMessageDialog(null, "Once the ordeal of the raiders have long past, normalcy has returned." +
											"\nCertainly, new structures are built and the people advance once more in their lives." +
											"You decide to entertain yourself a little.");
		
		godMenu= new GodActions();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		JOptionPane.showMessageDialog(null, "One day, once more, tragedy struck. Rivalry between gods is quite an unsightly thing." +
											"\nIn your negilence, a rival god caught wind of your new 'plaything' as they viewed it." +
											"\nThey move in to strike quick, while your attention is elswhere!");
		if(godMenu.dprotect==true){
			JOptionPane.showMessageDialog(null, "Turns out, that protection you put up on a whim helped defend against the God's petty attack." +
												"\nThe people thank you for your protection. The rival god flees in anger. It won't be the last of him.");
			improvemood();
		}
		else{
		
			JOptionPane.showMessageDialog(null, "By the time you come back, you find your tiny cultivation project in shambles, the perpetrator clear." +								"\nYou curse your inability and negilence. There will be revenge one day...hopefully.");
			losemood();
			health-=10;
		}
		if(godMenu.mood>=5){
			godMenu.bp++;
		}
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
		
	}
	
	private int decade03(){
		//plague
		JOptionPane.showMessageDialog(null, "The determination of humanity is stunning as your followers press on." +
											"\nIt must be the Will of the Gods to force us in such trials, you hear them excusing somedays." +
											"\nYou wonder if it's some sort of coping mechanism. Are you doing that badly?" +
											"\nPleased with the praises, you decide it's time to take a little action.");
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		JOptionPane.showMessageDialog(null, "Generations passed with peace and bliss. You welcome this change of pace after the chaotic beginnings." +
											"\nYour people have grown to stand against raiders. Gods no longer bother your small bubble;" +
											"\nthere's no fun in bothering more advanced people after all. It requires more effort to crush." +
											"\nRarely would there be a God after the infant years. Nonetheless, you are wary for any disturbances.");
		
		JOptionPane.showMessageDialog(null, "While there is no God, there are otherworldly ills you can do little to cure." +
											"\nWith the right circumstances, a deadly plague races across the continent." +
											"\nIt decimates the neighboring countries as well as your own rapidly." +
											"\nThe situation seems stable, but more and more will be dying as the years go by," +
											"\nthe plague resurfacing every couple months, maybe years.");
		
		if(godMenu.medicine==true){
			JOptionPane.showMessageDialog(null, "Luckily that herb supply your city found was quickly discoevered to have worked." +
												"\nA poor desperate soul had been rapidly consuming all the herb supplies without anyone's knowledge" +
												"\nonce he had fell sick. It was discovered that the curative properties were intense." +
												"\nYour city manages to gain riches selling this cure native to the city while also curing itself." +
												"\nUnfortunately, due to all the herbs he had eaten, the poor soul had come to be by your side early." +
												"\nAlas, may his soul be wiser in his next life.");
			health+=10;
			improvemood();
			pwin++;
		}
		else{
			JOptionPane.showMessageDialog(null, "Your followers are struck hard by this illness. They suffer and cry, but you can do" +
												"\nnothing to assist. You sit there powerlessly, wondering if you can direct them to a cure," +
												"\nif there is one at all. In the meanwhile, you can only pray that this manmand evil can" +
												"\ndissipate soon, or your civilization faces danger");
			losemood();
			plague = true;
			health-=10;
		}
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
		
	}
	
	private int decade04(){
		//War
		
		if(plague){
			JOptionPane.showMessageDialog(null, "Desperate times calls for desperate needs. Your people are suffering, you are powerless to stop it." +
												"\nThe crisis worsens when the leaders attempt to wage war, believing a neighbor hoards the cure." +
												"\nTry as you might to urge the leaders elseward, the bishop's plea falls onto deaf ears." +
												"\nIt seems all you can do is help your people succeed or face annhilation...");
			godMenu.initiate();
			godMenu.setVisible(true);
			godMenu.bp--;
			if(godMenu.geoUI.mtnrng || godMenu.geoUI.forest){
				JOptionPane.showMessageDialog(null, "The geography you have long created form a natural barrier for the protection of your followers." +
													"\nIt allows easy defense, although your people are on the offensive. The soldiers are at ease" +
													"\nknowing their homelands will be safe from the fierce fighting. It only motivates them to find the cute quicker.");
				improvemood();
				geowin++;
			}
			else if(godMenu.military){
				JOptionPane.showMessageDialog(null, "To your selfish relief, the followers seem able for this war. They are well equipped and don't" +
													"\nseem to be suffering much casualities. Perhaps that mobilization order was foresight..." +
													"\nWhat? Gods can't always see into the future. How many lives do you think they'd be seeing at once?" +
													"\nAnd why wouldn't they evade their own death if they always could?" +
													"\nYou wonder if there's any other assistance you can provide...");
			
				improvemood();
				milwin++;
			}
			else if(godMenu.dprotect){
				JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
													"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
													"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
													"\nMaybe it's your bias speaking this time around.");
				improvemood();
				dwin++;
			}
			else{
				JOptionPane.showMessageDialog(null, "The combined might of the plague and the invasion takes a toll on your people." +
													"\nThey seem ill-prepared for such a war, crippled by the plague too. The early" +
													"\nskirmishes are filled with heavy losses on both sides and a demoralizing mood" +
													"\ncan easily be felt." +
													"\nThe people's cries fall on deaf ears, for even an almighty being like you cannot" +
													"\nintervene in human conflicts directly and aid them in battle. Discreet aid though...");
				
				losemood();
				health-=10;
			}
			health-=10;
		}
		else{
			JOptionPane.showMessageDialog(null, "Fortuitously, the plague has been cured for your people. However, the world is not as fortunate." +
												"\nNeighboring countries disagree with the monopoly your followers have gained of the cure." +
												"\nAngered, they declare war for salvation. Your people are now engaged in a war of defense." +
												"\nThe woes to help your lost followers, only to incur the anger of another's!" +
												"\nDefense is the only option now, for you can only, albeit cruel, hope the plague rids the nation first.");
			
			godMenu.initiate();
			godMenu.setVisible(true);
			godMenu.bp--;
			
			if(godMenu.geoUI.mtnrng || godMenu.geoUI.forest){
				JOptionPane.showMessageDialog(null, "Luckily for your people, and to the dismay of the attackers, they find the city well protected." +
													"\nCertainly, some rural outskirts of the city fare damage, but the overall populace is safe from" +
													"\nthe attacking invaders. Thank your foresight for placing such fortifications.");
				improvemood();
				geowin++;
			}
			else if(godMenu.military){
				JOptionPane.showMessageDialog(null, "There might not be much of defensive terrain around, but your people are certainly well equipped." +
													"\nYou feel confident that in a war of attrition, you certainly have the upper hand here.");
				improvemood();
				milwin++;
			}
			else if(godMenu.dprotect){
				JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
													"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
													"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
													"\nMaybe it's your bias speaking this time around.");
				improvemood();
				dwin++;
			}
			else{
				JOptionPane.showMessageDialog(null, "In an ideal world, one may develop as they please, focusing on the fine arts or sciences." +
													"\nMaybe even in the best field of all, entertainment and the creation of crude arts." +
													"\nUnfortunately, this is no ideal world. Your people suffer for their lack of focus in the" +
													"\nmilitary arts. Improving them will go a long way for bearing out this attack. ");
				losemood();
				health-=10;
			}
			
			if(pwin==0){
				pwin++;
			}
		}
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade05(){
		//Food loss
		
		if(plague){
			JOptionPane.showMessageDialog(null, "The plague apparently recedes for a brief period, allowing for a somewhat successful offensive." +
												"\nIt does much to raise morale, but little to help you determine who will win this war..." +
												"\nNo doubt the plague will return once more if the people do not find a cure quickly." +
												"\nIs there anything else you could do to help your followers short of direct interference?");
			
			godMenu.initiate();
			godMenu.setVisible(true);
			godMenu.bp--;
			if((godMenu.geoUI.mtnrng || godMenu.geoUI.forest) && (geowin==0)){
				JOptionPane.showMessageDialog(null, "With your infinite wisdom that decided not to form some geographical protections earlier," +
													"\nyou have erected some protection overnight for your followers. Both parties alike are stunned by" +
													"\nthis unheard of massive growth. Perhaps the raiders could've been stopped with this as well...");
				
				improvemood();
				geowin++;
			}
			else if((godMenu.military) && milwin==0){
				JOptionPane.showMessageDialog(null, "With your urging, the military is assembled moreso at a almost frantic pace." +
													"\nYou aren't sure if it was due to the bishop's pleas or this was the premediated path of" +
													"\na city at war. You'd like to think you did something in the war effort.");
				
				improvemood();
				milwin++;
			}
			else if(godMenu.dprotect && dwin==0){
				JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
						"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
						"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
						"\nMaybe it's your bias speaking this time around.");
				
				improvemood();
				dwin++;
			}
			else if(geowin+milwin+dwin+pwin>=3){
				JOptionPane.showMessageDialog(null, "Your city is the most equipped it can be with all your guidance." +
													"\nIt's almost assured who the victor will be.");
			}
			else{
				
				JOptionPane.showMessageDialog(null, "The offensive helps in the war effort, yet when the plague resurfaces, both cities are once more" +
													"\ncrippled. You are forced back and lose your advances. This plague might be the end of this war.." +
													"\nHigh stakes are involved even for you. Though you will avoid death as an immortal, you will be" +
													"\npowerless without the belief of your followers, converted to another religion or forcefull assimilated.");
				
				losemood();
				health-=10;
			}
			health-=10;
			
		}
		
		//NO PLAGUE
		else{
			JOptionPane.showMessageDialog(null, "It is uncertain which way the war will head. Regardless, the city still flourishes despite the threat." +
												"\nWhether they're joyful at their own prosperity during wartime, or laughing at the anguish of their" +
												"\nill enemies is unknown. You wonder if those herbs will reinfect your populace with the weakened soldiers factored in...");
			
			godMenu.initiate();
			godMenu.setVisible(true);
			godMenu.bp--;
			
			if((godMenu.geoUI.mtnrng || godMenu.geoUI.forest) && (geowin==0)){
				JOptionPane.showMessageDialog(null, "With your infinite wisdom that decided not to form some geographical protections earlier," +
													"\nyou have erected some protection overnight for your followers. Both parties alike are stunned by" +
													"\nthis unheard of massive growth. Perhaps the raiders could've been stopped with this as well...");
				
				improvemood();
				geowin++;
			}
			else if((godMenu.military) && milwin==0){
				
				JOptionPane.showMessageDialog(null, "With your urging, the military is assembled moreso at a almost frantic pace." +
													"\nYou aren't sure if it was due to the bishop's pleas or this was the premediated path of" +
													"\na city at war. You'd like to think you did something in the war effort.");
				
				improvemood();
				milwin++;
			}
			else if(godMenu.dprotect && dwin==0){
				JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
						"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
						"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
						"\nMaybe it's your bias speaking this time around.");
				
				improvemood();
				dwin++;
			}
			else if(geowin+milwin+dwin+pwin>=3){
				JOptionPane.showMessageDialog(null, "Your city is the most equipped it can be with all your guidance." +
													"\nIt's almost assured who the victor will be.");
			}
			else{
				
				
				losemood();
				health-=10;
			}
			if(pwin==0){
				pwin++;
			}
			
		}
		
		//FOOD SHORTAGE
		if(!godMenu.fertile){
			JOptionPane.showMessageDialog(null, "War always demands more food. The poor pay their bodies to their nation for an extra meal." +
					"\nThroughout the war, the soliders consume more as the peasants attempt to meet the demand." +
					"\nIt's not really surprising that the fertile land you granted your people cuts harvests a couple times" +
					"\nduring the war. Everyone was so busy with the war effort, they hadn't realize the land crisis" +
					"\nuntil the food shortage happened. Welp.");
			losemood();
			health-=10;
		}
		else{
			JOptionPane.showMessageDialog(null, "Your followers come dangerously close to having a major food shortage at some point" +
												"\nduring the war. It seems the blessed, fertile land managed to hold out. The lowest point of" +
												"\nharvest likely passed. At least you hope so or there will be bread riots. Or some other" +
												"\nfood they really like.");
			improvemood();
		}
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade06(){
		//PLague stops
		JOptionPane.showMessageDialog(null, "Through the long years of fighting and ceasefire, it feels as if the original cause" +
											"\nhas already been forgotten. While it may be long for human memory, it is but a" +
											"\ntrivial amount of time for a god. You remember when the plague first originated." +
											"\nYou see now when it ends. Though the people who witnessed its birth may have not..." +
											"\nEven with the cause of the war gone, the people still wage on, fueled by hatred." +
											"\nYou feel the end is neigh. Both cannot continue this needless bloodshed much longer.");
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		if((godMenu.geoUI.mtnrng || godMenu.geoUI.forest) && (geowin==0)){
			JOptionPane.showMessageDialog(null, "With your infinite wisdom that decided not to form some geographical protections earlier," +
												"\nyou have erected some protection overnight for your followers. Both parties alike are stunned by" +
												"\nthis unheard of massive growth. Perhaps the raiders could've been stopped with this as well...");
			
			improvemood();
			geowin++;
		}
		else if((godMenu.military) && milwin==0){
			JOptionPane.showMessageDialog(null, "With your urging, the military is assembled moreso at a almost frantic pace." +
												"\nYou aren't sure if it was due to the bishop's pleas or this was the premediated path of" +
												"\na city at war. You'd like to think you did something in the war effort.");
			
			improvemood();
			milwin++;
		}
		else if(godMenu.dprotect && dwin==0){
			JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
												"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
												"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
												"\nMaybe it's your bias speaking this time around.");
			
			improvemood();
			dwin++;
		}
		else if(geowin+milwin+dwin+pwin>=3){
			JOptionPane.showMessageDialog(null, "Your city is the most equipped it can be with all your guidance." +
												"\nIt's almost assured who the victor will be.");
			improvemood();
			godMenu.bp++;
		}
		else{
			
			JOptionPane.showMessageDialog(null, "You fear the worst for your people, if they even survive this relentless assault." +
												"\nWhat more can you do? Is there absolutely no hope left?" +
												"\nIs it a sign that your communication with your own bishop is deteriorating even now?");
			
			losemood();
			health-=10;
		}
		
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade07(){
		
		JOptionPane.showMessageDialog(null, "Through the long years of carnage, you see a light now. The fighting seems less" +
											"\ninspired. Perhaps this new generation of war-tired soldiers will be more" +
											"\nwilling to enter the negotiating table. Perhaps they will stop killing themselves now." +
											"\nYou contemplate changing your leadership honestly..." +
											"\nNonetheless, you must continue to help the war effort as every good citizen is.");
		
		if((godMenu.geoUI.mtnrng || godMenu.geoUI.forest) && (geowin==0)){
			JOptionPane.showMessageDialog(null, "With your infinite wisdom that decided not to form some geographical protections earlier," +
												"\nyou have erected some protection overnight for your followers. Both parties alike are stunned by" +
												"\nthis unheard of massive growth. Perhaps the raiders could've been stopped with this as well...");
			
			improvemood();
			geowin++;
		}
		else if((godMenu.military) && milwin==0){
			JOptionPane.showMessageDialog(null, "With your urging, the military is upgraded moreso at a almost frantic pace." +
												"\nYou aren't sure if it was due to the bishop's pleas or this was the premediated path of" +
												"\na city at war. You'd like to think you did something in the war effort.");
			
			improvemood();
			milwin++;
		}
		else if(godMenu.dprotect && dwin==0){
			JOptionPane.showMessageDialog(null, "Your divine protection, usually meant as a defensive against the Gods, seems to have some" +
												"\neffect on the ongoing war. Wounds seem to heal faster, supposedly fatal hits survivable, and" +
												"\nmuch sturdier skin/armor? You do hope your people don't become obsidian rocks." +
												"\nMaybe it's your bias speaking this time around.");
			
			improvemood();
			dwin++;
		}
		else if(geowin+milwin+dwin+pwin>=3){
			JOptionPane.showMessageDialog(null, "Your city is the most equipped it can be with all your guidance." +
												"\nIt's almost assured who the victor will be.");
			improvemood();
			godMenu.bp++;
		}
		else{
			
			JOptionPane.showMessageDialog(null, "The cries of your people have become commonplace. The haze of battle grows" +
												"\never closer. You can only pray to whatever higher being that your people will" +
												"\nget through this mess. You can only believe there is more to do.");
			
			losemood();
			health-=10;
		}
		
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade08(){
		//War end
		
		JOptionPane.showMessageDialog(null, "The day has finally come. After years of praying, the end of the war has arrived." +
											"\nOnly questions remain...." +
											"\nWho is the victor?" +
											"\nHave you done all you could to help?");
		
		if(geowin+milwin+dwin+pwin>=3){
			JOptionPane.showMessageDialog(null, "On the negotiating table, it's clear who the victors were.");
			
			JOptionPane.showMessageDialog(null,	"Your religion is not annhilated yet. It seems you'll be getting more followers" +
												"\nand believers as well. They will come to like your religion, whether forced or not." +
												"\nWho could hate a victorious God such as yourself? Only a narcissist." +
												"\nYour people have survived the Great War! A little rejuvenation doesn't hurt.");
			improvemood();
			improvemood();
			health+=30;
			
		}
		
		else{
			JOptionPane.showMessageDialog(null, "On the negotiating table, both sides are ragged, war torn representatives of their cities." +
												"\nYet, it's certain who the victory is.");
			
			JOptionPane.showMessageDialog(null, "The victor, the opposition, makes very clear demands of assimilation." +
												"\nThey mean to utterly eradicate your followship and force an absorption." +
												"\nYour people are forcefully absorbed into the base of an empire, you wonder if" +
												"\nthis foresight is the last of your godly abilities for a while." +
												"\nThe terms call for the end of worship and immediate worship of another God.");
			
			JOptionPane.showMessageDialog(null, "If your followers had won, perhaps this would be avoidable. Perhaps you'd be on the" +
												"\nthe other end of the negotiations. However, there is little reason to ponder on an" +
												"\nalternative realtiy, save for escapism. Which looks prett good right now." +
												"\nYou've got milleniums now that your following is all but annhilated. Might as well start now." +
												"\nThe best career was definitely kicking back and not even bothering with this people raising business. ");
			System.exit(0);
		}
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}
		
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		JOptionPane.showMessageDialog(null, "It's quite refreshing to not have to deal with war for once." +
											"\nYour people pulled through with your guidance, but it appears that" +
											"\nguidance would no longer be necessary soon...");
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade09(){
		//Golden age
		
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;
		
		JOptionPane.showMessageDialog(null, "Your city enters a golden age of rapid improvements!" +
											"\nIt feels you with pride, seeing the growth from dependent children to" +
											"\nindependent adults. The era of secularism seems to be on the rise." +
											"\nLike with all great ages, the age of religious devotion" +
											"\nappears to be coming to an end." +
											"\nWill your group survive to the end?");
		
		if(godMenu.mood>=5){
			godMenu.bp++;
		}	
		
		JOptionPane.showMessageDialog(null, "Currently, your civilization is " + health + "% healthy!");
		suck();
		return health;
	}
	
	private int decade10(){
		//God blight
		
		godMenu.initiate();
		godMenu.setVisible(true);
		godMenu.bp--;	
		
		JOptionPane.showMessageDialog(null, "Your people are gradually leaving their cradle of birth. They are expanding," +
											"\nmoving away from the home, spreading, dispersing. Your might will never be as concentrated again," +
											"\nnor as high devotion. But your name will be known. The world will know of your name." +
											"\nThey may not worship you as loyally nor devotedly, but you will never be completely depleted." +
											"\nAs the final stages of development approach, you find yourself turning your eye away more often.");
		
		JOptionPane.showMessageDialog(null, "That was a fatal mistake.");
		
		JOptionPane.showMessageDialog(null, "You will never known why. You will never know who." +
											"\nThe only thing you do know is your city in shambles once more, smited by godly might" +
											"\nstronger than even your divine protection. There was no 'prevention'." +
											"\nYou can only hope they could rebuild, and your name not smeared for this" +
											"\nheartless and cruel action.");
		JOptionPane.showMessageDialog(null,"Is this karmic retribution?");
		health-=50;
		suck();
		
		if(health>0){
			JOptionPane.showMessageDialog(null, "Miraculously, your people pull through." +
												"\nNo words could express your gratitude. To be killed by another God at the very end..." +
												"\nThe very definition of cheap and cruelty.");
		}
	
		return health;
	}
	
	private void end(){
		track.bend();
		track.ward();
		JOptionPane.showMessageDialog(null, "It has been the end of the long journey.");
		JOptionPane.showMessageDialog(null, "Your children, watching them grow from mere sticks to towering skyscrapers." +
											"\nThey used to be guided by your blessing. Now, they have the abilities to predict the skies." +
											"\nThey have the ability to control the forces of the Gods." +
											"\nThey have left your cradle. While you should feel upset that their piety is not as high as prior..." +
											"\nYou feel happiness. Perhaps it's time to guide another group into this same horizon.");
		
		JOptionPane.showMessageDialog(null,"Will it feel as gratifying as now? Or will this feeling fade into a bitter memory? Only time will tell.");
		track.wend();
		System.exit(0);
	}
	
	private boolean loss(){
		if(health<=0){
			return true;
		}
		return false;
	}
	
	private void suck(){
		if(loss()){
			track.bend();
			track.ward();
			JOptionPane.showMessageDialog(null, "Your people have been decimated. Total annhilation." +
												"\nNo god could save them now. Forever they rest in eternal slumber.");
			JOptionPane.showMessageDialog(null, "O God, please use your wisdom to lead these lost souls into paradise.");
			track.wend();
			System.exit(0);
		}
	}

}
