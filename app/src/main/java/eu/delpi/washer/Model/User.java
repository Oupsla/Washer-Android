package eu.delpi.washer.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nicolas on 25/11/16.
 */

public class User {

    public String name;
    public ArrayList<WasherDone> listWasherDone;

    public User() {
    }

    public User(String name, ArrayList<WasherDone> listWasherDone) {
        this.name = name;
        this.listWasherDone = listWasherDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WasherDone> getListWasherDone() {
        return listWasherDone;
    }

    public void setListWasherDone(ArrayList<WasherDone> listWasherDone) {
        this.listWasherDone = listWasherDone;
    }
    
}
