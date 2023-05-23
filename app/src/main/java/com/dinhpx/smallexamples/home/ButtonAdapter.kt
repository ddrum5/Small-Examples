package com.dinhpx.smallexamples.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dinhpx.base.base.BaseRclvAdapter
import com.dinhpx.base.base.BaseViewHolder
import com.dinhpx.smallexamples.databinding.ItemButtonHomeBinding

class ButtonAdapter : BaseRclvAdapter() {

    var onClickItem: ((FunctionEntity) -> Unit)? = null

    override fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ButtonVH(
            ItemButtonHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ButtonVH(private val binding: ItemButtonHomeBinding) :
        BaseViewHolder<FunctionEntity>(binding) {

        init {
            binding.btnHomeItm.setOnClickListener {
                if (bindingAdapterPosition > -1) {
                    onClickItem?.invoke(
                        getListData()[bindingAdapterPosition] as FunctionEntity
                    )
                }
            }
        }

        override fun onBind(data: FunctionEntity) {
            binding.btnHomeItm.text = data.name
        }

    }
}