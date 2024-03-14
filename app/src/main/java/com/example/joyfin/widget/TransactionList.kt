package com.example.joyfin.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joyfin.model.SmartSaverTransaction
import com.example.joyfin.utils.formatCurrency

@Composable
fun TransactionList(item: SmartSaverTransaction){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Box(
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp).background(Color(0xffd8e3f5),
                        RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
                content = {
                    Card(
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp),
                        shape = RoundedCornerShape(100.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (item.type == "credit") Color.Blue
                            else Color.Red)) {}
                })
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = item.narration, fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
                Text(
                    text = item.dateCreated,
                    color = Color.Gray,
                    fontSize = 15.sp)
            }
        }
        Text(text = if (item.type == "credit")
                formatCurrency(item.amount)
            else
                "-${formatCurrency(item.amount)}",
            fontWeight = FontWeight.W700,
            color = if (item.type == "credit") Color.Blue else Color.Red
        )
    }
}