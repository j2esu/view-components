package ru.uxapps.viewcomponents.profile

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ru.uxapps.viewcomponents.CompHost

class ProfileComp(host: CompHost, key: String, view: ProfileCompView) {

    constructor(host: CompHost, key: String, parent: ViewGroup)
            : this(host, key, DefaultProfileCompView(parent))

    init {
        view.bind(host.vmProvider[ProfileCompVm::class.java].getModel(key), host.lifecycleOwner)
    }
}

private fun ProfileCompView.bind(model: ProfileCompModel, owner: LifecycleOwner) {
    model.name.observe(owner, Observer { setName(it) })
    model.likes.observe(owner, Observer { setLikes(it) })
    setCallback(object : ProfileCompView.Callback {
        override fun onLikeClick() = model.like()
    })
}

interface ProfileCompModel {

    val name: LiveData<String>
    val likes: LiveData<Int>

    fun like()

}

interface ProfileCompView {

    interface Callback {
        fun onLikeClick()
    }

    fun setName(name: String)
    fun setLikes(likes: Int)
    fun setCallback(callback: Callback?)

}