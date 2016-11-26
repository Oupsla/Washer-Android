package eu.delpi.washer.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nicolas on 25/11/16.
 */

public class User {

    public String name;
    public ArrayList<WasherDone> listWasherDone;

    public class WasherDone {
        public Date time;

        public WasherDone(Date time) {
            this.time = time;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }
    }

}
