package com.example.viewpagertask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.DisplayMetrics
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.marginRight
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  //  lateinit var dots :LinearLayout
    lateinit var adapter: Adapter
  //  lateinit var viewPager2: ViewPager2
    lateinit var textView: ArrayList<TextView>
    lateinit var colorpicker:ArrayList<Int>

    lateinit var list:ArrayList<ViewPagerModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorpicker= arrayListOf<Int>(resources.getColor(R.color.black),
            resources.getColor(R.color.black),
            resources.getColor(R.color.black))



        list= arrayListOf(ViewPagerModel("Beauty Ideas For The \n        patriotic ones",R.drawable.a,"Celebrating India"),
            ViewPagerModel("Beauty Ideas For The \n       patriotic ones",R.drawable.b,"Celebrating India")
            ,ViewPagerModel("Beauty Ideas For The \n       patriotic ones",R.drawable.c,"Celebrating India"))

        adapter=Adapter(list,this)

        viewpager.adapter=adapter



        with(viewpager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        viewpager.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }



   viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                selectinditor(position)
                super.onPageSelected(position)

            }
        })



        textView = arrayListOf(TextView(this),TextView(this),TextView(this))

        dotsIndicator()




    }

    private fun selectinditor(position: Int) {

        for (i in 0..2){

            if (i==position){
                textView[i].setTextColor(colorpicker[position])
            }
            else{


                textView[i].setTextColor(resources.getColor(R.color.silver))

            }
        }

    }

    private fun dotsIndicator() {
        for (i in 0..2){

            textView[i] = TextView(this)
            textView[i].setText(Html.fromHtml("&#9679;"))
                textView[i].setTextSize(10F)
            textView[i].setPadding(5,0,5,0)

              dotslayout.addView(textView[i])


        }
    }
}