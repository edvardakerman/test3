class Wearable extends Item {
	Wearable(String name, String desc){
		super(name, desc);
	}
	
	public void wear() {
		System.out.println("You are now wearing the " + this.getName());
	}
	
}
