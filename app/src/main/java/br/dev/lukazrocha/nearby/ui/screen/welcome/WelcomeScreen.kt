package br.dev.lukazrocha.nearby.ui.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.dev.lukazrocha.nearby.ui.component.button.NearbyButton
import br.dev.lukazrocha.nearby.ui.component.welcome.NearbyWelcomeContent
import br.dev.lukazrocha.nearby.ui.component.welcome.NearbyWelcomeHeader

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit,
) {
    Column(
        modifier =
            modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 48.dp)
                .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        NearbyWelcomeHeader()
        NearbyWelcomeContent()
        NearbyButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Começar",
            onClick = onNavigateToHome,
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigateToHome = {})
}
