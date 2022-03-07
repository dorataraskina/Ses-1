package com.example.jetpackcamp.onboard

import androidx.annotation.DrawableRes
import com.example.jetpackcamp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
    val skip: String,
    val button: String
) {
    object First : OnBoardingPage(
        image = R.drawable.b1,
        title = "Привет!",
        description = "Coffee toGo – это приложение в котором вы можете заказать кофе онлайн и забрать его в близжайшей к вам кофейне.\n" +
                "Сейчас расскажем как оно работает",
        skip = "Пропустить",
        button = "Дальше"
    )

    object Second : OnBoardingPage(
        image = R.drawable.b2,
        title = "Поиск кофейни",
        description = "На карте указаны близжайшие к вам кофейни, выбирайте наиболее удобную для вас. Приложение подскажет как долго до неё идти.",
        skip = "Пропустить",
        button = "Дальше"
    )

    object Third : OnBoardingPage(
        image = R.drawable.b3,
        title = "Оформление заказа",
        description = "Выбирайте свои любимые напитки и десерты. Вы можете изменить их состав и выбрать время, когда вам будет удобно их забрать.",
        skip = "Пропустить",
        button = "Дальше"
    )
    object Fourth : OnBoardingPage(
        image = R.drawable.b4,
        title = "Получение заказа",
        description = "В указанное время приходите в кофейню и наслаждайтесь вкусом кофе, без очереди и ожидания.",
        skip = "",
        button = "Начать"
    )
}