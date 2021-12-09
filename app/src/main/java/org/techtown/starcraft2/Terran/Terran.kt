package org.techtown.starcraft2.Terran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import org.techtown.starcraft2.R
import org.techtown.starcraft2.databinding.TerranBinding
import org.techtown.starcraft2.getProgressDrawable
import org.techtown.starcraft2.loadImage

class Terran:AppCompatActivity() {
    val binding by lazy { TerranBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val unitName = intent.getStringExtra("Name")
        val unitInfo = intent.getStringExtra("info")
        val img = intent?.getStringExtra("img")
        binding.name.text = unitName
        binding.info.text = unitInfo
        binding.img.loadImage(img, getProgressDrawable(this))


        }
}