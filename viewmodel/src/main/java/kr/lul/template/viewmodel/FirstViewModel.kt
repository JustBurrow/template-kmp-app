package kr.lul.template.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.lul.template.model.SampleModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val sampleModel: SampleModel
) : ViewModel() {
    companion object {
        private const val TAG = "FirstViewModel"
    }

    private val _list = MutableStateFlow(emptyList<Int>())
    val list: StateFlow<List<Int>> = _list

    init {
        Log.d(TAG, "#init called.")

        viewModelScope.launch {
            _list.update {
                sampleModel.list().map { it.id }
            }
        }
    }

    override fun toString() = "FirstViewModel(list=${list.value})"
}