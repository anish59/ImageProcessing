package com.imageprocessing.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import android.graphics.RectF;
import android.view.View;

public class GraphicsView extends View {
    //    private static final String MY_TEXT = "xjaphx: Draw Text on Curve";
    private Path mArc;
    private String txt;

    private Paint mPaintText;

    public GraphicsView(Context context, String text) {
        super(context);
        txt = text;
        mArc = new Path();
        RectF oval = new RectF(50, 100, 200, 250);
        mArc.addArc(oval, -180, 200);
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(20f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawTextOnPath(txt, mArc, 0, 20, mPaintText);
        invalidate();
    }
}