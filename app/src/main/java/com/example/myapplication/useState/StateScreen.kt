package com.example.myapplication.useState

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
private fun TodoList() {

    var name by remember {
        mutableStateOf<String>("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
//                modifier = Modifier.size(height = 20.dp, width = 20.dp),
                onClick = {
                    if (name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                HorizontalDivider()
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun StateScreen() {
    var count = remember {
        mutableStateOf(0)

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(onClick = { count.value++ }) {
            Text(text = "Increment")
        }
        Text(text = "Count is : ${count.value}")

        Button(onClick = { count.value-- }) {
            Text(text = "Decrement")

        }

    }
}
