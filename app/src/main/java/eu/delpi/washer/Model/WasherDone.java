package eu.delpi.washer.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by nicolas on 26/11/16.
 */

public class WasherDone {

    @SerializedName("time")
    @Expose
    private Date time;

    public WasherDone() {
    }

    public WasherDone(Date time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The time
     */
    public Date getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}