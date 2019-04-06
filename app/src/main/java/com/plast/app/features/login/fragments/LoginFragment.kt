package com.plast.app.features.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.login.viewmodel.LoginViewModel
import com.plast.app.features.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import viewModelProvider
import javax.inject.Inject

class LoginFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: LoginViewModel

    private val RC_SIGN_IN = 1

    private lateinit var gso: GoogleSignInOptions
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var rootView: View

    companion object {
        val TAG = LoginFragment::class.java.simpleName
        fun newInstance() = LoginFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onViewReady(inflatedView: View, args: Bundle?) {

        rootView = inflatedView
        firebaseAuth = FirebaseAuth.getInstance()

        setListeners()
    }

    override fun initViewModel() {
        viewModel = viewModelProvider(vmFactory)
        viewModel.loginedLiveData.observe(this, Observer {
            if (it == true) {
                startActivity(Intent(context, MainActivity::class.java))
                activity?.finish()
            }
        })
    }

    override fun setListeners() {
        signInButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.key))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(rootView.context, gso)

        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)
                viewModel.signInViaGoogle(account)
            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }

}