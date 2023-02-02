class Wearable extends Item {
	private Boolean onUser = false;
	
	Wearable(String name, String desc){
		super(name, desc);
	}
	
	public void wear() {
		// Överskuggas av subklassens egna metod wear();
		System.out.println("You are now wearing the " + this.getName());
	}
	
	public void putOn(Wearable item){
		this.onUser = true;
		item.wear();
	}
	
	public Boolean getOnUser() {
		return this.onUser;
	}
	
	public void takeOff(){
		this.onUser = false;
		System.out.println("You have now take off the " + this.getName());
	}
	
}
