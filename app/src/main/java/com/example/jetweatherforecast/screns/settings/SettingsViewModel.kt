package com.example.jetweatherforecast.screns.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetweatherforecast.model.Favorite
import com.example.jetweatherforecast.model.Unit
import com.example.jetweatherforecast.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: WeatherDbRepository)
    : ViewModel() {

    private val _unitList = MutableStateFlow<List<Unit>>( emptyList() )

    val unitList = _unitList.asStateFlow()

    init {
        viewModelScope.launch( Dispatchers.IO ) {
            repository.getunits().distinctUntilChanged()
                .collect {listOfUnits ->

                    if ( listOfUnits.isNullOrEmpty() ) {

                        Log.d( "TAG", ": Empty list" )

                    }else {

                        _unitList.value = listOfUnits
                        //Log.d( "FAVORITES" , ":${ unitList.value } " )

                    }

                }
        }
    }

    fun insertFavorite( unit: Unit ) = viewModelScope.launch { repository.insertUnit( unit ) }

    fun updateFavorite( unit: Unit ) = viewModelScope.launch { repository.updateUnit( unit ) }

    fun deleteFavorite( unit: Unit ) = viewModelScope.launch { repository.deleteUnit( unit ) }

    fun deleteAllUnits() = viewModelScope.launch { repository.deleteAllUnits() }

}