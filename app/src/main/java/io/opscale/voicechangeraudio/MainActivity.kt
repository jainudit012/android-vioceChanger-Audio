package io.opscale.voicechangeraudio

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"
private const val PERMISSIONS_REQUEST_CODE = 101

class MainActivity : AppCompatActivity() {
    private val freqSet = arrayListOf("Normal", "Helium", "Male", "Female", "Chipmunk", "Robot")
    private lateinit var spFrequency: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spFrequency = frequency as Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, freqSet)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spFrequency.adapter = adapter


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            ActivityCompat.requestPermissions(this, permissions,PERMISSIONS_REQUEST_CODE)
        }else {

        }

    }
}
