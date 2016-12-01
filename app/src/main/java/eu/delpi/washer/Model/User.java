package eu.delpi.washer.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nicolas on 25/11/16.
 */

public class User {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("listWasherDone")
    @Expose
    public List<WasherDone> listWasherDone;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("totalMonth")
    @Expose
    private Integer totalMonth;
    @SerializedName("totalWeek")
    @Expose
    private Integer totalWeek;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param washerDoneRemote
     * @param id
     * @param v
     * @param name
     */
    public User(String id, String name, Integer v, List<WasherDone> listWasherDone, Integer totalCount, Integer totalMonth, Integer totalWeek) {
        this.id = id;
        this.name = name;
        this.v = v;
        this.listWasherDone = listWasherDone;
        this.totalCount = totalCount;
        this.totalMonth = totalMonth;
        this.totalWeek = totalWeek;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The v
     */
    public Integer getV() {
        return v;
    }

    /**
     *
     * @param v
     * The __v
     */
    public void setV(Integer v) {
        this.v = v;
    }

    /**
     *
     * @return
     * The washerDone
     */
    public List<WasherDone> getListWasherDone() {
        return listWasherDone;
    }

    /**
     *
     * @param listWasherDone
     * The washerDoneRemote
     */
    public void setListWasherDone(List<WasherDone> listWasherDone) {
        this.listWasherDone = listWasherDone;
    }

    /**
     *
     * @return
     * The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     * The totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     * The totalMonth
     */
    public Integer getTotalMonth() {
        return totalMonth;
    }

    /**
     *
     * @param totalMonth
     * The totalMonth
     */
    public void setTotalMonth(Integer totalMonth) {
        this.totalMonth = totalMonth;
    }

    /**
     *
     * @return
     * The totalWeek
     */
    public Integer getTotalWeek() {
        return totalWeek;
    }

    /**
     *
     * @param totalWeek
     * The totalWeek
     */
    public void setTotalWeek(Integer totalWeek) {
        this.totalWeek = totalWeek;
    }
    
}
