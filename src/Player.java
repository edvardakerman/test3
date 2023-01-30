public class Player {
    private String Name;
    private Location Location;

    
    Player(String name, Location start){
        this.Name = name;
        this.Location = start;
    }

    public String getName(){
        return this.Name;
    }

    public void doCommand(String cmd){
    	String arr[] = cmd.split(" ", 2);
        switch (arr[0]) {
            case "move":
                moveTo(arr[1]);
                break;
            case "look":
                look();
                break;
            case "help":
            	help();
            	break;
            default: 
                System.out.println("Fel");
                break;
        }
    }

    public Location getLocation(){
        return this.Location;
    }
    
    void help(){
    	System.out.println("Valid commands:");
    	System.out.println("1. move (followed by a direction, east/west/north/south)");
    	System.out.println("2. spell (followed by a spell, wingardium leviosa)");
    }
    
    void look(){
    	System.out.println("looking..");
    	for (Item item : this.Location.getItems()) {
	    	System.out.println(item.getName());
		}
    }

    void moveTo(String direction){
    	
    	if (this.Location.getPath(direction) != null) {
        	this.Location = this.Location.getPath(direction);
    	} else {
        	System.out.println("invalid direction");
    	}
        System.out.println("You are now in " + this.Location.getName() + ", " + this.Location.describeYourself());
 	
    }
    
}
