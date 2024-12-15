package br.dev.lukazrocha.nearby.ui.component.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.dev.lukazrocha.nearby.R
import br.dev.lukazrocha.nearby.ui.theme.Typography

@Composable
fun NearbyWelcomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Text(text = "Veja como funciona: ", style = Typography.bodyLarge)
        NearbyWelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Encontre estabelimentos",
            subtitle = "Veja locais próximos de você que sejam parceiros Nearby",
            iconRes = R.drawable.ic_map_pin,
        )

        NearbyWelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Ative o cupom com o QR code",
            subtitle = "Escaneie o código no estabelecimento para usar o benefício",
            iconRes = R.drawable.ic_qrcode,
        )

        NearbyWelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Garanta vantagens perto de você",
            subtitle = "Ative cupons onde estiver, em diferentes tipos de estabelecimentos",
            iconRes = R.drawable.ic_ticket,
        )
    }
}
