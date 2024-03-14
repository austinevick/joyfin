package com.example.joyfin.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.joyfin.R
import com.example.joyfin.navigation.Routes
import com.example.joyfin.utils.isValidEmail
import com.example.joyfin.widget.CircularProgressLoader
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavHostController) {
    val mContext = LocalContext.current
    val validEmail = "joshua@ali.com"
    val validPassword = "herconomy"
    val isLoading = remember {
        mutableStateOf(false)
    }
    val isVisible = remember {
        mutableStateOf(false)
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val isValid = remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()
    fun mToast(message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }
    Scaffold { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Welcome!", fontWeight =
                    FontWeight.SemiBold,
                    fontSize = 26.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please login to access your account!!!",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(value = email.value,
                    onValueChange = { value ->
                        email.value = value
                    }, isError = isValidEmail(email.value) || isValid.value,
                    singleLine = true,
                    placeholder = {
                        Text(text = "Email")
                    })
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(value = password.value,
                    singleLine = true,
                    onValueChange = { value ->
                        password.value = value
                    }, isError = isValid.value,
                    visualTransformation = if (isVisible.value)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = {
                            isVisible.value = !isVisible.value
                        }) {
                            Icon(
                                painter = painterResource(
                                    id = if (isVisible.value) R.drawable.visibility_on
                                    else R.drawable.visibility_off
                                ),
                                contentDescription = null
                            )
                        }
                    },
                    placeholder = {
                        Text(text = "Password")
                    })
                Spacer(modifier = Modifier.height(40.dp))
                Button(modifier = Modifier
                    .width(280.dp)
                    .height(48.dp),
                    enabled = !isLoading.value,
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        if (email.value.isEmpty() || !isValidEmail(email.value)) {
                            mToast("Please enter a valid email")
                            isValid.value = true
                        } else if (password.value.isEmpty()) {
                            mToast("Please enter password")
                            isValid.value = true
                        } else {
                            isValid.value = false
                            isLoading.value = true
                            scope.launch {
                                delay(3000)
                                isLoading.value = false
                                if (email.value.trim() != validEmail || password.value.trim() != validPassword) {
                                    mToast("Invalid Credentials")
                                } else {
                                    navController.navigate(Routes.Home.route)
                                }
                            }
                        }
                    }) {
                    if (isLoading.value) CircularProgressLoader()
                    else Text(text = "LOGIN")
                }
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}