
class Cloak extends Wearable {
	
	Cloak(String name, String desc){
		super(name, desc);
	}
	
	public void wear() {
		System.out.println("Where did you go???");
		System.out.println("You are now wearing the cloack of Invisibility");
	}
}
