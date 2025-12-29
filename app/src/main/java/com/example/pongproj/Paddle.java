package com.example.pongproj;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;


public abstract class Paddle extends Sprite{
    public RectF rect;
    private float width;
    private float height;
    private float x;
    private float y;

    public Paddle(float screenWidth, float screenHeight)
    {
        width = 200;
        height = 40;
        x = screenWidth / 2 - width / 2;
        y = screenHeight - 100;
        rect = new RectF(x, y, x + width, y + height);
    }

    public void Update(float touchX, float screenWidth)
    {
        x = touchX - width / 2;
        if (x < 0) x = 0;
        if (x + width > screenWidth) x = screenWidth - width;

        rect.left = x;
        rect.right = x + width;
    }








}
