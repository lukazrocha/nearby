package br.dev.lukazrocha.nearby.data.model.mock

import br.dev.lukazrocha.nearby.data.model.Rule
import java.util.UUID

val mockRules =
    listOf(
        Rule(
            id = UUID.randomUUID().toString(),
            description = "Disponível até 31/12/2024",
            marketId = UUID.randomUUID().toString(),
        ),
        Rule(
            id = UUID.randomUUID().toString(),
            description = "Válido apenas para consumo no local",
            marketId = UUID.randomUUID().toString(),
        ),
    )
