package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.herolist.model.HeroesData
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HeroApp(modifier: Modifier = Modifier) {
    Box(modifier = modifier)
    {
        LazyColumn {
            items(HeroesData.heroes, key = { it.id }) {
                HerosItem(name = it.name, photoUrl = it.photoUrl)
            }
        }
    }
}


@Composable
fun HerosItem(
    modifier: Modifier = Modifier,
    name: String, photoUrl: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = photoUrl, contentDescription = null,
            modifier = modifier
                .padding(8.dp)
                .clip(CircleShape)
                .size(60.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroAppPreview() {
    MyApplicationTheme {
        HeroApp()
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroItemsAppPreview() {
    MyApplicationTheme {
        HerosItem(
            name = "test",
            photoUrl = "https://i.pinimg.com/736x/3f/a3/6f/3fa36fffb537f3a19ce7af2458ed48e4.jpg"
        )
    }
}