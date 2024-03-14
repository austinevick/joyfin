package com.example.joyfin.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.joyfin.model.UserDataClass

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardSlider( userData: UserDataClass){
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    HorizontalPager(state = pagerState) {page->
        when (page){
            0 ->{
                AmountCard(amount = userData.greenSaverBalance,
                    title = "Green Saver",Color(0XFF55bf25))
            }
            1 ->{
                AmountCard(amount = userData.smartSaverBalance,
                    title = "Smart Saver", Color(0XFF155332)
                )
            }
            2 ->{
                AmountCard(amount = userData.fixedDepositBalance,
                    title = "Fixed Deposit", Color(0XFF004a92)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            val size = if (pagerState.currentPage == iteration)10.dp else 8.dp
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            )
        }
    }
}