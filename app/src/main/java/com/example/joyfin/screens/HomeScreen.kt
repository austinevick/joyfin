package com.example.joyfin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joyfin.widget.CardSlider
import com.example.joyfin.widget.CircularProgressLoader
import com.example.joyfin.widget.CustomDialog
import com.example.joyfin.widget.TotalBalance
import com.example.joyfin.widget.TransactionList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(viewModel: AppViewModel) {
    val data = viewModel.userData.collectAsState();
    val scope = rememberCoroutineScope()
    val showDialog = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getUserData()
        scope.launch {
            delay(2000)
            showDialog.value = true
        }
    }
    Scaffold { paddingValues ->

        if (data.value.data == null) {
            CircularProgressLoader(color = Color.Black)

        } else if (data.value.error != null) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Something went wrong")
                TextButton(onClick = {   viewModel.getUserData() }) {
                    Text(text = "Refresh")
                }
            }
        } else {

            LazyColumn(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    val userData = data.value.data!!.userData
                    val smartSaver: Long? = userData?.smartSaverBalance
                    val greenSaver: Long? = userData?.greenSaverBalance
                    val fixedDeposit: Long? = userData?.fixedDepositBalance
                    val total = (greenSaver?.let { smartSaver?.plus(it) } ?: 0) + fixedDeposit!!
                    Spacer(modifier = Modifier.height(40.dp))
                    TotalBalance(userData.firstName, amount = total)

                    Spacer(modifier = Modifier.height(30.dp))

                    CardSlider(userData = userData)

                    if (showDialog.value)
                        if (userData.phoneVerified == "false" || userData.emailVerified == "false") CustomDialog(
                            onDismissRequest = { showDialog.value = false },
                            onConfirmation = { showDialog.value = false },
                            dialogTitle = "Account Verification",
                            dialogText = "Verify your account to access more benefits",
                            icon = Icons.Outlined.Info
                        )

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(
                        text = "Transactions", fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    data.value.data!!.smartSaverTransactions?.forEach { item ->
                        TransactionList(item)
                    }
                }
            }
        }
    }
}







