//package com.example.coroutinesretrofit
//
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import coil.api.load
//import com.example.coroutinesretrofit.databinding.ActivityMainBinding
//import com.example.coroutinesretrofit.network.ApiDetails
//
//import kotlinx.coroutines.*
//
//
//
//class MainActivity : AppCompatActivity(),CoroutineScope by MainScope(){
//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding= ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.button.setOnClickListener {
//            launch(Dispatchers.Main){
//                // Try catch block to handle exceptions when calling the API.
//                try {
//                    val response = ApiDetails.apiClient.getRandomDogImage()
//                    // Check if response was successful
//                    if (response.isSuccessful && response.body() != null) {
//                        // Retrieve data.
//
//                        val data = response.body()!!
//                        Log.d("TAG", "onCreate:$data ")
//                        data.message.let {
//                            // Load URL into the ImageView using Coil.
//                            binding.imageView.load(it)
//                        }
//                    } else {
//
//                        Toast.makeText(this@MainActivity, "Error Occurred: ${response.message()}", Toast.LENGTH_LONG).show()
//                    }
//                } catch (e: Exception) {
//                    Toast.makeText(this@MainActivity, "Error Occurred: ${e.message}",Toast.LENGTH_LONG).show()
//                }
//            }
//
//
//            }
//
//    }
//}