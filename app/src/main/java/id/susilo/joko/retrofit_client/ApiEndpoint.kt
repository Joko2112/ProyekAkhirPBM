package id.susilo.joko.retrofit_client
import id.susilo.joko.DataIndonesia
import retrofit2.Call
import retrofit2.http.GET

//pada bagian ini kita menentukan data apa saja yang akan
//kita ambil dari seumber api.
//api from https://kawalcorona.com/api/
interface ApiEndpoint {
    //mengambil data khusu indonesia
    @GET("indonesia")
    fun getDataLocal(): Call<ArrayList<DataIndonesia>>
}