package br.dev.lukazrocha.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.dev.lukazrocha.nearby.data.model.Market
import br.dev.lukazrocha.nearby.ui.route.Home
import br.dev.lukazrocha.nearby.ui.route.QRCodeScanner
import br.dev.lukazrocha.nearby.ui.route.Splash
import br.dev.lukazrocha.nearby.ui.route.Welcome
import br.dev.lukazrocha.nearby.ui.screen.home.HomeScreen
import br.dev.lukazrocha.nearby.ui.screen.home.HomeViewModel
import br.dev.lukazrocha.nearby.ui.screen.marketdetails.MarketDetailScreen
import br.dev.lukazrocha.nearby.ui.screen.marketdetails.MarketDetailsUiEvent
import br.dev.lukazrocha.nearby.ui.screen.marketdetails.MarketDetailsViewModel
import br.dev.lukazrocha.nearby.ui.screen.qrcodescanner.QRCodeScannerScreen
import br.dev.lukazrocha.nearby.ui.screen.splash.SplashScreen
import br.dev.lukazrocha.nearby.ui.screen.welcome.WelcomeScreen
import br.dev.lukazrocha.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NearbyTheme {
                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUiState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash,
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            },
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })
                    }
                    composable<Home> {
                        HomeScreen(onNavigateToMarketDetails = { selectedMarket ->
                            navController.navigate(selectedMarket)
                        }, uiState = homeUiState, onEvent = homeViewModel::onEvent)
                    }
                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailScreen(
                            market = selectedMarket,
                            uiState = marketDetailsUiState,
                            onEvent = marketDetailsViewModel::onEvent,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onNavigateToQRCOdeScanner = {
                                navController.navigate(QRCodeScanner)
                            },
                        )
                    }
                    composable<QRCodeScanner> {
                        QRCodeScannerScreen(
                            onCompletedScan = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty()) {
                                    marketDetailsViewModel.onEvent(
                                        MarketDetailsUiEvent.OnFetchCoupon(qrCodeContent = qrCodeContent),
                                    )
                                }
                                navController.popBackStack()
                            },
                        )
                    }
                }
            }
        }
    }
}
