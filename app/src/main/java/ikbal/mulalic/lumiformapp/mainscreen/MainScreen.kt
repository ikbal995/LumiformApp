package ikbal.mulalic.lumiformapp.mainscreen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    val viewModel: MainViewModel = hiltViewModel()
    val items = viewModel.items.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchItemsFromApi()
        viewModel.fetchItemsFromDb()
    }
    Log.e("TEST123", "Items: ${items.value}")
}