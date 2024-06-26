package com.example.operatorbz.data

import com.example.operatorbz.R
import com.example.operatorbz.domain.Item
import com.example.operatorbz.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(): Repository {
    override fun getFirstList(): List<Item> {
        return listOf(
            Item("A0", "Раствор бисульфита", R.drawable.bisulphat, R.string.bisText),
            Item("A1", "Раствор едкого натра", R.drawable.natr, R.string.natrText))
    }

    override fun getSecondList(): List<Item> {
        return listOf(
            Item("B0", "Калибровка датчика pH", R.drawable.placeholder, R.string.phText),
            Item("B1", "Химическая мойка", R.drawable.placeholder, R.string.washText))
    }
}