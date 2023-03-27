package me.lbnkosi.touchsides

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.lbnkosi.touchsides.data.network.RemoteErrorEmitter
import me.lbnkosi.touchsides.domain.enums.ResourceStatus
import me.lbnkosi.touchsides.domain.model.Error
import me.lbnkosi.touchsides.domain.model.ErrorType
import me.lbnkosi.touchsides.domain.model.Result
import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse
import me.lbnkosi.touchsides.domain.usecase.TouchsideApiUseCase
import javax.inject.Inject

@HiltViewModel
class TouchsidesViewModel @Inject constructor(private val useCase: TouchsideApiUseCase): ViewModel(), RemoteErrorEmitter {

    val result: LiveData<TouchsidesApiResponse?>
        get() = _result

    private var _result: MutableLiveData<TouchsidesApiResponse?> = MutableLiveData(TouchsidesApiResponse())

    fun fetchResults(link: String) {
        viewModelScope.launch {
            useCase.analyseText(this@TouchsidesViewModel, link)?.collect {
                if (it?.resourceStatus == ResourceStatus.SUCCESS) {
                    _result.value = it.data
                }
            }
        }
    }

    override fun onError(msg: String) {
        _result.value = TouchsidesApiResponse().apply {
            status = "Failed"
            error = Error().apply {
                error = msg
                errorCode = 1
                message = msg
            }
        }
    }

    override fun onError(msg: String?, errorType: ErrorType) {
        _result.value = TouchsidesApiResponse().apply {
            status = "Failed"
            error = Error().apply {
                error = msg
                errorCode = 2
                message = msg
            }
        }
    }

}