package com.plast.app.features.main.checklist.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.checklist.viewmodel.CardViewModel
import com.plast.app.data.local.database.entity.CURRENT
import com.plast.app.data.local.database.entity.CardEntity
import com.plast.app.data.local.database.entity.DONE
import com.plast.app.data.local.database.entity.LOCKED
import com.plast.app.toolbox.extensions.gone
import com.plast.app.toolbox.extensions.hide
import com.plast.app.toolbox.extensions.show
import kotlinx.android.synthetic.main.fragment_card.*
import viewModelProvider
import javax.inject.Inject

class CardFragment : BaseFragment(), View.OnClickListener {

    companion object {
        val TAG = CardFragment::class.java.simpleName
        const val POSITION = "position"
        const val FIRST_ITEM = 0

        fun newInstance(position: Int) = CardFragment().apply {
            arguments = Bundle().apply { putInt(POSITION, position) }
        }
    }

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    private lateinit var viewModel: CardViewModel

    private val currentUserCheckPoint: Int = 3

    override fun layoutId(): Int = R.layout.fragment_card

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        val position = arguments!!.getInt(POSITION)

        viewModel = viewModelProvider(vmFactory)
        viewModel.cardPosition = position
        viewModel.currentUserCheckPoint = currentUserCheckPoint
        viewModel.cardLiveData.observe(this, Observer { setData(it) })
        viewModel.getItems()
        viewModel.cardDao.observe(this, Observer {
            val a =it
        })
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
        card_view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            card_view -> onClickCard()
        }
    }

    private fun setData(cm: CardEntity) {
        startDash(cm)
        setCardState(cm)
        setCardName(cm)
        setPlustCoin(cm)
        setCardImage(cm)
        tv_title.text = getString(cm.titleResId)
        tv_description.text = getString(cm.descriptionResId)
    }

    private fun startDash(cardEntity: CardEntity) {
        tv_start_dash.apply {
            if (isFirstItem(cardEntity)) {
                hide()
            } else {
                show()
            }
        }
    }

    private fun setCardState(cm: CardEntity) {
        when (cm.cardState) {
            DONE -> {
                topStatusNumber("✓", R.drawable.shape_circle_accent)
                lockViews(false, R.drawable.ic_unlocked)
                view_inactive.gone()
            }
            CURRENT -> {
                topStatusNumber(cm.cardPos.toString(), R.drawable.shape_circle_accent)
                lockViews(false, R.drawable.ic_unlocked)
                view_inactive.gone()
            }
            LOCKED -> {
                topStatusNumber(cm.cardPos.toString(), R.drawable.shape_circle_gray)
                lockViews(true, R.drawable.ic_locked)
                view_inactive.show()
            }
        }
    }

    private fun setCardName(cm: CardEntity) {
        tv_name.text = "Завдання ${cm.cardPos}"
    }

    private fun setPlustCoin(cm: CardEntity) {
        tv_plustcoins.text = "+${cm.plastCoin} пласткоїнів"
    }

    private fun setCardImage(cm: CardEntity) {
        iv_card.setImageResource(cm.imageRes)
    }

    private fun topStatusNumber(progressStatus: String, shapeDrawable: Int) {
        tv_status_progress.text = progressStatus
        tv_status_progress.background = getDrawable(shapeDrawable)
    }

    private fun lockViews(ishow: Boolean, resId: Int) {
        tv_lock.apply {
            if (ishow) {
                show()
            } else {
                hide()
            }
        }

        iv_lock.setImageResource(resId)
    }

    private fun onClickCard() {
        viewModel.mCurrentCardEntity.apply {
            if (cardPos <= currentUserCheckPoint) {
                Toast.makeText(context, cardPos.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getDrawable(resId: Int): Drawable = ContextCompat.getDrawable(context!!, resId)!!

    private fun isFirstItem(cardEntity: CardEntity) = cardEntity.cardPos == FIRST_ITEM
}
