package com.matrix87.coroutineandretrofit.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.matrix87.coroutineandretrofit.R
import kotlinx.android.synthetic.main.dropdown_item.view.*

class SpinnerAdapter(context: Context, val list: List<SpinnerItemModel>) :
    ArrayAdapter<SpinnerItemModel>(context, 0, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    fun createItemView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val country = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.dropdown_item,
            parent,
            false
        )

        country?.let {
            view.logo.load(list[position].image){
                transformations(CircleCropTransformation())
            }
            view.txtTitle.text = list[position].title
            view.txtSubTitle.text = list[position].subtitle
        }
        return view
    }
}