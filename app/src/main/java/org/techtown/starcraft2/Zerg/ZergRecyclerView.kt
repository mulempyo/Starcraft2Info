package org.techtown.starcraft2.Zerg

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import org.techtown.starcraft2.Starcraft2Unit
import org.techtown.starcraft2.Terran.TerranAdapter
import org.techtown.starcraft2.databinding.Terran2Binding
import org.techtown.starcraft2.databinding.Zerg2Binding

class ZergRecyclerView:AppCompatActivity() {
    val binding by lazy{ Zerg2Binding.inflate(layoutInflater)}
    lateinit var database: DatabaseReference
    private lateinit var unitList:ArrayList<Starcraft2Unit>
    private lateinit var adapter: ZergAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        unitList = ArrayList()
        adapter = ZergAdapter(this,unitList)
        binding.recyclerZerg.layoutManager = LinearLayoutManager(this)
        binding.recyclerZerg.setHasFixedSize(true)
        binding.recyclerZerg.adapter = adapter
        getUnitData()
    }
    private fun getUnitData(){
        database = FirebaseDatabase.getInstance().getReference("Zerg")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (starcraft2Snapshot in snapshot.children){
                        val starcraft2Info = starcraft2Snapshot.getValue(Starcraft2Unit::class.java)
                        unitList.add(starcraft2Info!!)
                    }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ZergRecyclerView,
                        error.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

}

