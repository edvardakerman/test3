import java.util.ArrayList;

public class Player {
    private String Name;
    private Location Location;
    private Wand wand = new Wand("Wand", "Cast a spell!");
    private Wearable wearing;
    private ArrayList<Item> items = new ArrayList<Item>() {
    	private static final long serialVersionUID = 1L;

		{	
    		add(wand);
        }
    };

    
    Player(String name, Location start){
        this.Name = name;
        this.Location = start;
    }

    public String getName(){
        return this.Name;
    }
    
    public void addItem(Item item) {
    	this.items.add(item);
    }
    
    public ArrayList<Item> getItems(){
        return this.items;
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
            case "items":
            	inventory();
            	break;
            case "help":
            	help();
            	break;
            case "take":
            	takeItem(arr[1]);
            	break;
            case "wear":
            	useItem(arr[1]);
            	break;
            case "cast":
            	Wand.castSpell(arr[1]);

            	break;
            default: 
                System.out.println("Unvalid command, type 'help' for more info");
                break;
        }
    }

    public Location getLocation(){
        return this.Location;
    }
    
    void help(){
    	System.out.println("Valid commands:");
    	System.out.println("1. move  - followed by a direction, east/west/north/south");
    	System.out.println("2. cast  - followed by a spell, wingardium leviosa");
    	System.out.println("3. wear  - followed by a wearable item, Cloak of Invisibility");
    	System.out.println("4. take  - followed by a item, Elderwand");
    	System.out.println("5. items - Shows what you are currently carring with you");
    	System.out.println("6. look	 - Shows whats on your current location");
    }
    
    void look(){
    	System.out.println("looking..");
    	for (Item item : this.Location.getItems()) {
	    	System.out.println(item.getName());
		}
    }
    
    void takeItem(String Name){
    	    	
    	for (Item item : this.Location.getItems()) {
    		if (Name.equals(item.getName())) {
    			this.items.add(item);
    			System.out.println(item.getName() + " was added to your items");		
    		}
		}
    	this.Location.removeItem(this.items.get(this.items.size() - 1));
    }
    
    void useItem(String Name){  	
    	for (Item item : this.items) {
    		if (Name.equals(item.getName())) {
    			// joker ??
    			if(item instanceof Wearable) {
    				  Wearable subClassElem = (Wearable) item;
    				  subClassElem.putOn(subClassElem);
    				  this.wearing = subClassElem;
    			}
    		}
		}
    }
    
    void inventory(){
    	System.out.println("Current inventory");
    	for (Item item : this.items) {
	    	System.out.println(item.getName() + ", " + item.getDesc());
		}
    }
    
    private Boolean isLocked(String direction) {
    	if(this.Location.getPath(direction) instanceof Inside) {
			if (((Inside) this.Location.getPath(direction)).getStatus()) {
				return true; 
			}
		}
    	return false;
    }
    

    void moveTo(String direction){
    		
    	if (this.Location.getPath(direction) != null) {
    		
    		if (isLocked(direction)) {
    			System.out.println("The choosen direction is locked, please unlock before entering..");
    		} else {
    			this.Location = this.Location.getPath(direction);
    	        System.out.println("You are now in " + this.Location.getName() + ", " + this.Location.describeYourself());
    			if(this.Location instanceof Outside) {
    				((Outside) this.Location).changeWeather();
    		        System.out.println("The weather is " + Outside.Weather);
    			}
    		}		
    			
    	} else {
        	System.out.println("invalid direction");
    	}

	}
    
}
