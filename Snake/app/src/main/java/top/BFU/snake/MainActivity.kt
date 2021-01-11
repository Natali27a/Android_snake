package top.BFU.snake

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import top.littledavid.snake.callbacks.OnCrashListener
import top.littledavid.snake.callbacks.OnEatenFoodListener

class MainActivity : AppCompatActivity() {
    var point = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        snake.eatenListener = object : OnEatenFoodListener {
            override fun onEaten() {
                point += 1
                tvPoint.text = point.toString()
            }
        }

        snake.crashListener = object : OnCrashListener {
            override fun onCrash() {
                AlertDialog.Builder(this@MainActivity)
                        .setTitle("Змейка умерла =(")
                        .setMessage("Что будем делать?")
                        .setPositiveButton("Начать сначала", DialogInterface.OnClickListener { dialog, which ->
                            snake.restart()
                            dialog.dismiss()
                        })
                        .setNegativeButton("Выйти", DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                            finish()
                        }).show()
            }

        }
    }

    fun start(view: View) {
        if (!snake.isStarted) {
            snake.start()
        }
    }

    fun move(view: View) {
        if (!snake.isStarted) {
            Toast.makeText(this, "Пожалуйста, нажмите кнопку начать!", Toast.LENGTH_SHORT).show()
            return
        }

        when (view.id) {
            R.id.btnUp -> snake.direction = SnakeGameView.DIRECTION.DIRECTION_UP
            R.id.btnDown -> snake.direction = SnakeGameView.DIRECTION.DIRECTION_DOWN
            R.id.btnLeft -> snake.direction = SnakeGameView.DIRECTION.DIRECTION_LEFT
            R.id.btnRight -> snake.direction = SnakeGameView.DIRECTION.DIRECTION_RIGHT
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        snake.isRunning = false
    }
}
