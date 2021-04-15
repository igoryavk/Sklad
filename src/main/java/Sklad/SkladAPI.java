package Sklad;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface SkladAPI {
    @POST("/document/arrival")
    Call<List<String>> sendArrivalDocument(@Body ArrivalDocument document);
}
