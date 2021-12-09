package org.techtown.starcraft2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.techtown.starcraft2.Protos.ProtosRecyclerView
import org.techtown.starcraft2.Terran.TerranRecyclerView
import org.techtown.starcraft2.Zerg.ZergRecyclerView
import org.techtown.starcraft2.databinding.GameInfoBinding

class GameInfoActivity:AppCompatActivity() {
    val binding by lazy{GameInfoBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.terranButton.setOnClickListener {
            val intent = Intent(this, TerranRecyclerView::class.java)
            startActivity(intent)
        }
        binding.protosButton.setOnClickListener {
            val intent = Intent(this, ProtosRecyclerView::class.java)
            startActivity(intent)
        }
        binding.zergButton.setOnClickListener {
            val intent = Intent(this, ZergRecyclerView::class.java)
            startActivity(intent)
        }
    }
}