package com.example.operatorbz.domain

interface Repository {
    fun getFirstList(): List<Item>
    fun getSecondList(): List<Item>
}