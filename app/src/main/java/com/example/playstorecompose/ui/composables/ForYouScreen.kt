package com.example.playstorecompose.ui.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.playstorecompose.R
import com.example.playstorecompose.data.models.AppData
import com.example.playstorecompose.ui.theme.PlayStoreComposeTheme

val listAppData = listOf(
    AppData("", "Canva", "Design", 4.5F, 20),
    AppData("", "AliExpress", "Shopping", 4.6F, 20),
    AppData("", "Strava", "Run", 4.5F, 16),
    AppData("", "Clash of Clans", "Strategy", 4.6F, 25),
    AppData("", "Canva", "Design", 4.5F, 30),
    AppData("", "AliExpress", "Shopping", 4.6F, 600),
    AppData("", "Strava", "Run", 4.5F, 10),
    AppData("", "Clash of Clans", "Strategy", 4.6F, 50),
)

@Composable
fun ForYouScreen(
    isTopChartsScreenVisible: Boolean,
    onClickApps: () -> Unit
) {
    Column(

    ) {
        Header(isTopChartsScreenVisible= isTopChartsScreenVisible, onClickApps = onClickApps)
        MenuApps()
        Spacer(modifier = Modifier.height(80.dp))
        Footer()
    }
}

@Composable
fun Header(
    isTopChartsScreenVisible: Boolean,
    onClickApps: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (playStoreIcon, bellButton, profileButton, forYouButton, topChartsButton, kidsButton, categoriesButton, divider) = createRefs()
        val transparentColor = ButtonDefaults.buttonColors(Color.Transparent)
        val styleText = TextStyle(fontSize = 14.sp, color = Color.Black)
        Image(
            painter = painterResource(
                R.drawable.img_profile_photo
            ),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(playStoreIcon) {
                    top.linkTo(parent.top, 5.dp)
                    start.linkTo(parent.start, 5.dp)
                }
                .size(50.dp)
        )

        Button(
            onClick = {
            },
            modifier = Modifier
                .constrainAs(bellButton) {
                    top.linkTo(profileButton.top)
                    end.linkTo(profileButton.start, 5.dp)
                    bottom.linkTo(profileButton.bottom)
                }
                .size(50.dp),
            colors = transparentColor,
            contentPadding = PaddingValues(0.dp),
            content = {
                Image(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null
                )
            }
        )
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(profileButton) {
                    top.linkTo(parent.top, 5.dp)
                    end.linkTo(parent.end, 5.dp)
                }
                .size(50.dp),
            colors = transparentColor,
            contentPadding = PaddingValues(0.dp),
            content = {
                Image(
                    painter = painterResource(
                        R.drawable.img_profile_photo,
                    ),
                    contentDescription = "",
                )
            }
        )
        Button(
            onClick = {
                if(isTopChartsScreenVisible)
                    onClickApps()
            },
            modifier = Modifier
                .constrainAs(forYouButton) {
                    top.linkTo(playStoreIcon.bottom)
                    bottom.linkTo(divider.top)
                    start.linkTo(parent.start)
                }
                .height(40.dp),
            colors = transparentColor
        ) {
            Text(text = "For you", style = styleText)
        }
        Button(
            onClick = {
                if(!isTopChartsScreenVisible)
                    onClickApps()
            },
            modifier = Modifier
                .constrainAs(topChartsButton) {
                    top.linkTo(playStoreIcon.bottom)
                    bottom.linkTo(divider.top)
                    start.linkTo(forYouButton.end)
                }
                .height(40.dp),
            colors = transparentColor
        ) {
            Text(text = "Top Charts", style = styleText)
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(kidsButton) {
                    top.linkTo(playStoreIcon.bottom)
                    bottom.linkTo(divider.top)
                    start.linkTo(topChartsButton.end)
                }
                .height(40.dp),
            colors = transparentColor
        ) {
            Text(text = "Kids", style = styleText)
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(categoriesButton) {
                    top.linkTo(playStoreIcon.bottom)
                    bottom.linkTo(divider.top)
                    start.linkTo(kidsButton.end)
                }
                .height(40.dp),
            colors = transparentColor
        ) {
            Text(text = "For you", style = styleText)
        }
        HorizontalDivider(
            modifier = Modifier.constrainAs(divider) {
                top.linkTo(forYouButton.bottom)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Composable
fun MenuApps() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (recommendedFYTextButton, recommendedFYIcon, horizontalAppsReel, suggestedFYText, adsButton, tripleHorizontalAppsReel) = createRefs()
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            ),
            modifier = Modifier
                .height(40.dp)
                .constrainAs(recommendedFYTextButton) {
                    top.linkTo(parent.top, 5.dp)
                    start.linkTo(parent.start, 15.dp)
                },
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = "Recommended for you",
                fontSize = 15.sp,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .height(40.dp)
                .constrainAs(recommendedFYIcon) {
                    top.linkTo(recommendedFYTextButton.top)
                    end.linkTo(parent.end, 5.dp)
                },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            ),
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
            )
        }

        HorizontalAppsReel(
            modifier = Modifier.constrainAs(horizontalAppsReel) {
                top.linkTo(recommendedFYTextButton.bottom, 5.dp)
                start.linkTo(parent.start, 5.dp)
            }
        )

        Text(
            text = "Suggested for you",
            fontSize = 15.sp,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.constrainAs(suggestedFYText) {
                top.linkTo(horizontalAppsReel.bottom, 10.dp)
                start.linkTo(horizontalAppsReel.start, 5.dp)
            }
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .height(40.dp)
                .constrainAs(adsButton) {
                    top.linkTo(suggestedFYText.top)
                    end.linkTo(parent.end, 5.dp)
                    bottom.linkTo(suggestedFYText.bottom)
                },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            ),
        ) {
            Image(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
            )
        }

        TripleHorizontalAppsReel(
            modifier = Modifier.constrainAs(tripleHorizontalAppsReel) {
                top.linkTo(adsButton.bottom, 5.dp)
                start.linkTo(horizontalAppsReel.start)
            }
        )
    }
}

