package projects.craig.com.ticktacktoe.network

import retrofit2.Call
import retrofit2.http.GET
import com.craig.kotlin.ticktacktoe.game.Game
import retrofit2.http.POST

/**
 * Created by Craig Smith on 9/11/2019.
 */
interface TickTackToeEndpoint {

    @POST("/ticktacktoe/play")
    fun postGame(game: Game) : Call<Game>

    @GET("/ticktacktoe/newGame")
    fun getNewGame(): Call<Game>

}