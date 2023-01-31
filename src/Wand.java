
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
	
	public void lumos() {
		System.out.println("*********************");
		System.out.println("********LIGHT********");
		System.out.println("*********************");
		System.out.println();
		System.out.println("The space around you is now filled with light");
	}
	
	public void alohomora() {
		System.out.println("########CLICK!########");
		System.out.println();
		System.out.println("You have now unlocked something...");	
	}
			
	public void wingardiumLeviosa() {
	System.out.println("^^^^^^^WHOOSH^^^^^^");
	System.out.println();
	System.out.println("The object is now levetating");
	}

}
	
	
