package com.example.toy_project_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTranslationY = tvprogress.translationY

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvprogress.text = progress.toString()
                val translationDistance = ( initialTranslationY + progress*-1*resources.getDimension(R.dimen.text_anim_step) )
                tvprogress.animate().translationY(translationDistance)
                if(!fromUser)
                    tvprogress.animate().setDuration(500).rotationBy(360f).translationY(initialTranslationY)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        btnreset.setOnClickListener { v: View ->
            seekBar.progress = 0
        }
    }
}