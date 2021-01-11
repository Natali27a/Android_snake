package top.BFU.snake

import android.graphics.Color
import android.graphics.Paint

object SnakeGamePaint {
    val snakeBodyPaint = Paint().apply {
        isDither = true
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.GREEN
    }

    val snakeHeaderPaint = Paint().apply {
        isDither = true
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.YELLOW
    }

    val foodPaint = Paint().apply {
        isDither = true
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.RED
    }
}