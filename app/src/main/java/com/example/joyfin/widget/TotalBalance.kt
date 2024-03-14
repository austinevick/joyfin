package com.example.joyfin.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joyfin.utils.formatCurrency

@Composable
fun TotalBalance(name: String, amount: Long) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .border(BorderStroke(1.dp, Color.LightGray), CircleShape)
                    .padding(6.dp)
            ) {
                Icon(
                    Icons.Outlined.Person,
                    modifier = Modifier.size(20.dp),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Hi, $name 👋",
                fontWeight = FontWeight.W600, fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = formatCurrency(amount),
            fontWeight = FontWeight.SemiBold, fontSize = 30.sp
        )
        Text(text = "Total Balance")
    }
}
