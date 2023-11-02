package com.example.jetpackregistrationpage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackregistrationpage.ui.theme.JetpackRegistrationPageTheme
import com.example.jetpackregistrationpage.ui.theme.Orange5

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackRegistrationPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register Here",
            color = Orange5,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(10.dp))
        var name by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = {name =it},
            label = { Text(text = "Enter Name")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value =email ,
            onValueChange = {email=it},
            label = {
                Text(text = "Enter your Email",
                color = Color.Red
                )},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

        )
        Spacer(modifier = Modifier.height(10.dp))
        var idNumber by remember { mutableStateOf("") }
        OutlinedTextField(
            value =idNumber ,
            onValueChange = {idNumber=it},
            label = { Text(text = "Enter your IDNumber")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

        )
        Spacer(modifier = Modifier.height(10.dp))
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value =password ,
            onValueChange = {password=it},
            label = { Text(text = "Enter your password")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

        )
        Spacer(modifier = Modifier.height(10.dp))
        var context = LocalContext.current
        var registrationDetails = "$name \n $email \n $idNumber \n $password"
        Button(onClick = {
            Toast.makeText(context, registrationDetails, Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Register")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackRegistrationPageTheme {
        HomeScreen()
    }
}