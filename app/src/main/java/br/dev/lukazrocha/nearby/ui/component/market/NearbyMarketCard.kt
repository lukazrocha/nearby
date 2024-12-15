package br.dev.lukazrocha.nearby.ui.component.market

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.dev.lukazrocha.nearby.R
import br.dev.lukazrocha.nearby.data.model.Market
import br.dev.lukazrocha.nearby.ui.theme.Gray100
import br.dev.lukazrocha.nearby.ui.theme.Gray200
import br.dev.lukazrocha.nearby.ui.theme.Gray400
import br.dev.lukazrocha.nearby.ui.theme.Gray500
import br.dev.lukazrocha.nearby.ui.theme.RedBase
import br.dev.lukazrocha.nearby.ui.theme.Typography
import coil3.compose.AsyncImage

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier,
    market: Market,
    onClick: (Market) -> Unit,
) {
    Card(
        modifier =
            modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Gray100)
                .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp)),
        onClick = {
            onClick(market)
        },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Gray100).padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AsyncImage(
                modifier =
                    Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth(0.3f)
                        .height(
                            IntrinsicSize.Min,
                        ).aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                model = market.cover,
                contentDescription = "Imagem do Estabelecimento",
            )
            Column {
                Text(text = market.name, style = Typography.headlineSmall.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (market.coupons > 0) RedBase else Gray400,
                        painter = painterResource(R.drawable.ic_ticket),
                        contentDescription = "Ícone de Cupom",
                    )
                    Text(
                        text = "${market.coupons} cupons disponíveis",
                        color = Gray400,
                        style = Typography.bodyLarge.copy(fontSize = 12.sp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market =
            Market(
                id = "afeed394-cba7-4da0-8148-88b7be17c8d0",
                categoryId = "9e0fff44-969f-463a-84dc-60a1d796b78a",
                name = "Sabor Grill",
                description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
                coupons = 10,
//                rules = emptyList(),
                latitude = -23.55974230991911,
                longitude = -46.65814845249887,
                address = "Av. Paulista - Bela Vista",
                phone = "(11) 94567-1212",
                cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300",
            ),
        onClick = {},
    )
}