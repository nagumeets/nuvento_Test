package com.nuvento_test.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.nuvento_test.MainActivity
import com.nuvento_test.R
import com.nuvento_test.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.d("onAnimationStart", "onAnimationStart")
            }

            override fun onAnimationEnd(animation: Animation) {
                Handler().postDelayed(Runnable() {
                    run() {
                        val intent = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }, 3000);
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.d("onAnimationRepeat", "onAnimationRepeat")
            }
        })
        binding.imgLogo.startAnimation(anim)
    }
}
