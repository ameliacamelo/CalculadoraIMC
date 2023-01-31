package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvimc = findViewById<TextView>(R.id.textview_imc)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val imc = intent.getFloatExtra( "EXTRA_RESULT",0.1f)

        tvimc.text = imc.toString()

        /*TABELA IMC
        	< 18,5				    ABAIXO DO PESO
            >= 18,5 && <= 24,9	    NORMAL
        	>= 25.0f && <= 29.9f	SOBREPESO
        	>= 30.0f && <= 39.9f	OBESIDADE
        	>= 40.0f				OBESIDADE GRAVE*/

        val classificacao = if (imc < 18.5f){
            "ABAIXO DO PESO"
        }else if (imc in 18.5f..24.9f){
            "NORMAL"
        }else if (imc in 25.0f..29.9f){
            "SOBREPESO"
        }else if (imc in 30.0f..39.9f){
            "OBESIDADE"
        }else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}