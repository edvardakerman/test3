import java.util.ArrayList;

public class Player {
    private String Name;
    private Location Location;
    private Wand wand = new Wand("Wand", "Cast a spell!");
    private ArrayList<Item> items = new ArrayList<Item>() {
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
            	castSpell(arr[1]);
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
    	System.out.println("1. move (followed by a direction, east/west/north/south)");
    	System.out.println("2. spell (followed by a spell, wingardium leviosa)");
    }
    
    void look(){
    	System.out.println("looking..");
    	for (Item item : this.Location.getItems()) {
	    	System.out.println(item.getName());
		}
    }
    
    void castSpell(String cast) {
    	switch (cast) {
		case "alohomora":
			this.wand.alohomora();
			break;
		case "lumos":
			this.wand.lumos();
			break;	
		default:
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

    void moveTo(String direction){
    	
    	if (this.Location.getPath(direction) != null) {
        	this.Location = this.Location.getPath(direction);
    	} else {
        	System.out.println("invalid direction");
    	}
        System.out.println("You are now in " + this.Location.getName() + ", " + this.Location.describeYourself() + ", " + this.Location.getNewCount());
 	
    }
    
}
