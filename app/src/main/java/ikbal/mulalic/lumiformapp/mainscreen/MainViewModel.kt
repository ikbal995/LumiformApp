package ikbal.mulalic.lumiformapp.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ikbal.mulalic.data.LumiType
import ikbal.mulalic.data.local.entity.toUiModel
import ikbal.mulalic.data.ui.BaseUiModel
import ikbal.mulalic.data.ui.Page
import ikbal.mulalic.data.ui.Question
import ikbal.mulalic.data.ui.Section
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _items = MutableStateFlow<List<BaseUiModel>>(emptyList())
    val items: StateFlow<List<BaseUiModel>> = _items.asStateFlow()

    fun fetchItemsFromDb() {
        viewModelScope.launch {
            repository.getItems().collect { itemList ->
                _items.value = itemList.map { item ->
                    when (item.type) {
                        LumiType.PAGE -> Page(
                            type = item.type,
                            title = item.title,
                            items = item.items?.map { it.toUiModel() }.orEmpty()
                        )

                        LumiType.SECTION -> Section(
                            type = item.type,
                            title = item.title,
                            items = item.items?.map { it.toUiModel() }.orEmpty()
                        )

                        LumiType.TEXT, LumiType.IMAGE -> Question(
                            type = item.type,
                            title = item.title,
                            imageUrl = item.src
                        )
                    }
                }
            }
        }
    }

    fun fetchItemsFromApi() {
        viewModelScope.launch {
            repository.fetchOrRefresh()
        }
    }
}