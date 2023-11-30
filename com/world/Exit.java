package com.world;

public class Exit {
    private String name;
    private String messageIfLocked = null;
    private Location destination;
    private String description;
    private boolean locked;

    /**
     * Create a exit for a location
     * @param name
     * @param location
     * @param description
     * @param closed
     */
    public Exit(String name, Location location, String description, boolean closed){
        this.name = name;
        this.destination = location;
        this.locked = closed;
        this.description = description;
    }

    /**
     * Create a exit for a location
     * @param name
     * @param location
     * @param description
     */
    public Exit(String name, Location location, String description){
        this.name = name;
        this.destination = location;
        this.locked = true;
        this.description = description;
    }

    /**
     * Create a exit for a location
     * @param name
     * @param description
     */
    public Exit(String name, String description){
        this.name = name;
        this.locked = true;
        this.description = description;
    }

    /**
     * A Exit is Locked by default, you can unlock it with .unlock()
     */
    public void unlock(){
        this.locked = false;
    }

    /**
     * Set a messsage to print if the location is locked
     * @param message
     */
    public void setMessageIfLocked(String message) {
        this.messageIfLocked = message;
    }

    /**
     * Return a getting message if Exit is locked
     * @return
     */
    public String messageForLockedExit() {
        if(messageIfLocked != null) {
            return messageIfLocked;
        }
        else {
            return "This emplacement cannot be accessed. Maybe you forgot something?";
        }
    }

    /**
     * Get the destination location
     * @return
     */
    public Location getDestination(){
        return this.destination;
    }

    /**
     * Get the description of the Exit
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the Name of the Exit
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set a new destination for the Exit
     * @param location
     */
    public void setDestination(Location location) {
        this.destination = location;
    }

    /**
     * Return a boolean on the locked situation of Exit
     * @return
     */
    public boolean isLocked() {
        return this.locked;
    }
}