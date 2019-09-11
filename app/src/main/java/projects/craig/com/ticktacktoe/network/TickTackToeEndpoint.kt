package projects.craig.com.ticktacktoe.network

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Craig Smith on 9/11/2019.
 */
interface TickTackToeEndpoint {

    @GET("")
    fun postGame() : Call<Game>

}