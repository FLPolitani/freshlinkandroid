package politanismd.freshlink.service;

import politanismd.freshlink.model.ResponseToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Eko on 12/07/2017.
 */

public interface ApiEndpointService {
    @FormUrlEncoded
    @POST("token")
    Call<ResponseToken> getAccessToken(@Field("email") String email, @Field("password") String password);

}
