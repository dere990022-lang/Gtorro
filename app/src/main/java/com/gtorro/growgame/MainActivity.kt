package com.gtorro.growgame

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gameView = findViewById<GameView>(R.id.game_view)
        findViewById<Button>(R.id.button_left).setOnClickListener { gameView.movePlayer(-1, 0) }
        findViewById<Button>(R.id.button_right).setOnClickListener { gameView.movePlayer(1, 0) }
        findViewById<Button>(R.id.button_up).setOnClickListener { gameView.movePlayer(0, -1) }
        findViewById<Button>(R.id.button_down).setOnClickListener { gameView.movePlayer(0, 1) }
        findViewById<Button>(R.id.button_place).setOnClickListener { gameView.placeBlock() }
        findViewById<Button>(R.id.button_remove).setOnClickListener { gameView.removeBlock() }
    }
}
