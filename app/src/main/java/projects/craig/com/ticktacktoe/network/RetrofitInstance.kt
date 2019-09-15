package projects.craig.com.ticktacktoe.network

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitInstance {

    private val BASE_URL = "http://192.168.2.21:8080"

    private var retrofit: Retrofit

    constructor() {
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(KotlinModule())
        objectMapper.registerModule(Jdk8Module())
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        val factory = JacksonConverterFactory.create(objectMapper)
        factory
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .build()
    }



    fun getRetrofitInstance() : Retrofit {
        return retrofit
    }
}