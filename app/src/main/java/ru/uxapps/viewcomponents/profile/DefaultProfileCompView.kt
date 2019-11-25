package ru.uxapps.viewcomponents.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.uxapps.viewcomponents.R

class DefaultProfileCompView(parent: ViewGroup) :
    ProfileCompView {

    private var callback: ProfileCompView.Callback? = null
    private val nameTv: TextView
    private val likesTv: TextView

    init {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.v_profile, parent, false)
        parent.addView(view)

        nameTv = view.findViewById(R.id.text)
        likesTv = view.findViewById(R.id.likes)
        view.findViewById<View>(R.id.like_btn).setOnClickListener { callback?.onLikeClick() }
    }

    override fun setName(name: String) {
        nameTv.text = name
    }

    override fun setLikes(likes: Int) {
        likesTv.text = likes.toString()
    }

    override fun setCallback(callback: ProfileCompView.Callback?) {
        this.callback = callback
    }
}