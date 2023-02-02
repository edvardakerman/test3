class Inside extends Location {
    private Boolean Locked = false;
	
	Inside(String Name, String Description){
		super(Name, Description);
	}
	
    public Boolean getStatus(){
        return this.Locked;
    }
    
    public void setLock(Boolean lock){
    	this.Locked = lock;
    }
}
