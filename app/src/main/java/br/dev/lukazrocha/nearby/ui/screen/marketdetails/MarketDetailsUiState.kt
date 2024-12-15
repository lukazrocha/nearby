package br.dev.lukazrocha.nearby.ui.screen.marketdetails

import br.dev.lukazrocha.nearby.data.model.Rule

data class MarketDetailsUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null,
)
