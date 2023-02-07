package com.example.cooke.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cooke.navigation.NavigationItem
import com.example.cooke.navigation.RECIPE_ID_KEY
import com.example.cooke.navigation.RecipeDetailsDestination
import com.example.cooke.ui.home.HomeRoute
import com.example.cooke.ui.recipeDetails.RecipeDetailsRoute
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.example.cooke.navigation.RECIPE_INPUT_ROUTE
import com.example.cooke.ui.favorites.FavoritesRoute
import com.example.cooke.ui.recipeInput.RecipeInputRoute
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val showBottomBar by remember {
        derivedStateOf {
            when (navBackStackEntry?.destination?.route) {
                RecipeDetailsDestination.route -> false
                else -> true
            }
        }
    }
    val showBackIcon = !showBottomBar
    Scaffold(
        topBar = {
            TopBar(
                navigationIcon = {
                    if (showBackIcon) BackIcon(
                        onBackClick = navController::popBackStack
                    )
                }
            )
        },
        bottomBar = {
            if (showBottomBar)
                BottomNavigationBar(
                    destinations = listOf(
                        NavigationItem.HomeDestination,
                        NavigationItem.RecipeInputDestination,
                        NavigationItem.FavoritesDestination
                    ),
                    currentDestination = navBackStackEntry?.destination,
                    onNavigateToDestination = {
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
        }
    ) { padding ->
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationItem.HomeDestination.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(NavigationItem.HomeDestination.route) {
                    HomeRoute(
                        onNavigateToRecipeDetails = {
                            navController.navigate(
                                RecipeDetailsDestination.createNavigationRoute(recipeId = it.id)
                            )
                        },
                        homeViewModel = getViewModel()
                    )
                }
                composable(NavigationItem.RecipeInputDestination.route) {
                    RecipeInputRoute(
                        recipeInputViewModel = getViewModel(),
                        { navController.navigate(NavigationItem.HomeDestination.route) })
                }
                composable(NavigationItem.FavoritesDestination.route) {
                    FavoritesRoute(
                        onNavigateToRecipeDetails = {
                            navController.navigate(
                                RecipeDetailsDestination.createNavigationRoute(
                                    recipeId = it.id
                                )
                            )
                        },
                        onToggleFavoriteButton = {}
                    )
                }
                composable(
                    route = RecipeDetailsDestination.route,
                    arguments = listOf(navArgument(RECIPE_ID_KEY) { type = NavType.IntType }),
                ) {
                    RecipeDetailsRoute(onFavoriteToggle = {})
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    navigationIcon: @Composable ((Modifier) -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color(0xffF06292)),
        contentAlignment = Alignment.CenterStart
    ) {
        navigationIcon?.invoke(Modifier.align(Alignment.CenterStart))
        Image(
            painter = painterResource(id = com.example.cooke.R.drawable.cooke),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.Center)
        )
    }
}

@Composable
private fun BackIcon(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = com.example.cooke.R.drawable.back_icon),
        contentDescription = "Back arrow",
        modifier
            .padding(start = 10.dp)
            .width(12.dp)
            .height(20.dp)
            .clickable { onBackClick() }
    )
}

@Composable
private fun BottomNavigationBar(
    destinations: List<NavigationItem>,
    onNavigateToDestination: (NavigationItem) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                modifier = Modifier,
                selected = (destination.route == currentDestination?.route.toString()),
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        painter = if (destination.route == currentDestination?.route.toString()) {
                            painterResource(
                                id = destination.selectedIconId
                            )
                        } else {
                            painterResource(id = destination.unselectedIconId)
                        },
                        contentDescription = stringResource(id = destination.labelId)
                    )
                },
                label = { Text(text = stringResource(id = destination.labelId)) }
            )
        }
    }
}

