package com.example.jetweatherforecast.screns.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherforecast.widgets.WeatherAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen( navController: NavController,
                    settingsViewModel: SettingsViewModel = hiltViewModel() ) {

    var unitTogleState by remember {

        mutableStateOf( false )

    }

    val measurementUnits = listOf( "Imperial (F)", "Metric (C)" )

    var choiceState by remember {

        mutableStateOf( "" )

    }

    Scaffold( topBar = {

        WeatherAppBar(
            title = "Settings",
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
            navController = navController )

    } ) {

        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Change Units of Measurement",
                modifier = Modifier.padding( bottom = 15.dp )
                )

                IconToggleButton(checked = !unitTogleState,
                    onCheckedChange = {

                        unitTogleState = !it

                        if ( unitTogleState ) { choiceState = "Imperial (F)" }
                        else { choiceState = "Metric (C)" }

                    }, modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(shape = RectangleShape)
                        .padding(5.dp)
                        .background(Color.Magenta.copy(alpha = 0.4f)) ) {

                    Text(text = if ( unitTogleState ) "Fahrenheit .F" else "Celsius .C" )

                }

                Button(onClick = {



                                 },
                    modifier = Modifier
                        .padding(3.dp)
                        .align(CenterHorizontally),
                    shape = RoundedCornerShape( 34.dp ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color( 0xFFEFBE42 )
                    )
                ) {

                    Text(text = "Save" ,
                    modifier = Modifier.padding( 4.dp ) ,
                    color = Color.White ,
                    fontSize = 17.sp )

                }

            }

        }

    }

}