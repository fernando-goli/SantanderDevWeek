package com.fgomes.santanderdevweek.data.local

import com.fgomes.santanderdevweek.data.Cartao
import com.fgomes.santanderdevweek.data.Cliente
import com.fgomes.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        val cliente = Cliente("Fernando")
        val cartao = Cartao("1854")
        val conta = Conta(
            "19876-4",
            "456540",
            "R$ 1.210,00",
            "R$ 2.630,00",
            cliente,
            cartao
        )

        return conta
    }
}