package eu.delpi.washer.Model.Remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class WasherDoneRemote {

    @SerializedName("time")
    @Expose
    private Date time;

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