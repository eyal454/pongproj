package com.example.pongproj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball extends Sprite{
    private float r;    // radius size
    private Paint p;
    private float canvasWidth;
    private float canvasHeight;
    private float VelX, VelY;


    public Ball(float x, float y, float r) {
        super(x,y,r/2,15);
        this.r = r;
        this.p = new Paint();
        p.setColor(Color.WHITE);
    }

    public void move()
    {
        if(x<r || x>canvasWidth-r)
            dx = -dx;
        if(y<r || y>canvasHeight-r)
            dy = -dy;

        x = x + dx;
        y = y + dy;
    }

    public void draw(Canvas canvas)
    {
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        canvas.drawCircle(x,y,r,p);
    }

    public void checkCollisions(Ball ball, Paddle paddle, int screenWidth, int screenHeight) {

        // left and right Wall Collisions
        if (ball.x - ball.r < 0 || ball.x + ball.r > screenWidth) {
            dx = -dx;
        }

        // top Wall Collision
        if (ball.y - ball.r < 0) {
            dy = -dy;
        }

        // paddle colision
        if (RectF.intersects(paddle.rect, new RectF(
                ball.x - ball.r,
                ball.y - ball.r,
                ball.x + ball.r,
                ball.y + ball.r))) {

            dy = -dy;
            ball.y = paddle.rect.top - ball.r;


        }

        //  bottom Wall (Game Over)
        if (ball.y - ball.r > screenHeight) {

        }
    }
}
