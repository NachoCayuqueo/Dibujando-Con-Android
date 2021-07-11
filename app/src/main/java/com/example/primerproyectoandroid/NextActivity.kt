package com.example.primerproyectoandroid

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NextActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        supportActionBar?.hide() //oculto la barra de titulo

        /**Recupero el boton**/
        val buttonGoBack = findViewById<Button>(R.id.button_go_back)

        buttonGoBack.setOnClickListener {
            finish()
        }
    }
}