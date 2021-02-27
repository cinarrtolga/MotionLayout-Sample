package com.example.motionlayout

import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.motionlayout.mockData.SliderItems
import com.example.motionlayout.model.SliderItem
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var x1 = 0.0f
    var x2 = 0.0f
    var displayItem = 0
    private lateinit var signList: List<SliderItem>
    private lateinit var item: SliderItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signList = SliderItems.getSliderItems(this)

        item = signList[displayItem]

        image_sign.setImageResource(item.image)
        title_text.text = item.title
        description_text.text = item.description
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (x1 == 0.0f) {
            x1 = ev!!.x
        }

        when (ev!!.action) {
            MotionEvent.ACTION_MOVE -> {
                x2 = ev.x

                val content = main_content

                if ((x1 < x2) && (x2.minus(x1) > 150)) {

                    if (displayItem > 0) {
                        displayItem = displayItem.minus(1)

                        content.setTransition(R.id.swipeLeft)
                        content.transitionToEnd()

                        Handler().postDelayed({
                            item = signList[displayItem]
                            image_sign.setImageResource(item.image)
                            title_text.text = item.title
                            description_text.text = item.description
                        }, 300)

                        content.setTransitionListener(object : MotionLayout.TransitionListener {
                            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                                content.setTransition(R.id.swipeLeftReset)
                                content.transitionToEnd()
                                x1 = 0.0f
                            }

                            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                                //TODO("Not yet implemented")
                            }

                            override fun onTransitionChange(
                                p0: MotionLayout?,
                                p1: Int,
                                p2: Int,
                                p3: Float
                            ) {
                                //TODO("Not yet implemented")
                            }

                            override fun onTransitionTrigger(
                                p0: MotionLayout?,
                                p1: Int,
                                p2: Boolean,
                                p3: Float
                            ) {
                                //TODO("Not yet implemented")
                            }
                        })
                    }
                } else if ((x1 > x2) && x1.minus(x2) > 150) {

                    if (displayItem + 1 < signList.count()) {

                        displayItem = displayItem.plus(1)

                        content.setTransition(R.id.swipeRight)
                        content.transitionToEnd()

                        Handler().postDelayed({
                            item = signList[displayItem]
                            image_sign.setImageResource(item.image)
                            title_text.text = item.title
                            description_text.text = item.description
                        }, 300)

                        content.setTransitionListener(object : MotionLayout.TransitionListener {
                            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                                content.setTransition(R.id.swipeRightReset)
                                content.transitionToEnd()
                                x1 = 0.0f
                            }

                            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                                //TODO("Not yet implemented")
                            }

                            override fun onTransitionChange(
                                p0: MotionLayout?,
                                p1: Int,
                                p2: Int,
                                p3: Float
                            ) {
                                //TODO("Not yet implemented")
                            }

                            override fun onTransitionTrigger(
                                p0: MotionLayout?,
                                p1: Int,
                                p2: Boolean,
                                p3: Float
                            ) {
                                //TODO("Not yet implemented")
                            }
                        })
                    }
                }

            }
            else -> ""
        }

        return super.dispatchTouchEvent(ev)
    }
}