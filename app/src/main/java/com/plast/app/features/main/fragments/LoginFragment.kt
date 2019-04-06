package com.plast.app.features.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.toolbox.extensions.toastSh
import com.plast.app.features.login.viewmodel.LoginViewModel
import com.plast.app.features.main.MainActivity
import com.plast.app.features.signup.SignUpActivity
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class MainFragment : BaseFragment(),View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: LoginViewModel

    companion object {
        val TAG = LoginFragment::class.java.simpleName
        fun newInstance() = LoginFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        //setListeners()
    }

    override fun initViewModel() {
//        viewModel = ViewModelProviders
//            .of(this, vmFactory)
//            .get(LoginViewModel::class.java)
    }

    override fun setListeners() {
//        forget_password.setOnClickListener(this)
//        sign_in.setOnClickListener(this)
//        sign_in_with_facebook.setOnClickListener(this)
//        sign_up.setOnClickListener(this)
//        skip.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
//        when(v){
//            forget_password->{
//                toastSh("forget password")
//            }
//            sign_in->{
//
//            }
//            sign_in_with_facebook ->{
//
//            }
//            sign_up->{
//                startActivity(Intent(activity, SignUpActivity::class.java))
//            }
//            skip ->{
//                startActivity(Intent(activity, MainActivity::class.java))
//                activity?.finish()
//            }
//        }
    }


}