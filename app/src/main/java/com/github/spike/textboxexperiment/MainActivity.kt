package com.github.spike.textboxexperiment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.spike.textboxexperiment.ui.theme.TextBoxExperimentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextBoxExperimentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InputFields()
                }
            }
        }
    }
}
@Composable
fun InputFields() {
    var plantName by remember { mutableStateOf("")}
    var description by remember { mutableStateOf("")}
    var location by remember { mutableStateOf("")}
    var datePlanted by remember { mutableStateOf("")}
    val context = LocalContext.current
    Column() {
        OutlinedTextField(
            value = plantName,
            onValueChange = { plantName = it },
            label = { Text(stringResource(R.string.plantName)) }
        )
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Where is it?")}
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(R.string.plantDescription))}
        )
        OutlinedTextField(
            value = datePlanted,
            onValueChange = { datePlanted = it },
            label = { Text("Date") }
        )
        Button(onClick = {
            Toast.makeText(
                context,
                "$plantName at $location : $description on $datePlanted", Toast.LENGTH_LONG).show()},
            ) {
            Text("Save")
        }
    }
}

fun saveFields(plantName: String, location: String, description: String) {
  //  liveData.save()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextBoxExperimentTheme {
        InputFields()
    }
}