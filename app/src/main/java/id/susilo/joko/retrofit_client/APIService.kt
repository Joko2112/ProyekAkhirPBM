package id.susilo.joko.retrofit_client
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// untuk request pada server ini mengunakan Retrofit untuk
// fungsi utama Retrofit adalah untuk meng-handle semua
// hal yang berkaitan dengan koneksi data dari android ke internet
// untuk penggunaan bisa lihat https://square.github.io/retrofit/
// APIService digunakan untuk mengatur hubungan ke server yaitu base url
// dan membutuhkan json converter agar data yang di kirimkan tidak kita konversi lagi
object APIService {
    val instance : ApiEndpoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.kawalcorona.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiEndpoint::class.java)
    }
}