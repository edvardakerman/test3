public class Location {
    private String Name;
    private String Description;
    private Boolean Locked;
    private Location North, East, South, West;

    Location(String name, String desc){
        this.Description = desc;
        this.Name = name;
    }

    public String getName(){
        return this.Name;
    }
    
    public Boolean getSatus(){
        return this.Locked;
    }
    
    public void setLock(Boolean lock){
    	this.Locked = lock;
    }

    public String describeYourself(){
        return this.Description;
    }
    
    // separate class four paths, room has paths between connecting them, function that takes 2 locations and direction.

    public void setPath(Location room, String direction){
        switch (direction) {
        case "north":
        	room.South = this;
            this.North = room;
            break;
        case "west":
        	room.East = this;
        	this.West = room;
            break;
        case "south":
        	room.North = this;
        	this.South = room;
            break;
        case "east":
        	room.West = this;
        	this.East = room;
            break;
        default:
            break;
    }
        
    }

    public Location getPath(String direction){
        switch (direction) {
        case "north":
            return this.North;
        case "west":
        	return this.West;
        case "south":
        	return this.South;
        case "east":
        	return this.East;
        default:
        	return null;
    }
    }
}
