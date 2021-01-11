package top.BFU.snake

import android.graphics.Canvas
import android.graphics.Paint

open class GameObject(var row: Int, var column: Int) {
    open fun draw(canvas: Canvas, x: Float, y: Float, paint: Paint) {
        canvas.drawRect(x, y, x + SnakeGameConfiguration.GRID_WIDTH, y + SnakeGameConfiguration.GRID_HEIGHT, paint)
    }
}