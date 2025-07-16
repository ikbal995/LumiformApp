package ikbal.mulalic.data.remote

import ikbal.mulalic.data.remote.dto.BaseDto
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getPages(): BaseDto
}