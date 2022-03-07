package com.example.jetpackcamp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetpackcamp.navigation.Screen
import com.example.jetpackcamp.onboard.OnBoardingPage
import com.example.jetpackcamp.onboard.WelcomeViewModel
import com.example.jetpackcamp.ui.theme.Black100
import com.example.jetpackcamp.ui.theme.Grey100
import com.example.jetpackcamp.ui.theme.Orange100
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    boardViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
        OnBoardingPage.Fourth
    )
    val pagerState = rememberPagerState()
    val score = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 4,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState
        )
        /*FinishButton() {
            /*boardViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()*/
        }*/
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            TextButton(
                onClick = { Screen.Map.route },
                
            ){
                Text(
                    text = onBoardingPage.skip,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Orange100
                )
            }
        }

        Image(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Black100
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Grey100
        )
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange100, contentColor = Color.White),
            onClick = { },
        ) {
            Text(text = onBoardingPage.button, color = Color.White)
        }
    }
}

@Composable
fun FinishButton(
    modifier: Modifier,
    onNextClicked: () -> Unit,
    onBoardingPage: OnBoardingPage
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
            Button(
                onClick = onNextClicked,
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = Orange100
                )
            ) {
                Text(text = onBoardingPage.button, color = Color.White)
            }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}

@Composable
@Preview(showBackground = true)
fun FourthOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Fourth)
    }
}