package godVille;

public class Species {

	private String trait1;
	private String trait2;
	private String trait3;
	
	public Species(String chara1, String chara2, String chara3){
		trait1= chara1;
		trait2= chara2;
		trait3=chara3;
	}
	
	
	public String getTrait1(){return trait1;}
	public String getTrait2(){return trait2;}
	public String getTrait3(){return trait3;}

}
