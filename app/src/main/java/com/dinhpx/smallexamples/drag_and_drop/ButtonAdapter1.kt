package com.dinhpx.smallexamples.drag_and_drop

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dinhpx.base.base.BaseRclvAdapter
import com.dinhpx.base.base.BaseViewHolder
import com.dinhpx.smallexamples.databinding.ItemButtonHomeBinding
import com.dinhpx.smallexamples.home.FunctionEntity

class ButtonAdapter1 : BaseRclvAdapter() {



    override fun createVH(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ButtonVH(
            ItemButtonHomeBinding.inflate(layoutInflater, parent, false)
        )
    }

    inner class ButtonVH(private val binding: ItemButtonHomeBinding) :
        BaseViewHolder<FunctionEntity>(binding) {

        init {

            binding.root.setOnLongClickListener { view ->
                val data = ClipData.newPlainText("", "word")
                val shadowBuilder = View.DragShadowBuilder(view)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    view.startDragAndDrop(data, shadowBuilder, view, 0)
                } else {
                    view.startDrag(data, shadowBuilder, view, 0)
                }
                true
            }
        }

        override fun onBind(data: FunctionEntity) {
            binding.btnHomeItm.text = data.name
        }

    }
}