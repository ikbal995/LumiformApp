package ikbal.mulalic.data.remote

import ikbal.mulalic.data.remote.dto.PageDto
import retrofit2.http.GET

interface ApiService {
    @GET("f118b9f0-6f84-435e-85d5-faf4453eb72a")
    suspend fun getPages(): PageDto
}