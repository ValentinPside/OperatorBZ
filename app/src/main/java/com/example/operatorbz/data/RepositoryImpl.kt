package com.example.operatorbz.data

import com.example.operatorbz.domain.Item
import com.example.operatorbz.domain.Repository

class RepositoryImpl: Repository {
    override fun getFirstList(): List<Item> {
        return listOf(Item("", "", "", ""), Item("", "", "", ""))
    }

    override fun getSecondList(): List<Item> {
        return listOf(Item("", "", "", ""), Item("", "", "", ""))
    }
}