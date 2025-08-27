package com.example.consultordecerveja

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.caixaSelecao)
        textView = findViewById(R.id.resultado)
        button = findViewById(R.id.buscarCerveja)

        val tipoCerveja = listOf("Pilsen", "IPA", "Lager", "Amber")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            tipoCerveja
        )
        spinner.adapter = adapter

        button.setOnClickListener {
            val selecionado = spinner.selectedItem.toString()

            val pilsen = listOf("Brahma", "Skol", "Antartica")
            val ipa = listOf("Colorado Indica", "Dogma Modern IPA")
            val lager = listOf("Heineken", "Stella Artois")
            val amber = listOf("Killian’s", "Colorado Vixnu")

            val resultado = when (selecionado) {
                "Pilsen" -> pilsen
                "IPA" -> ipa
                "Lager" -> lager
                "Amber" -> amber
                else -> emptyList()
            }

            textView.text = resultado.joinToString(separator = "\n")
        }
    }
}