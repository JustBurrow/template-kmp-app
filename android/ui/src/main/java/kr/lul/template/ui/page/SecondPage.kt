package kr.lul.template.ui.page

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.lul.template.viewmodel.SecondViewModel

@Composable
fun SecondPage(
    navController: NavController = rememberNavController(),
    viewModel: SecondViewModel = hiltViewModel()
) {
    Log.v(TAG, "#SecondPage args : navController=$navController, viewModel=$viewModel")

    val data by viewModel.data.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Page", style = MaterialTheme.typography.displayLarge)

        if (null == data) {
            Text(text = "Loading...", Modifier.padding(16.dp))
        } else {
            Text(text = "$data", Modifier.padding(16.dp))
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go back")
        }
    }
}
