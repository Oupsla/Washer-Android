package eu.delpi.washer.Model;

import java.util.Date;

/**
 * Created by nicolas on 26/11/16.
 */

public class WasherDone {

    public WasherDone() {
    }

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