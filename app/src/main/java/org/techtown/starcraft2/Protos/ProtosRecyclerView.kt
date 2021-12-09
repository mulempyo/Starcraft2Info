package org.techtown.starcraft2.Protos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import org.techtown.starcraft2.Starcraft2Unit
import org.techtown.starcraft2.Terran.TerranAdapter
import org.techtown.starcraft2.databinding.Protos2Binding
import org.techtown.starcraft2.databinding.Terran2Binding

class ProtosRecyclerView:AppCompatActivity() {
    val binding by lazy{ Protos2Binding.inflate(layoutInflater)}
    lateinit var database: DatabaseReference
    private lateinit var unitList:ArrayList<Starcraft2Unit>
    private lateinit var adapter: ProtosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        unitList = ArrayList()
        adapter = ProtosAdapter(this,unitList)
        binding.recyclerProtos.layoutManager = LinearLayoutManager(this)
        binding.recyclerProtos.setHasFixedSize(true)
        binding.recyclerProtos.adapter = adapter
        getUnitData()
    }
    private fun getUnitData(){
        database = FirebaseDatabase.getInstance().getReference("Protos")
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
                Toast.makeText(this@ProtosRecyclerView,
                        error.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

}
