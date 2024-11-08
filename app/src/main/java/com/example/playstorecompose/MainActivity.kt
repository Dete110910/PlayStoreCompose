package com.example.playstorecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.playstorecompose.ui.composables.ForYouScreen
import com.example.playstorecompose.ui.composables.TopChartsScreen
import com.example.playstorecompose.ui.theme.PlayStoreComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showTopChartsApps by remember {
                mutableStateOf(false)
            }

            PlayStoreComposeTheme {
                if (showTopChartsApps) {
                    TopChartsScreen(
                        showTopChartsApps,
                        onClickApps = {
                            showTopChartsApps = false
                        }
                    )
                } else {
                    ForYouScreen(
                        showTopChartsApps,
                        onClickApps = {
                            showTopChartsApps = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlayStoreComposeTheme {

    }
}
 */