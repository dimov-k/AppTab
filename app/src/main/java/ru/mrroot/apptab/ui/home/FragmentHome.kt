package ru.mrroot.apptab.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.mrroot.apptab.databinding.FragmentHomeBinding
import ru.mrroot.apptab.data.DataLesson
import ru.mrroot.apptab.ui.home.lesson.ListLessonAdapter
import ru.mrroot.apptab.ui.home.timer.TimerExam
import java.util.*

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        timerStart()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListLessonAdapter(DataLesson().getLessons())
        binding.lessons.mainRecycler.adapter = adapter
    }

    private fun timerStart() {
        val timer = Timer()
        val examDay = Calendar.getInstance()
        examDay.add(Calendar.DAY_OF_MONTH, +2)

        val timerExam = TimerExam(binding, examDay)
        timer.schedule(timerExam, 1000, 5000)
    }

}

