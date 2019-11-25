package ru.uxapps.viewcomponents

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import ru.uxapps.viewcomponents.profile.ProfileComp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)
        val container = findViewById<ViewGroup>(R.id.container)

        ProfileComp(compHost, "Maria B.", container)
        ProfileComp(compHost, "Jake A.", container)
        ProfileComp(compHost, "Garry C.", container)
    }
}
