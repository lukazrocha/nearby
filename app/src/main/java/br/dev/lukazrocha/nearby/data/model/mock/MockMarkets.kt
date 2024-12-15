package br.dev.lukazrocha.nearby.data.model.mock

import br.dev.lukazrocha.nearby.data.model.Market

val mockMarkets =
    listOf(
        Market(
            id = "afeed394-cba7-4da0-8148-88b7be17c8d0",
            categoryId = "9e0fff44-969f-463a-84dc-60a1d796b78a",
            name = "Sabor Grill",
            description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
            coupons = 10,
//            rules =
//                listOf(
//                    Rule("1", description = "Válido até o dia 25/12", marketId = "afeed394-cba7-4da0-8148-88b7be17c8d0"),
//                    Rule("2", description = "Disponível apenas para consumo no local", marketId = "afeed394-cba7-4da0-8148-88b7be17c8d0"),
//                ),
            latitude = -23.55974230991911,
            longitude = -46.65814845249887,
            address = "Av. Paulista - Bela Vista",
            phone = "(11) 94567-1212",
            cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300",
        ),
        Market(
            id = "bfeed394-cba7-4da0-8148-88b7be17c8d0",
            categoryId = "ae0fff44-969f-463a-84dc-60a1d796b78a",
            name = "Café Central",
            description = "Café aconchegante com opções de lanches e bebidas artesanais. Perfeito para você e sua família.",
            coupons = 10,
//            rules = emptyList(),
            latitude = -23.559457108504436,
            longitude = -46.66252581753144,
            address = "Alameda para Bahli - Jardim Paulista",
            phone = "(12) 3456-7890",
            cover = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=400&h=300",
        ),
    )
