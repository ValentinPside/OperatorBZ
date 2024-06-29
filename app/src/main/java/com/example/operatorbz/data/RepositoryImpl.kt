package com.example.operatorbz.data

import com.example.operatorbz.R
import com.example.operatorbz.domain.Item
import com.example.operatorbz.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(): Repository {
    override fun getFirstList(): List<Item> {
        return listOf(
            Item("A0", R.string.gidroName, R.drawable.hidro, R.string.gidroText),
            Item("A1", R.string.bisName, R.drawable.bisulphat, R.string.bisText),
            Item("A2", R.string.natrName, R.drawable.natr, R.string.natrText),
            Item("A3", R.string.biocidName, R.drawable.biocid, R.string.biocidText),
            Item("A4", R.string.limeName, R.drawable.citric, R.string.limeText),
            Item("A5", R.string.energoName, R.drawable.hidro, R.string.energoText),
            Item("A6", R.string.contactorsName, R.drawable.bis_for_cons, R.string.conservationText),
            Item("A7", R.string.natrWashName, R.drawable.natr_wash, R.string.natrWashText))
    }

    override fun getSecondList(): List<Item> {
        return listOf(
            Item("B0", R.string.phName, R.drawable.ph, R.string.phText),
            Item("B1", R.string.washName, R.drawable.wash, R.string.washText),
            Item("B2", R.string.conservationInstructionName, R.drawable.conservation, R.string.conservationText),
            Item("B3", R.string.fsdName, R.drawable.fsd, R.string.fsdText),
            Item("B4", R.string.osvFiltersName, R.drawable.osv, R.string.osvFiltersText),
            Item("B5", R.string.contactorsName, R.drawable.contactors, R.string.contactorsText))
    }
}