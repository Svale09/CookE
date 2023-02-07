package com.example.cooke.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooke.data.di.dataModule
import com.example.cooke.ui.favorites.di.favoritesModule
import com.example.cooke.ui.home.di.homeModule
import com.example.cooke.ui.main.di.mainScreenModule
import com.example.cooke.ui.recipeDetails.di.recipeDetailsModule
import com.example.cooke.ui.recipeInput.di.recipeInputModule
import com.example.cooke.ui.theme.CookETheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin{
            androidContext(this@MainActivity)
            modules(
                mainScreenModule,
                dataModule,
                homeModule,
                recipeInputModule,
                recipeDetailsModule,
                favoritesModule
            )
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            CookETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CookETheme {
        MainScreen()
    }
}
