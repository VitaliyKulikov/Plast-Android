package com.plast.app.features.onboarding.fragments.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.plast.app.R
import com.plast.app.toolbox.extensions.loadWithGlide
import kotlinx.android.synthetic.main.fragment_on_boarding_page.*

class OnBoardingPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            title.text = it.getString("title")
            description.text = it.getString("description")
            art.loadWithGlide(resources.getDrawable(it.getInt("img_id")))
            number.loadWithGlide(resources.getDrawable(it.getInt("img_number_id")))
        }
    }
}
