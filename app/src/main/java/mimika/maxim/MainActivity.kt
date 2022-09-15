package mimika.maxim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DigitalClock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training)
        val time = findViewById<DigitalClock>(R.id.digit)
        Log.e("AA", time.toString())
    }
}