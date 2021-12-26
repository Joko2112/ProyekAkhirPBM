package id.susilo.joko
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.susilo.joko.databinding.ActivityMainBinding
import id.susilo.joko.retrofit_client.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // menggunakan view vinding
    private val Binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)
        //menambahkan view
        DataIndonesia()
    }

    // untuk mengatur tampilan data kasus indonesia
    private fun DataIndonesia(){
        APIService.instance.getDataLocal().enqueue(object : Callback<ArrayList<DataIndonesia>> {
            //kondisi jika koneksi bagus dan terhubugn ke server onResponse
            //dan akan menampilkan data berdasarkan binding yang di tuju
            override fun onResponse(
                call: Call<ArrayList<DataIndonesia>>,
                response: Response<ArrayList<DataIndonesia>>
            )
            {
                //karna datanya dalam bentuk array maka kita get menggunakan index 0

                val indonesiaResponse = response.body()?.get(0)
                val positif = indonesiaResponse?.positif
                val sembuh = indonesiaResponse?.sembuh
                val meninggal = indonesiaResponse?.meninggal

                //View Binding
                Binding.dataPositif.text = positif
                Binding.dataSembuh.text = sembuh
                Binding.dataMeninggal.text = meninggal
            }
            //kondisi dimana jika koneksi ke internet
            override fun onFailure(call: Call<ArrayList<DataIndonesia>>, t: Throwable) {}
        })
    }
}