package org.techtown.starcraft2.Zerg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.techtown.starcraft2.databinding.ZergBinding

class Zerg:AppCompatActivity() {
    val binding by lazy { ZergBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val unitName = intent.getStringExtra("Name")
        val unitInfo = intent.getStringExtra("info")
        binding.name.text = unitName
        binding.info.text = unitInfo

    }
}