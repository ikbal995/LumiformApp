package ikbal.mulalic.lumiformapp.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun ImageScreen(navController: NavController, imageUrl: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        LumiImage(imageUrl)
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LumiImage(imageUrl: String) {
    GlideImage(contentDescription = "image", modifier = Modifier.fillMaxSize(), model = imageUrl)
}