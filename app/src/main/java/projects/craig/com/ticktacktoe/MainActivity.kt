package projects.craig.com.ticktacktoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.craig.kotlin.ticktacktoe.game.Game

import kotlinx.android.synthetic.main.activity_main.*
import projects.craig.com.ticktacktoe.network.RetrofitInstance
import projects.craig.com.ticktacktoe.network.TickTackToeEndpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private val buttonsList = ArrayList<View>()

    private var game: Game? = null

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

        setUpNewGame()
    }

    private fun sendPlay(v: View) {
        Log.d("TICKTACKTOE", "Sending game to server")
    }

    private fun setUpNewGame() {
        val tickTackToeEndpoint = RetrofitInstance().getRetrofitInstance().create(TickTackToeEndpoint::class.java)
        val call = tickTackToeEndpoint.getNewGame()

        val handler = object: Callback<Game> {
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                game = response.body()
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                Log.e("TICKTACKTOE", "error getting new game", t)
                Toast.makeText(this@MainActivity, "Error connecting to ticktack toe service", Toast.LENGTH_LONG).show()
            }
        }
        call.enqueue(handler)
    }
}
