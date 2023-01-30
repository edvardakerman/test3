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
            default: 
                System.out.println("Fel");
                break;
        }
    }

    public Location getLocation(){
        return this.Location;
    }

    void moveTo(String direction){
    	
    	if (this.Location.getPath(direction) != null) {
        	this.Location = this.Location.getPath(direction);
    	} else {
        	System.out.println("invalid direction");
    	}
 	
    }
    
}
