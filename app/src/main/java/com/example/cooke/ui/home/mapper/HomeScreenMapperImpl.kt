package com.example.cooke.ui.home.mapper

import com.example.cooke.R
import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabelTextViewState
import com.example.cooke.ui.component.RecipeCategoryLabelViewState
import com.example.cooke.ui.home.HomeRecipeCategoryViewState


class HomeScreenMapperImpl : HomeScreenMapper {
    override fun toHomeRecipeCategoryViewState(
        recipeCategories: List<RecipeCategory>,
        selectedRecipeCategory: RecipeCategory,
        recipes: List<Recipe>
    ) = HomeRecipeCategoryViewState(
        recipeCategories = toHomeRecipeCategoryLabelViewState(
            recipeCategories,
            selectedRecipeCategory,
        ),
        toRecipeViewState(recipes)
    )

    private fun toRecipeViewState(recipes: List<Recipe>) =
        recipes.map {
            RecipeCardViewState(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                isFavorite = it.isFavorite
            )
        }

    private fun toHomeRecipeCategoryLabelViewState(
        recipeCategories: List<RecipeCategory>,
        selectedRecipeCategory: RecipeCategory
    ) = recipeCategories.map {
        RecipeCategoryLabelViewState(
            itemId = it.ordinal,
            isSelected = it == selectedRecipeCategory,
            categoryText = RecipeCategoryLabelTextViewState.CategoryStringResource(
                when (it) {
                    RecipeCategory.CHOCOLATE -> R.string.chocolate
                    RecipeCategory.FRUIT -> R.string.FRUIT
                    RecipeCategory.NUTS -> R.string.NUTS
                    RecipeCategory.DRY -> R.string.DRY
                    RecipeCategory.CREAM -> R.string.CREAM
                    RecipeCategory.COOKIES -> R.string.COOKIES
                    RecipeCategory.CAKES -> R.string.CAKES
                }
            )
        )
    }
}
