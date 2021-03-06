package com.example.coroutinesretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesretrofit.model.CountModel

class DetailsAdapter(
    private var mContext: Context, private var countList: ArrayList<CountModel>,
    var onItemClicked: Clicklistner
) :
    RecyclerView.Adapter<DetailsViewAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewAdapter {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.details_list, parent, false)
        return DetailsViewAdapter(view)
    }

     fun getCountList(): ArrayList<CountModel> {
        return countList
    }

    override fun onBindViewHolder(holder: DetailsViewAdapter, position: Int) {
        var countModel = countList[position]
        holder.tv_desc.text = countModel.name
        holder.tv_prize.text = countModel.price.toString()
        holder.tv_cont.text = countModel.countTextView.toString()


        holder.tv_cont.text = countList.get(position).countTextView.toString()
        holder.tv_prize.text = countList.get(position).price.toString()

        holder.img_plus.setOnClickListener {
            if (countList.get(position).countTextView < 10) {
                val counter = countList.get(position).countTextView + 1
                countList.get(position).countTextView = counter

                val price = countList.get(position).basePrice * counter
                countList.get(position).price = price
                notifyDataSetChanged()
                onItemClicked.onItem(countList)
            }


        }
        holder.img_minus.setOnClickListener {
            if (countList.get(position).countTextView > 1) {
                val counter = countList.get(position).countTextView - 1
                countList.get(position).countTextView = counter

                val price = countList.get(position).basePrice * counter
                countList.get(position).price = price
                notifyDataSetChanged()
                onItemClicked.onItem(countList)
            }


        }

    }


    override fun getItemCount(): Int {
        return countList.size
    }


}


class DetailsViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var img_profile = itemView.findViewById<ImageView>(R.id.img_item)
    var tv_desc = itemView.findViewById<TextView>(R.id.tv_disc)
    var tv_prize = itemView.findViewById<TextView>(R.id.tv_price)
    var img_plus = itemView.findViewById<ImageView>(R.id.img_plus)
    var tv_cont = itemView.findViewById<TextView>(R.id.tv_count)
    var img_minus = itemView.findViewById<ImageView>(R.id.img_minus)

}

interface Clicklistner {
    fun onItem(countList: ArrayList<CountModel>)


}
