package ikbal.mulalic.lumiformapp.mainscreen

sealed class NetworkState<out T> {
    data class Success<out T>(val data: T) : NetworkState<T>()
    data class Error(val throwable: Throwable) : NetworkState<Nothing>()
}