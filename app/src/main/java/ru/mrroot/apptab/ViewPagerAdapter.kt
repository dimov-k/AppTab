package ru.mrroot.apptab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.mrroot.apptab.ui.home.FragmentHome
import ru.mrroot.apptab.ui.home.schedule.FragmentSchedule




class ViewPagerAdapter(fragment: FragmentActivity, private var itemCount: Int) : FragmentStateAdapter(fragment) {

    private val EARTH_HOME = 0
    private val MARS_SCHEDULE = 1

    private val fragments = arrayOf(FragmentHome(), FragmentSchedule())

    override fun getItemCount(): Int = itemCount
    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> fragments[EARTH_HOME]
            1 -> fragments[MARS_SCHEDULE]
            else -> fragments[EARTH_HOME]
        }

    }

}