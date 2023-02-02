
class Wand extends Item {
	
	private int power;
	
	Wand(String name, String desc){
		super(name, desc);
	}
	
	public void setPower(int power){
		this.power = power;
	}
	
	public int getPower(){
		return this.power;
	}
	
    static void castSpell(String cast) {
    	switch (cast) {
		case "alohomora":
			Wand.alohomora();
			break;
		case "lumos":
			Wand.lumos();
			break;
		case "wingardium Leviosa":
			Wand.wingardiumLeviosa();
			break;
		default:
		}
    }
	
	private static void lumos() {
		System.out.println("*********************");
		System.out.println("********LIGHT********");
		System.out.println("*********************");
		System.out.println();
		System.out.println("The space around you is now filled with light");
	}
	
	private static void alohomora() {
		System.out.println("########CLICK!########");
		System.out.println();
		System.out.println("You have now unlocked something...");	
	}
			
	private static void wingardiumLeviosa() {
	System.out.println("^^^^^^^WHOOSH^^^^^^");
	System.out.println();
	System.out.println("The object is now levetating");
	}

}
	
	
