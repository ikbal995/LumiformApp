package ikbal.mulalic.lumiformapp.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ikbal.mulalic.data.local.entity.toUiModel
import ikbal.mulalic.data.ui.BaseUiModel
import ikbal.mulalic.data.ui.Page
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _items = MutableStateFlow<List<Page>>(emptyList())
    val items: StateFlow<List<Page>> = _items.asStateFlow()

    fun fetchItemsFromDb() {
        viewModelScope.launch {
            repository.getItems().collect { itemList ->
                _items.value = itemList.map { item -> item.toUiModel() }
            }
        }
    }

    fun fetchItemsFromApi() {
        viewModelScope.launch {
            repository.fetchOrRefresh()
        }
    }
}