package com.fgomes.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.fgomes.santanderdevweek.R
import com.fgomes.santanderdevweek.data.Conta
import com.fgomes.santanderdevweek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        getContaCliente()

        //throw RuntimeException("Test Crash") // Force a crash
    }

    private fun getContaCliente(){
        mainViewModel.getContaCliente().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta){
        binding.tvNameUser.text = conta.cliente.nome
        binding.tvAgenciaNumber.text = conta.agencia
        binding.tvNumberConta.text = conta.numero
        binding.tvSaldoLimiteValor.text = conta.limite
        binding.tvSaldoAtual.text = conta.saldo
        binding.tvCardFinalNumber.text = conta.cartao.numeroConta
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.item_1 -> {
                Log.d("Menu", "Teste menu 1")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}