package Sklad;

import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetrofitComponent {
    private SkladAPI skladAPI;
    Call<List<String>> result;
    List<String> callApi(ArrivalDocument document)
    {
        final List<String>[] status = new List[]{new ArrayList<>()};
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://localhost:8080").addConverterFactory(GsonConverterFactory.create()).build();
        skladAPI=retrofit.create(SkladAPI.class);
        result= skladAPI.sendArrivalDocument(document);
        result.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful())
                {
                    status[0] =response.body();
                }
                else {
                    status[0].add("{\"status\":\"Cannot recieve a data\"}");
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable throwable) {

            }
        });
        return status[0];
    }
}
