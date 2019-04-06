package com.plast.app.features.main.checklist.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.checklist.viewmodel.CardViewModel
import viewModelProvider
import javax.inject.Inject

class CardFragment : BaseFragment() {

    companion object {
        val TAG = CardFragment::class.java.simpleName
        const val POSITION = "position"

        fun newInstance(position: Int) = CardFragment().apply {
            arguments = Bundle().apply { putInt(POSITION, position) }
        }
    }

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    private lateinit var viewModel: CardViewModel

    override fun layoutId(): Int = R.layout.fragment_card

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        val position = arguments!!.getInt(POSITION)

        viewModel = viewModelProvider(vmFactory)
        viewModel.cardPosition = position
        viewModel.cardLiveData.observe(this, Observer {

        })
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
    }
}