@Composable
fun Footer(
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        val (games, apps, search, books) = createRefs()
        val transparentColor = ButtonDefaults.buttonColors(
            Color.Transparent
        )
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(games) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .width(100.dp),
            colors = transparentColor,
        ) {
            Image(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null
            )
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(apps) {
                    top.linkTo(games.top)
                    bottom.linkTo(games.bottom)
                    start.linkTo(games.end)
                }
                .width(100.dp),
            colors = transparentColor,
        ) {
            Image(
                imageVector = Icons.Filled.Build,
                contentDescription = null
            )
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(search) {
                    top.linkTo(apps.top)
                    bottom.linkTo(apps.bottom)
                    start.linkTo(apps.end)
                }
                .width(100.dp),
            colors = transparentColor,
        ) {
            Image(
                imageVector = Icons.Sharp.Search,
                contentDescription = null
            )
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .constrainAs(books) {
                    top.linkTo(search.top)
                    bottom.linkTo(search.bottom)
                    start.linkTo(search.end)
                }
                .width(100.dp),
            colors = transparentColor,
        ) {
            Image(
                imageVector = Icons.Filled.Call,
                contentDescription = null
            )
        }
    }
}

@Composable
fun HorizontalAppsReel(modifier: Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(listAppData) { appData ->
            CardInfoApp(appData)
        }

    }
}

@Composable
fun TripleHorizontalAppsReel(modifier: Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(325.dp)
    ) {
        items(listAppData) { appData ->
            Column(
                modifier = Modifier.width(400.dp)
            ) {
                HorizontalCardInfoApp(appData)
                HorizontalCardInfoApp(appData)
                HorizontalCardInfoApp(appData)
            }
        }
    }
}

@Composable
fun CardInfoApp(appData: AppData) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(150.dp)
            .height(270.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
        ) {
            val (image, name, categories, rate) = createRefs()
            val fontSize = 13.sp
            Image(
                painter = painterResource(R.drawable.img_profile_photo),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top, 5.dp)
                        start.linkTo(parent.start, 5.dp)
                        bottom.linkTo(name.top, 5.dp)
                        end.linkTo(parent.end, 5.dp)
                    }
                    .size(120.dp)
            )
            Text(
                text = "${appData.name}:", modifier = Modifier.constrainAs(name) {
                    top.linkTo(image.bottom)
                    bottom.linkTo(categories.top)
                    start.linkTo(image.start)
                },
                fontSize = fontSize
            )
            Text(
                appData.categories, Modifier.constrainAs(categories) {
                    top.linkTo(name.top)
                    start.linkTo(name.end)
                },
                fontSize = fontSize
            )
            Text(
                appData.rate.toString(), Modifier.constrainAs(rate) {
                    top.linkTo(categories.bottom)
                    start.linkTo(image.start)
                },
                fontSize = fontSize
            )
        }
    }
}

@Composable
fun HorizontalCardInfoApp(appData: AppData) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (image, name, categories, rate, starIcon, size) = createRefs()
            val fontSize = 13.sp
            Image(
                painter = painterResource(R.drawable.img_profile_photo),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom, 10.dp)
                        start.linkTo(parent.start, 5.dp)
                    }
                    .size(70.dp)
            )
            Text(
                text = "${appData.name}: App short description",
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, 10.dp)
                },
                fontSize = 14.sp
            )
            Text(
                text = appData.categories,
                modifier = Modifier.constrainAs(categories) {
                    top.linkTo(name.bottom, 2.dp)
                    start.linkTo(name.start)
                },
                fontSize = fontSize
            )
            Text(
                text = "${appData.rate}",
                modifier = Modifier.constrainAs(rate) {
                    top.linkTo(categories.bottom)
                    start.linkTo(name.start)
                },
                fontSize = fontSize
            )
            Image(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp)
                    .constrainAs(starIcon) {
                        top.linkTo(rate.top)
                        start.linkTo(rate.end, 1.dp)
                        bottom.linkTo(rate.bottom)
                    }
            )
            Text(
                text = "${appData.size} MB",
                modifier = Modifier.constrainAs(size) {
                    top.linkTo(rate.top)
                    start.linkTo(starIcon.end, 5.dp)
                    bottom.linkTo(rate.bottom)
                },
                fontSize = fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForYouScreen() {
    PlayStoreComposeTheme {
        ForYouScreen(
            false,
            onClickApps = {

            }
        )
    }
}