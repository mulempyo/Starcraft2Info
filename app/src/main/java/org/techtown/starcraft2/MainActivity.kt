package org.techtown.starcraft2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory
import org.techtown.starcraft2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        val firebaseAppCheck = FirebaseAppCheck.getInstance()
        firebaseAppCheck.installAppCheckProviderFactory(
            DebugAppCheckProviderFactory.getInstance()
        )
        //FirebaseApp.initializeApp(this)
        firebaseAppCheck.installAppCheckProviderFactory(
            SafetyNetAppCheckProviderFactory.getInstance()
        )

        binding.youtubeButton.setOnClickListener {
            val intent = Intent(this,NewsActivity::class.java)
            startActivity(intent)
        }
        binding.gameInfoButton.setOnClickListener {
            val intent = Intent(this,GameInfoActivity::class.java)
            startActivity(intent)
        }

    }

}




