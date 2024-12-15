package br.dev.lukazrocha.nearby.core.network

import br.dev.lukazrocha.nearby.core.network.KtorHttpClient.httpClientAndroid
import br.dev.lukazrocha.nearby.data.model.Category
import br.dev.lukazrocha.nearby.data.model.Coupon
import br.dev.lukazrocha.nearby.data.model.Market
import br.dev.lukazrocha.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {
    private const val LOCALHOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"

    private const val BASE_URL = LOCALHOST_EMULATOR_BASE_URL

    // 1 - busca de categorias
    // 2 - busca de locais (com base em um local específico)
    // 3 - busca de detalhes de um local (com base em um local específico)
    // 4 - gerar cupom a partir da leitura do qr code

    suspend fun getCategories(): Result<List<Category>> =
        try {
            val categories = httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()

            Result.success(categories)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> =
        try {
            val markets = httpClientAndroid.get("$BASE_URL/markets/category/$categoryId").body<List<Market>>()

            Result.success(markets)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> =
        try {
            val marketDetails = httpClientAndroid.get("$BASE_URL/markets/$marketId").body<MarketDetails>()

            Result.success(marketDetails)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun patchCoupon(marketId: String): Result<Coupon> =
        try {
            val coupon = httpClientAndroid.patch("$BASE_URL/coupons/$marketId").body<Coupon>()

            Result.success(coupon)
        } catch (e: Exception) {
            Result.failure(e)
        }
}
