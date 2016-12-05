package eu.delpi.washer.Distant;

import java.util.List;

import eu.delpi.washer.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by nicolas on 26/11/16.
 */

public interface ApiServiceItf {

    @GET("/user/names")
    Call<List<User>> getHistory();

    @GET("/user/washer")
    Call<String> getNext();

    @POST("/user/washer")
    Call<String> postWash(@Body User user, @Query("afk") Boolean afk);

    @GET("/user")
    Call<List<User>> getUsers();

}
