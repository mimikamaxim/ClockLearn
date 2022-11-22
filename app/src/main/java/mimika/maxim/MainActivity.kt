package mimika.maxim

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mimika.maxim.databinding.TrainingBinding
import mimika.maxim.Time


class MainActivity : AppCompatActivity() {
    private lateinit var binding: TrainingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateFields()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        with(binding.control){
            buttonIncH.setOnClickListener {
                Time.hoursInc()
                updateFields()
            }
            buttonDecH.setOnClickListener {
                Time.hoursDec()
                updateFields()
            }
            buttonIncMin1.setOnClickListener {
                Time.minutesInc()
                updateFields()
            }
            buttonIncMin10.setOnClickListener {
                Time.minutesInc(10)
                updateFields()
            }
            buttonDecMin1.setOnClickListener {
                Time.minutesDec()
                updateFields()
            }
            buttonDecMin10.setOnClickListener {
                Time.minutesDec(10)
                updateFields()
            }
        }
    }
    private fun updateFields(){
        with(binding){
            with(control){
                textHours.text = Time.getHours()
                textMin.text = Time.getMin()
            }
            minuteArrow.rotation = Time.getMinRotation()
            hourArrow.rotation = Time.getHoursRotation()
        }
    }
}