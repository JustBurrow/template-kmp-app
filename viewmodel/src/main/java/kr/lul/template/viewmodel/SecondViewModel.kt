package kr.lul.template.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.lul.template.model.SampleModel
import kr.lul.template.ui.state.SampleState
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val sampleModel: SampleModel
) : ViewModel() {
    companion object {
        private const val TAG = "SecondViewModel"
    }

    val id: Int = savedStateHandle["id"]
        ?: throw IllegalArgumentException("id is required.")

    private val _data = MutableStateFlow<SampleState?>(null)
    val data: StateFlow<SampleState?> = _data

    init {
        Log.d(TAG, "#init called.")

        viewModelScope.launch {
            delay(1000L)
            _data.update {
                sampleModel.read(id)?.let {
                    SampleState(it.id, it.uuid, it.version, it.createdAt)
                }
            }
        }
    }

    override fun toString() = "SecondViewModel(id=$id, data=${data.value})"
}