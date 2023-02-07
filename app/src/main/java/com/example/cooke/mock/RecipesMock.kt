package com.example.cooke.mock

import com.example.cooke.model.Recipe

object RecipesMock {
    fun getRecipesList(): List<Recipe> = listOf(
        Recipe(
            id = 1.toString(),
            title = "German Chocolate Cupcakes",
            imageURI = "https://www.allrecipes.com/thmb/bdPHwED-UZ4MJNPmNhzSqvp_gS4=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/german-chocolate-cupcakes-ddmfs-beauty-3x4-1-3275fd7de389429eb2865cfc5cc13c50.jpg",
            duration = 1.5.toDouble(),
            difficulty = "Amateur",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            2.toString(),
            "New York Cheesecake",
            "https://i0.wp.com/www.onceuponachef.com/images/2017/12/cheesecake.jpg?resize=760%2C882&ssl=1",
            duration = 2.5.toDouble(),
            difficulty = "Intermediate",
            isFavorite = true,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            3.toString(),
            "Medovik",
            "https://www.tasteatlas.com/images/recipes/bb3fd3423ab64f90b9507ac7bdb47edd.jpg?mw=910",
            duration = 3.0,
            difficulty = "Pro",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            4.toString(),
            "Peanut Butter Chocolate Chip Cookies",
            "https://handletheheat.com/wp-content/uploads/2019/02/Peanut-Butter-Chocolate-Chip-Cookies-1-550x550.jpg",
            duration = 1.0,
            difficulty = "Amateur",
            isFavorite = true,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            5.toString(),
            "San Sebastian Cheesecake",
            "https://thebusybaker.ca/wp-content/uploads/2021/09/san-sebastian-cheesecake-6.jpg",
            duration = 2.0,
            difficulty = "Pro",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            6.toString(),
            "Ferrero Rocher Cake",
            "https://richanddelish.com/wp-content/uploads/2022/08/Ferrero-Rocher-Cake-1.jpg",
            duration = 2.5,
            difficulty = "intermediate",
            isFavorite = true,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            7.toString(),
            "Cinnamon rolls",
            "https://images.immediate.co.uk/production/volatile/sites/30/2021/04/Cinnamon-rolls-9fb9daa.jpg?quality=90&webp=true&resize=300,272",
            duration = 2.0,
            difficulty = "Intermediate",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            8.toString(),
            "Salted caramel brownies",
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/salted-caramel-brownies-e067f0c.jpg?quality=90&webp=true&resize=300,272",
            duration = 1.25,
            difficulty = "Easy",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        ),
        Recipe(
            9.toString(),
            "Vanilla Creme Brulee",
            "https://static01.nyt.com/images/2017/12/13/dining/15COOKING-CREME-BRULEE1/15COOKING-CREME-BRULEE1-master768.jpg?w=1280&q=75",
            duration = 2.75,
            difficulty = "Pro",
            isFavorite = false,
            ingridients = emptyList(),
            preparation = emptyList()
        )
    )

    fun getRecipeDetails(): Recipe = Recipe(
        id = 1.toString(),
        title = "Tiramisu",
        imageURI = "https://static01.nyt.com/images/2017/04/05/dining/05COOKING-TIRAMISU1/05COOKING-TIRAMISU1-master768.jpg?w=1280&q=75",
        difficulty = "Intermediate",
        ingridients = listOf(
            "4 large egg yolks",
            "1/2 cups of 100 grams granulated sugar",
            "3/4 cup heavy cream",
            "220 grams mascarpone",
            "1 and 3/4 of espresso",
            "24 ladydingers",
            "2 tbsp rum",
            "2 tbsp unsweetened cocoa",
            "2 ounces bittersweet chocolate"
        ),
        preparation = listOf(
            "Using an electric mixer in a medium bowl, whip together egg yolks and ¼ cup/50 grams sugar until very pale yellow and about tripled in volume. A slight ribbon should fall from the beaters (or whisk attachment) when lifted from the bowl. Transfer mixture to a large bowl, wiping out the medium bowl used to whip the yolks and set aside.",
            "In the medium bowl, whip cream and remaining ¼ cup/50 grams sugar until it creates soft-medium peaks. Add mascarpone and continue to whip until it creates a soft, spreadable mixture with medium peaks. Gently fold the mascarpone mixture into the sweetened egg yolks until combined.",
            "Combine espresso and rum in a shallow bowl and set aside.",
            "Using a sifter, dust the bottom of a 2-quart baking dish (an 8x8-inch dish, or a 9-inch round cake pan would also work here) with 1 tablespoon cocoa powder.",
            "Working one at a time, quickly dip each ladyfinger into the espresso mixture -- they are quite porous and will fall apart if left in the liquid too long -- and place them rounded side up at the bottom of the baking dish. Repeat, using half the ladyfingers, until you’ve got an even layer, breaking the ladyfingers in half as needed to fill in any obvious gaps (a little space in between is O.K.). Spread half the mascarpone mixture onto the ladyfingers in one even layer. Repeat with remaining espresso-dipped ladyfingers and mascarpone mixture.",
            "Dust top layer with remaining tablespoon of cocoa powder. Top with shaved or finely grated chocolate, if desired.",
            "Cover with plastic wrap and let chill in the refrigerator for at least 4 hours (if you can wait 24 hours, all the better) before slicing or scooping to serve."
        ),
        1.5,
        false
    )
}
