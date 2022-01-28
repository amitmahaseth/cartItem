package com.example.coroutinesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesretrofit.databinding.ActivityDetailsBinding

import com.example.coroutinesretrofit.model.CountModel

  class DetailsActivity : AppCompatActivity(),Clicklistner {
    private lateinit var binding: ActivityDetailsBinding
    private  var listCount:ArrayList<CountModel>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

        binding.btnTotal.setOnClickListener {

        }

    }

      private fun initUI() {
          listCount=ArrayList<CountModel>()
          listCount!!.add(CountModel("Apple",1,100))
          listCount!!.add(CountModel("Banana",1,50))
          listCount!!.add(CountModel("Orange",1,40))
          listCount!!.add(CountModel("Grapes",1,20))
          listCount!!.add(CountModel("Guava",1,70))
          listCount!!.add(CountModel("Pumpkin",1,40))

          binding.rvDetails.layoutManager = LinearLayoutManager(this)
          var adapter = DetailsAdapter(this,listCount!!,this)
          binding.rvDetails.adapter = adapter


      }




      override fun onItem(position: Int) {

      }

  }


