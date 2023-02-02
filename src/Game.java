import java.util.*;

class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    private Player player;

    public Game(){
	    keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    
	    // Create Rooms
	    Inside EntranceHall = new Inside("The Entrance Hall", "Welcome to hogwarts, this is the school of magic");
	    Inside GreatHall = new Inside("The Great Hall", "Time to eat?");
	    Inside Hagrids = new Inside("Hagrids Hut", "hagrid says hello");
	    Inside Dorms = new Inside("The Dorms", "Welcome to the student accomidations");
	    Inside Dungens = new Inside("The Dungens", "lock out for trolls");
	    
	    Outside Quad = new Outside("The Quad", "Welcome to the Quad");
	    Outside Herbology = new Outside("Herbology", "Time to grow plants");
	    Outside ForbiddenForest = new Outside("The Forbidden Forest", "Scary, ooooooh");
	    Outside Courtyard = new Outside("The Courtyard", "Time for fresh air");
	    
	    // Create Paths
	    EntranceHall.setPath(Dorms, "north");
	    EntranceHall.setPath(GreatHall, "east");
	    EntranceHall.setPath(Dungens, "west");
	    EntranceHall.setPath(Quad, "south");
	    
	    Dorms.setPath(GreatHall, "east");
	    GreatHall.setPath(Courtyard, "east");
	    
	    Quad.setPath(Herbology, "east");
	    Quad.setPath(Hagrids, "west");
	    
	    Hagrids.setPath(ForbiddenForest, "west");	    
	    Herbology.setPath(Courtyard, "north");
	    
	    // Create Items
	    Cloak CloakofInvisibility = new Cloak("Cloak of Invisibility", "With this you can sneak around");
	    Wand Elderwand = new Wand("Elderwand", "With the Elderwand you can cast even more powerfull spells");
	    	    
	    // Assign Items to rooms
	    Dorms.setItem(CloakofInvisibility);
	    Dungens.setItem(Elderwand);  
	    
	    // add to array
	    locations.add(EntranceHall);
	    EntranceHall.setLocToVisited();
    }

    public void run() {
        String name;
            
        System.out.println("Welcome to the school of magic, Hogwarts!\nWhat is your name?");
        name = keyboard.nextLine();
        player = new Player(name, locations.get(0));
        System.out.println("Hello " + name + ", welcome to this magical world of wonder! You can move around by typing move north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
        
        while (true) {
            String command;
            
            System.out.println("What do you want to do?");
            command = keyboard.nextLine();
            player.doCommand(command);
        }	    
    }

    public ArrayList<Location> getLocations(){
        return this.locations;
    }

}
