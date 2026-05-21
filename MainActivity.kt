package com.example.applistacompras

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lvProdutos = findViewById<ListView>(R.id.lvProdutos)
        val txtProduto = findViewById<EditText>(R.id.txtProduto)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        lvProdutos.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
            produtosAdapter.add(produto)
                txtProduto.text.clear()
            } else {
                txtProduto.error = "Coloque um produto"
            }
        }

        lvProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)

            produtosAdapter.remove(item)




        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}