package com.example.myapplication.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {

        AsyncImage(
            model = "https://www.adobe.com/products/firefly/features/media_1cc035824a5dbf414f18a55ef622e86cc51684dd5.png?width=2000&format=webply&optimize=medium",
            contentDescription = "bird"
        )

        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "User Name",
            style = MaterialTheme.typography.displayMedium

        )
        Text(
            text = "User Job",
            style = MaterialTheme.typography.bodyLarge
        )

    }


}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        HomeScreen(navController = navController)
    }
}