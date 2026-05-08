package com.gtorro.growgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GameView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    companion object {
        private const val COLUMNS = 20
        private const val ROWS = 14
    }

    private val tiles = Array(ROWS) { IntArray(COLUMNS) }
    private var playerX = 2
    private var playerY = ROWS - 4
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var selectedTile = 1

    init {
        generateWorld()
    }

    private fun generateWorld() {
        for (y in 0 until ROWS) {
            for (x in 0 until COLUMNS) {
                tiles[y][x] = when {
                    y >= ROWS - 2 -> 3
                    y == ROWS - 3 -> 2
                    y == ROWS - 4 -> if ((x + y) % 2 == 0) 1 else 0
                    else -> 0
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val cellWidth = width.toFloat() / COLUMNS
        val cellHeight = height.toFloat() / ROWS

        canvas.drawColor(Color.rgb(100, 175, 255))

        for (y in 0 until ROWS) {
            for (x in 0 until COLUMNS) {
                paint.color = when (tiles[y][x]) {
                    1 -> Color.rgb(165, 124, 78)
                    2 -> Color.rgb(88, 154, 68)
                    3 -> Color.rgb(117, 117, 117)
                    else -> Color.TRANSPARENT
                }
                if (tiles[y][x] != 0) {
                    canvas.drawRect(
                        x * cellWidth,
                        y * cellHeight,
                        (x + 1) * cellWidth,
                        (y + 1) * cellHeight,
                        paint
                    )
                }
            }
        }

        paint.color = Color.YELLOW
        canvas.drawRect(
            playerX * cellWidth,
            playerY * cellHeight,
            (playerX + 1) * cellWidth,
            (playerY + 1) * cellHeight,
            paint
        )

        paint.textSize = cellHeight * 0.6f
        paint.color = Color.WHITE
        canvas.drawText("PASANG: DIRT", 12f, cellHeight * 0.8f, paint)
        canvas.drawText("Posisi: $playerX,$playerY", 12f, cellHeight * 1.5f, paint)
    }

    fun movePlayer(dx: Int, dy: Int) {
        val nextX = (playerX + dx).coerceIn(0, COLUMNS - 1)
        val nextY = (playerY + dy).coerceIn(0, ROWS - 1)
        if (tiles[nextY][nextX] == 0) {
            playerX = nextX
            playerY = nextY
            invalidate()
        }
    }

    fun placeBlock() {
        val targetX = playerX
        val targetY = (playerY + 1).coerceAtMost(ROWS - 1)
        if (tiles[targetY][targetX] == 0) {
            tiles[targetY][targetX] = selectedTile
            invalidate()
        }
    }

    fun removeBlock() {
        val targetX = playerX
        val targetY = (playerY + 1).coerceAtMost(ROWS - 1)
        if (tiles[targetY][targetX] != 0) {
            tiles[targetY][targetX] = 0
            invalidate()
        }
    }
}
