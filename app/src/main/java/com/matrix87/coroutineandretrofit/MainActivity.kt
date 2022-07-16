package com.matrix87.coroutineandretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.matrix87.coroutineandretrofit.spinner.SpinnerAdapter
import com.matrix87.coroutineandretrofit.spinner.SpinnerItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinner()
    }

    fun setSpinner(){
        val adapter = SpinnerAdapter(
            this, listOf(
                SpinnerItemModel(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiP_fno8QpPXg9RBgMWyuioW5qPrRbCjNb9Q&usqp=CAU", "Jakson", "Art"),
                SpinnerItemModel(2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX_yB8BJRSH06tEEWaKtdgug_nwozA6dN4Ww&usqp=CAU", "Messi", "Football star")
            )
        )


        customSpinner.adapter=adapter


        customSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                Toast.makeText(this@MainActivity, (parent?.getItemAtPosition(pos) as SpinnerItemModel).title, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }
}