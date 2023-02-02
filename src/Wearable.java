class Wearable extends Item {
	Wearable(String name, String desc){
		super(name, desc);
	}
	
	public void wear() {
		// Överskuggas av subklassens egna metod wear();
		System.out.println("You are now wearing the " + this.getName());
	}
	
	public void putOn(Wearable item){
		item.wear();
	}
	
	public void takeOff(){
		System.out.println("You have now take off the " + this.getName());
	}
	
}
