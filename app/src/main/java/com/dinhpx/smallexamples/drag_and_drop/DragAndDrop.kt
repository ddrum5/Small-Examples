package com.dinhpx.smallexamples

import android.view.DragEvent
import android.view.View
import androidx.fragment.app.viewModels
import com.dinhpx.base.base.BaseFragment
import com.dinhpx.base.base.BaseViewModel
import com.dinhpx.smallexamples.databinding.FragmentDragAndDropBinding
import com.dinhpx.smallexamples.drag_and_drop.ButtonAdapter1
import com.dinhpx.smallexamples.drag_and_drop.ButtonAdapter2
import com.dinhpx.smallexamples.home.MainViewModel

class DragAndDrop : BaseFragment() {
    override val binding by lazy {
        FragmentDragAndDropBinding.inflate(layoutInflater)
    }
    override val viewModel by viewModels<MainViewModel>()

    private val wordsAdapter by lazy { ButtonAdapter1() }
    private val sentenceAdapter by lazy { ButtonAdapter2() }

    override fun initView() {
        binding.rvSentence.setOnDragListener(
            DropListener {
                /*wordsAdapter.removeItem(selectedWord) // remove dropped word from word box
                sentenceAdapter.addItem(selectedWord) // add dropped word to sentence*/
            }
        )

        binding.rvSentence.adapter = sentenceAdapter
        binding.rvWords.adapter = wordsAdapter
        wordsAdapter.resetData(viewModel.listFunction)
    }

    override fun initObserve() {

    }

    override fun initListener() {

    }
}

class DropListener(private val onDrop: () -> Unit) : View.OnDragListener {
    override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
        when (dragEvent.action) {
            // when item has been dropped, notify about it
            DragEvent.ACTION_DROP -> onDrop()
        }

        return true
    }
}