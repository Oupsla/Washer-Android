package eu.delpi.washer.Model.Remote;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.delpi.washer.Model.User;
import eu.delpi.washer.Model.WasherDone;

public class UserRemote {

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
    private List<WasherDoneRemote> washerDoneRemote = new ArrayList<WasherDoneRemote>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UserRemote() {
    }

    /**
     *
     * @param washerDoneRemote
     * @param id
     * @param v
     * @param name
     */
    public UserRemote(String id, String name, Integer v, List<WasherDoneRemote> washerDoneRemote) {
        this.id = id;
        this.name = name;
        this.v = v;
        this.washerDoneRemote = washerDoneRemote;
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
     * The washerDoneRemote
     */
    public List<WasherDoneRemote> getWasherDoneRemote() {
        return washerDoneRemote;
    }

    /**
     *
     * @param washerDoneRemote
     * The washerDoneRemote
     */
    public void setWasherDoneRemote(List<WasherDoneRemote> washerDoneRemote) {
        this.washerDoneRemote = washerDoneRemote;
    }

    public User toUser(){
        User u = new User();
        u.setName(this.getName());
        ArrayList<WasherDone> washerDoneList = new ArrayList<>();
        for (WasherDoneRemote washerDoneItemRemote: this.getWasherDoneRemote()) {
            WasherDone washerDoneItem = new WasherDone();
            washerDoneItem.setTime(washerDoneItemRemote.getTime());
            washerDoneList.add(washerDoneItem);
        }
        u.setListWasherDone(washerDoneList);
        return u;
    }

}