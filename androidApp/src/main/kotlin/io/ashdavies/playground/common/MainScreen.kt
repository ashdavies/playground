package io.ashdavies.playground.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.navigation.NavHost
import androidx.compose.navigation.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import io.ashdavies.playground.R
import io.ashdavies.playground.conferences.ConferencesScreen
import io.ashdavies.playground.navigation.ScreenDestination.Conferences

@Preview
@Composable
fun MainScreen() {
    SystemUiAmbient
        .current
        .setStatusBarColor(MaterialTheme.colors.primaryVariant)

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.application)) },
                    actions = {
                        IconButton(onClick = { TODO() }) {
                            Image(asset = vectorResource(R.drawable.ic_baseline_search_24))
                        }
                    },
                )
            },
            bottomBar = {
                BottomAppBar {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        IconButton(
                            modifier = Modifier.align(CenterHorizontally),
                            onClick = { TODO() },
                        ) {
                            Image(asset = vectorResource(R.drawable.ic_baseline_code_24))
                        }
                    }
                }
            }
        ) {
            NavHost(startDestination = Conferences) {
                composable(Conferences) { ConferencesScreen() }
            }
        }
    }
}
