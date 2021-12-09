package org.techtown.starcraft2.Zerg

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.techtown.starcraft2.R
import org.techtown.starcraft2.Starcraft2Unit
import org.techtown.starcraft2.databinding.ItemListBinding

class ZergAdapter(var context: Context,var unitList:ArrayList<Starcraft2Unit>):RecyclerView.Adapter<ZergAdapter.ZergHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZergHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
                inflater, R.layout.item_list,parent,
                false)
        return ZergHolder(v)

    }

    override fun onBindViewHolder(holder: ZergHolder, position: Int) {
        val newList = unitList[position]
        holder.binding.isItem =unitList[position]
        holder.binding.root.setOnClickListener{

            val unitName = newList.unitName
            val info = newList.info

            val intent = Intent(context, Zerg::class.java)
            intent.putExtra("unitName",unitName)
            intent.putExtra("info",info)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return unitList.size
    }

    inner class ZergHolder(var binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){}
}