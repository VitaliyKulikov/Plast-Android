package com.plast.app.features.details.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.details.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import viewModelProvider
import javax.inject.Inject

class DetailsFragment : BaseFragment(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: AppViewModelsFactory
    private lateinit var viewModel: DetailsViewModel

    private lateinit var rootView: View

    companion object {

        val TAG = DetailsFragment::class.java.simpleName
        fun newInstance() = DetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun layoutId(): Int = R.layout.fragment_details

    override fun onViewReady(inflatedView: View, args: Bundle?) {

        rootView = inflatedView

        setListeners()
    }

    override fun initViewModel() {

        viewModel = viewModelProvider(viewModelFactory)

        //TODO: LiveData and Observers

    }

    override fun setListeners() {

        btn_details.setOnClickListener(this)
        exit_btn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view) {

            exit_btn -> finishActivity()

            btn_details -> {

                // TODO: Some db stuff

                finishActivity()
            }
        }
    }

    private fun setTextToDescriptionTextView(message: String) {
        tv_details_description.text = message
    }

    private fun setTextToTitleTextView(message: String) {
        tv_details_page_title.text = message
    }

    private fun finishActivity() = activity?.finish()
}
