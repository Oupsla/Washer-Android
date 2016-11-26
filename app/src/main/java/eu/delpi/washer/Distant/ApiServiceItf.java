package eu.delpi.washer.Distant;

import java.util.List;

import eu.delpi.washer.Model.Remote.UserRemote;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by nicolas on 26/11/16.
 */

public interface ApiServiceItf {

    @GET("/user/names")
    Call<List<UserRemote>> fetchNames();

    @GET("/user/washer")
    Call<String> getNext();

    @POST("/user/washer")
    Call<String> postWash(UserRemote userRemote);

    @GET("/user")
    Call<List<UserRemote>> getUsers();

}
