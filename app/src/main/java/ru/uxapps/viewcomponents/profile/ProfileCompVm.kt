package ru.uxapps.viewcomponents.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileCompVm : ViewModel() {

    private val modelsMap: MutableMap<String, ProfileModelImp> = mutableMapOf()

    fun getModel(key: String): ProfileCompModel {
        var model = modelsMap[key]
        if (model == null) {
            model = ProfileModelImp(key)
            modelsMap[key] = model
        }
        return model
    }
}

class ProfileModelImp(userId: String) : ProfileCompModel {

    override val name = MutableLiveData<String>().apply { value = userId }
    override val likes = MutableLiveData<Int>().apply { value = 0 }

    override fun like() {
        likes.value = likes.value?.inc()
    }
}