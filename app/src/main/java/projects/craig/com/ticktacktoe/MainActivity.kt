package projects.craig.com.ticktacktoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val buttonsList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonsList.add(top_one)
        buttonsList.add(top_two)
        buttonsList.add(top_three)

        buttonsList.add(middle_one)
        buttonsList.add(middle_two)
        buttonsList.add(middle_three)

        buttonsList.add(bottom_one)
        buttonsList.add(bottom_two)
        buttonsList.add(bottom_three)

        buttonsList.forEach { it.setOnClickListener(this::sendPlay) }
    }

    private fun sendPlay(v: View) {

    }
}
