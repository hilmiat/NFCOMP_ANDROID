package id.my.note.prakiraancuaca;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hilmiat on 16/12/17.
 */

public interface CuacaService {
    @GET("weather")
    Call<Cuaca> getCuaca(@Query("q") String q);
}
