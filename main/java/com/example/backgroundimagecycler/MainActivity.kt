package com.example.backgroundimagecycler

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.moveTaskToBack(true)   // Minimize app
        setWallpaper()
        while (true) {
            setWallpaper()
            Thread.sleep((60*30*1000).toLong()) // Every 30 minutes change wallpaper
        }
    }

    private fun setWallpaper() {
        val number = (0..14).random()   // Generate a number between 0 and 14 (both included)

        // Didn't found a better way to do this
        // Right now the images are hardcoded, can change in the future
        val bitmap = when (number) {
            0 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper0) }
            1 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper1) }
            2 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper2) }
            3 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper3) }
            4 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper4) }
            5 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper5) }
            6 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper6) }
            7 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper7) }
            8 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper8) }
            9 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper9) }
            10 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper10) }
            11 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper11) }
            12 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper12) }
            13 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper13) }
            14 -> { BitmapFactory.decodeResource(resources, R.drawable.wallpaper14) }
            else -> {}
        } as Bitmap

        val wallpaperManager = WallpaperManager.getInstance(baseContext)

        // Get screen details
        val drawable = wallpaperManager.builtInDrawable
        wallpaperManager.setWallpaperOffsetSteps(0F, 0F)
        val height = drawable.intrinsicHeight
        val width = drawable.intrinsicWidth
        wallpaperManager.suggestDesiredDimensions(width / 3, height)

        // Set wallpaper (both lock and system)
        wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_LOCK)
        wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_SYSTEM)
    }
}