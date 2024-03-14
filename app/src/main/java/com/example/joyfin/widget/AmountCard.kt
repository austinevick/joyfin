package com.example.joyfin.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joyfin.utils.formatCurrency

@Composable
fun AmountCard(amount: Long, title: String, color: Color) {
    val localConfig = LocalConfiguration.current
    Card(
        modifier = Modifier
            .height(100.dp)
            .width(localConfig.screenWidthDp.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                .fillMaxWidth()) {
                Text(
                    formatCurrency(amount),
                    color = Color.White,
                    fontSize = 23.sp, fontWeight = FontWeight.W800
                )
                TextButton(
                    modifier = Modifier.height(35.dp),
                    onClick = { /*TODO*/ }) {
                    Text("Add Funds",color=Color.White, fontSize = 12.sp)
                }
            }
            Text(
                title, color = Color(0xffefefef)
            )
        }
    }
}