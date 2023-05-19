package com.example.hsrguide.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

open class BasedFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//https://stackoverflow.com/questions/74838068/fragment-transition-has-slight-delay-when-replacing-fragment-with-another-how-d
//        test only
        if (savedInstanceState != null) {
            return
        }

        postponeEnterTransition()

        view.setBackgroundColor(0x00000000)

        view.post { postponeEnterTransition(0, TimeUnit.MILLISECONDS) }

    }
}