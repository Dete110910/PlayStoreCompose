package com.example.playstorecompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.playstorecompose.R
import com.example.playstorecompose.data.models.AppData
import com.example.playstorecompose.ui.theme.PlayStoreComposeTheme

val dropDownButtons = listOf(
    "Top Free",
    "Categories"
)

@Composable
fun TopChartsScreen(
    isTopChartsScreenVisible: Boolean,
    onClickApps: () -> Unit
) {
    Scaffold(
        topBar = {
            Header(
                isTopChartsScreenVisible,
                onClickApps = onClickApps
            )
        },
        bottomBar = {
            Footer()
        }
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            val (horizontalButtons, cards, container) = createRefs()
            LazyRow(
                modifier = Modifier
                    .constrainAs(horizontalButtons) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                items(dropDownButtons) { button ->
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .constrainAs(container) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                end.linkTo(parent.end)
                            }
                    ) {
                        val (dropDownButtons) = createRefs()
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    Color.Black,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .constrainAs(dropDownButtons) {
                                    top.linkTo(parent.top, 10.dp)
                                    start.linkTo(parent.start, 20.dp)
                                }
                                .height(30.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Text(
                                text = button, style = TextStyle(
                                    color = Color.Black
                                )
                            )
                            Image(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                alignment = Alignment.TopEnd
                            )
                        }
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(cards) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(0.dp, innerPadding.calculateBottomPadding(), 0.dp, 0.dp)
            ) {
                items(listAppData) { appData ->
                    HorizontalCardInfoApp(appData)
                }
            }
        }
    }
}

@Composable
fun HorizontalCardInfoAppWithNumber(appData: AppData) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (appImage, appName, appCategories, appRate) = createRefs()
        Image(
            painter = painterResource(R.drawable.img_profile_photo),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .constrainAs(appImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, 10.dp)
                    bottom.linkTo(parent.bottom, 10.dp)
                }
        )
        Text(
            text = appData.name,
            modifier = Modifier.constrainAs(appName) {
                top.linkTo(appImage.top)
                start.linkTo(appImage.end, 10.dp)
            }
        )
        Text(
            text = appData.name,
            modifier = Modifier.constrainAs(appCategories) {
                top.linkTo(appName.bottom)
                start.linkTo(appImage.end, 10.dp)
            }
        )
        Text(
            text = appData.name,
            modifier = Modifier.constrainAs(appRate) {
                top.linkTo(appImage.top)
                start.linkTo(appImage.end, 10.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopChartsScreen() {
    PlayStoreComposeTheme {
        TopChartsScreen(
            false,
            onClickApps = {

            }
        )
    }
}