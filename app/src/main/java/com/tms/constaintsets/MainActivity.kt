package com.tms.constaintsets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    private lateinit var layout:ConstraintLayout
    private lateinit var constraintSetOld:ConstraintSet
    private lateinit var constraintSetNew:ConstraintSet
    private var altLayoutValue:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.layout)

        constraintSetOld = ConstraintSet()
        constraintSetNew = ConstraintSet()

        constraintSetOld.clone(layout)
        constraintSetNew.clone(this, R.layout.activiry_mail_alt)

    }


    fun swapView(view: View) {

        TransitionManager.beginDelayedTransition(layout)

        if (!altLayoutValue) {
            constraintSetNew.applyTo(layout)
            altLayoutValue = true
        }
        else {
            constraintSetOld.applyTo(layout)
            altLayoutValue = false
        }
    }
}
