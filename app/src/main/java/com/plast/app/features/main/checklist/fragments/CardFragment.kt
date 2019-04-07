package com.plast.app.features.main.checklist.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.checklist.viewmodel.CardViewModel
import com.plast.app.models.CURRENT
import com.plast.app.models.CardModel
import com.plast.app.models.DONE
import com.plast.app.models.LOCKED
import com.plast.app.toolbox.extensions.hide
import com.plast.app.toolbox.extensions.show
import kotlinx.android.synthetic.main.fragment_card.*
import viewModelProvider
import javax.inject.Inject

class CardFragment : BaseFragment() {

    companion object {
        val TAG = CardFragment::class.java.simpleName
        const val POSITION = "position"
        const val FIRST_ITEM = 1

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
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
    }

    private fun setData(cm: CardModel) {
        startDash(cm)
        setCardState(cm)
        setCardName(cm)
        setPlustCoin(cm)
        setCardImage(cm)
        tv_title.text = getString(cm.titleResId)
        tv_description.text = getString(cm.descriptionResId)
    }

    private fun startDash(cardModel: CardModel) {
        tv_start_dash.apply {
            if (isFirstItem(cardModel)) {
                hide()
            } else {
                show()
            }
        }
    }

    private fun setCardState(cm: CardModel) {
        when (cm.cardState) {
            DONE -> {
                topStatusNumber("✓", R.drawable.shape_circle_accent)
                lockViews(false, R.drawable.ic_unlocked)
                view_inactive.hide()
            }
            CURRENT -> {
                topStatusNumber(cm.cardPos.toString(), R.drawable.shape_circle_accent)
                lockViews(false, R.drawable.ic_unlocked)
                view_inactive.hide()
            }
            LOCKED -> {
                topStatusNumber(cm.cardPos.toString(), R.drawable.shape_circle_gray)
                lockViews(true, R.drawable.ic_locked)
                view_inactive.show()
            }
        }
    }

    private fun setCardName(cm: CardModel) {
        tv_name.text = "Завдання ${cm.cardPos}"
    }

    private fun setPlustCoin(cm: CardModel) {
        tv_plustcoins.text = "+${cm.plastCoin} пласткоїнів"
    }

    private fun setCardImage(cm: CardModel) {
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

    private fun getDrawable(resId: Int): Drawable = ContextCompat.getDrawable(context!!, resId)!!

    private fun isFirstItem(cardModel: CardModel) = cardModel.cardPos == FIRST_ITEM
}
