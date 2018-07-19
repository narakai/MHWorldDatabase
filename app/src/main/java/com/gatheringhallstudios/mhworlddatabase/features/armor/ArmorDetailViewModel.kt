package com.gatheringhallstudios.mhworlddatabase.features.armor

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.gatheringhallstudios.mhworlddatabase.AppSettings
import com.gatheringhallstudios.mhworlddatabase.data.MHWDatabase
import com.gatheringhallstudios.mhworlddatabase.data.models.ArmorComponent

import com.gatheringhallstudios.mhworlddatabase.data.models.ArmorSetBonus
import com.gatheringhallstudios.mhworlddatabase.data.models.ArmorSkill
import com.gatheringhallstudios.mhworlddatabase.data.models.Armor

class ArmorDetailViewModel(application: Application) : AndroidViewModel(application) {
    private var armorId: Int = -1
    private val dao = MHWDatabase.getDatabase(application).armorDao()

    lateinit var armor: LiveData<Armor>
    lateinit var armorSetSkill: LiveData<List<ArmorSetBonus>>
    lateinit var armorComponents: LiveData<List<ArmorComponent>>
    lateinit var armorSkill: LiveData<List<ArmorSkill>>

    fun loadArmor(armorId: Int) {
        if (this.armorId == armorId) return

        armor = dao.loadArmor(AppSettings.dataLocale, armorId)
        armorSetSkill = Transformations.switchMap(armor, ::loadArmorSetBonus)
        armorComponents = dao.loadArmorComponentViews(AppSettings.dataLocale, armorId)
        armorSkill = dao.loadArmorSkills(AppSettings.dataLocale, armorId)
    }

    fun loadArmorSetBonus(armorView: Armor): LiveData<List<ArmorSetBonus>>? {
        return armorView.armorset_bonus_id?.let {
            return dao.loadArmorSetBonus(AppSettings.dataLocale, it)
        }
    }
}