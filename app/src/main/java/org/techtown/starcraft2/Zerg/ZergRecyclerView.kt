package org.techtown.starcraft2.Zerg

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.database.*
import org.techtown.starcraft2.Starcraft2Unit
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
        getUnitData()
        FirebaseApp.initializeApp(this)
        val firebaseAppCheck = FirebaseAppCheck.getInstance()
        firebaseAppCheck.installAppCheckProviderFactory(
                DebugAppCheckProviderFactory.getInstance()
        )
    }
    private fun getUnitData(){
        database = FirebaseDatabase.getInstance().getReference("Zerg")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (animalSnapshot in snapshot.children){
                        val animal = animalSnapshot.getValue(Starcraft2Unit::class.java)
                        unitList.add(animal!!)
                    }
                    binding.recyclerZerg.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ZergRecyclerView,
                        error.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

}

