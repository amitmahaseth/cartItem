package com.example.coroutinesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesretrofit.databinding.ActivityDetailsBinding

import com.example.coroutinesretrofit.model.CountModel

class DetailsActivity : AppCompatActivity(), Clicklistner {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var listCount: ArrayList<CountModel>
    private lateinit var adapter: DetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


    }

    private fun initUI() {
        listCount = ArrayList<CountModel>()
        listCount.add(CountModel("Apple", 1, 100, 100))
        listCount.add(CountModel("Banana", 1, 50, 50))
        listCount.add(CountModel("Orange", 1, 40, 40))
        listCount.add(CountModel("Grapes", 1, 20, 20))
        listCount.add(CountModel("Guava", 1, 70, 70))
        listCount.add(CountModel("red", 1, 10, 10))
        listCount.add(CountModel("yellow", 1, 20, 20))
        listCount.add(CountModel("red", 1, 30, 30))
        listCount.add(CountModel("green", 1, 60, 60))
        listCount.add(CountModel("pink", 1, 80, 80))

        binding.rvDetails.layoutManager = LinearLayoutManager(this)
        adapter = DetailsAdapter(this, listCount!!, this)
        binding.rvDetails.adapter = adapter

//        binding.btnTotal.setOnClickListener {
//
//            var totalPrice = 0
//            for (i in 0 until adapter.getCountList()!!.size) {
//                totalPrice += adapter.getCountList().get(i).price
//            }
//            binding.tvTotal.text = totalPrice.toString()
//
//
//        }


    }


    override fun onItem(countList: ArrayList<CountModel>) {
        binding.btnTotal.setOnClickListener {
            var totalPrice = 0
        for (i in 0 until adapter.getCountList()!!.size) {
            totalPrice += adapter.getCountList()!!.get(i).price!!
        }
        binding.tvTotal.text = totalPrice.toString()
        }

//        var totalPrice = 0
//        for (i in 0 until adapter.getCountList()!!.size) {
//            totalPrice += adapter.getCountList()!!.get(i).price!!
//        }
//        binding.tvTotal.text = totalPrice.toString()
    }

}


