package ikbal.mulalic.lumiformapp.mainscreen

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.ui.BaseUiModel
import ikbal.mulalic.lumiformapp.Screen

@Composable
fun MainScreen(navController: NavController) {
    val viewModel: MainViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.loadData()
    }
    when (uiState) {
        is NetworkState.Error -> ShowError(uiState.throwable)
        is NetworkState.Success -> ShowData(navController, uiState.data)
    }

}

@Composable
fun ShowLoading() {
    Text(
        text = "Loading...",
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
        ,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ShowError(throwable: Throwable) {
    Text(
        text = throwable.message.orEmpty(),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(8.dp)
        ,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun ShowData(navController: NavController, items: List<BaseUiModel>) {
    val flattenedItems = recursiveList(items)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 32.dp)
    ) {
        items(flattenedItems) { (item, indent) ->
            when (item.type) {
                LumiType.PAGE, LumiType.SECTION, LumiType.TEXT -> LumiText(item, indent)
                LumiType.IMAGE -> LumiThumbnail(item, indent, navController)
            }
        }
    }
}

@Composable
fun LumiText(item: BaseUiModel, indent: Int) {
    Text(
        item.title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = (indent * 16).dp, vertical = 8.dp),
        style = when (item.type) {
            LumiType.PAGE -> MaterialTheme.typography.titleLarge
            LumiType.SECTION -> MaterialTheme.typography.bodyLarge
            LumiType.TEXT, LumiType.IMAGE -> MaterialTheme.typography.labelSmall
        }
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun LumiThumbnail(item: BaseUiModel, indent: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = (indent * 16).dp, vertical = 8.dp)
    ) {
        GlideImage(
            contentDescription = "image",
            modifier = Modifier
                .size(48.dp)
                .clickable(onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "imageUrl",
                        item.imageUrl
                    )
                    navController.navigate(Screen.Image.route)
                }),
            model = item.imageUrl,
        )
    }
}

private data class UiModel(
    val item: BaseUiModel,
    val levelIndentation: Int = 0
)

private fun recursiveList(items: List<BaseUiModel>, level: Int = 0): List<UiModel> {
    val result = mutableListOf<UiModel>()
    for (item in items) {
        result += UiModel(item, level)
        if (item.items?.isNotEmpty() == true) {
            result += recursiveList(item.items.orEmpty(), level + 1)
        }
    }
    return result
}