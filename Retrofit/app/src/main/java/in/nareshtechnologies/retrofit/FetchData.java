package in.nareshtechnologies.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FetchData {

    @GET("news?category=entertainment")
    Call<Example> getData();

}
