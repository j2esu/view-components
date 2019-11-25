package ru.uxapps.viewcomponents

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class CompHost(val lifecycleOwner: LifecycleOwner, val vmProvider: ViewModelProvider)

val FragmentActivity.compHost: CompHost
    get() = CompHost(this, ViewModelProviders.of(this))

val Fragment.compHost: CompHost
    get() = CompHost(this, ViewModelProviders.of(this))