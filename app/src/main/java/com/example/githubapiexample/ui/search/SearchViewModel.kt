package com.example.githubapiexample.ui.search

import android.util.EventLog
import androidx.lifecycle.*
import com.example.githubapiexample.domain.SearchUseCase
import com.example.githubapiexample.domain.UseCase
import com.example.githubapiexample.model.SearchUserResult
import com.example.githubapiexample.utils.logging.LoggingHelper

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
    private val loggingHelper: LoggingHelper
) : ViewModel() {
    companion object {
        private const val TAG = "SearchViewModel"
    }
    private val searchUserResult = MediatorLiveData<UseCase.Result<SearchUserResult>>()
    private val query = MutableLiveData<String>()
    private val result : LiveData<SearchUserResult>

    private val shouldShowNoResultsText : LiveData<Boolean>
    private val shouldShowResults : LiveData<Boolean>
    private val isLoading = MediatorLiveData<Boolean>()

    //private val showToastEvent = MediatorLiveData<Event<Int>>
    //private val openUserDetailsActivityEvent = MutableLiveData<Event<String>>

    init {
        result = Transformations.map(searchUserResult) {
          result -> (result as? UseCase.Result.Success)?.data
        }

        shouldShowNoResultsText = Transformations.map(searchUserResult) { result ->
            if (result is UseCase.Result.Success) {
                return@map result.data.totalCount == 0L
            } else {
                return@map false
            }
        }

        shouldShowResults = Transformations.map(searchUserResult) {result ->
            result is UseCase.Result.Success
        }

        isLoading.addSource(searchUserResult) { result ->
            if (result != null) {
                isLoading.value = result is UseCase.Result.Loading
            }
        }
    }
}