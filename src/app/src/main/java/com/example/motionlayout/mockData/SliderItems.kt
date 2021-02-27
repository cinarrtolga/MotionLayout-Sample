package com.example.motionlayout.mockData

import android.content.Context
import com.example.motionlayout.R
import com.example.motionlayout.model.SliderItem

class SliderItems {
    companion object Contents {
        fun getSliderItems(context: Context): List<SliderItem> {
            val items = arrayListOf<SliderItem>()

            items.add(SliderItem(1, R.drawable.no_u_turn, "No U Turns", "The no u-turn sign is designed to stop vehicles from turning onto the other side where it may be dangerous to other vehicles. "))
            items.add(SliderItem(2, R.drawable.no_turn_right, "No Turn Right", "The use of diagram 612 shows where turning right at a junction is prohibited."))
            items.add(SliderItem(3, R.drawable.level_crossing, "Level Crossing", "Level crossing signs are typically found on the approach to a crossing to warn drivers of the hazard ahead."))
            items.add(SliderItem(4, R.drawable.max_speed, "Max Speed", "The basic speed limit sign, which has been around for decades, is a red circle with a black number contained within it."))
            items.add(SliderItem(5, R.drawable.double_bend, "Double Bend Sign", "The warning triangle alone warns of a double bend, but accompanied by a supplementary plate detailing a distance which the hazard extends over warns of a series of bends over that distance"))
            items.add(SliderItem(6, R.drawable.road_work, "Road Working", "Throughout your driving career you will encounter road works on many occasions. Typically on single carriageway roads you will often see a road works warning sign initially to warn of the hazard ahead, followed by the ‘When red light shows wait here’ sign."))

            return items
        }
    }
}
