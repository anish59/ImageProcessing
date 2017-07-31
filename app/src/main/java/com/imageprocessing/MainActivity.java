package com.imageprocessing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.imageprocessing.helper.FunctionHelper;
import com.imageprocessing.helper.GraphicsView;
import com.imageprocessing.helper.ImageProcessor;

public class MainActivity extends AppCompatActivity {

    private ImageView imgInput, imgResult;
    private Context context;
    private Button btnConvert;

    private Bitmap bitmapOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        init();
        initListeners();
    }

    private void initListeners() {
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bitmapInput = BitmapFactory.decodeResource(context.getResources(), R.drawable.image1);
//                bitmapOutput = FunctionHelper.doHighlightImage(bitmapInput);
//                bitmapOutput = FunctionHelper.doInvert(bitmapInput);
//                bitmapOutput = FunctionHelper.doGreyscale(bitmapInput);
//                bitmapOutput = FunctionHelper.doGamma(bitmapInput, 1.8, 1.8, 1.8);
//                bitmapOutput = FunctionHelper.doColorFilter(bitmapInput, 250, 250,500);
//                bitmapOutput = FunctionHelper.createSepiaToningEffect(bitmapInput, 2,20, 0, 0);
//                bitmapOutput = FunctionHelper.decreaseColorDepth(bitmapInput, 32);
//                bitmapOutput = FunctionHelper.decreaseColorDepth(bitmapInput, 32);
//                bitmapOutput = FunctionHelper.createContrast(bitmapInput, 0);
//                bitmapOutput = FunctionHelper.rotate(bitmapInput, 180);
//                bitmapOutput = FunctionHelper.doBrightness(bitmapInput, 25);
//                bitmapOutput = FunctionHelper.applyGaussianBlur(bitmapInput);
//                bitmapOutput = FunctionHelper.sharpen(bitmapInput,5555);
//                bitmapOutput = FunctionHelper.applyMeanRemoval(bitmapInput);
//                bitmapOutput = FunctionHelper.smooth(bitmapInput,10000000);
//                bitmapOutput = FunctionHelper.emboss(bitmapInput);
//                bitmapOutput = FunctionHelper.engrave(bitmapInput);
//                bitmapOutput = FunctionHelper.boost(bitmapInput,2,67);
//                bitmapOutput = FunctionHelper.roundCorner(bitmapInput,45);
//                bitmapOutput = FunctionHelper.flip(bitmapInput, 1);
//                bitmapOutput = FunctionHelper.tintImage(bitmapInput, 20);//nice :)
//                bitmapOutput = FunctionHelper.applyFleaEffect(bitmapInput);
//                bitmapOutput = FunctionHelper.applyBlackFilter(bitmapInput);
//                bitmapOutput = FunctionHelper.applySnowEffect(bitmapInput);
//                bitmapOutput = FunctionHelper.applyShadingFilter(bitmapInput, getResources().getColor(R.color.colorAccent));
//                bitmapOutput = FunctionHelper.applySaturationFilter(bitmapInput, 50);
//                bitmapOutput = FunctionHelper.applyHueFilter(bitmapInput, 50);
//                setWaterMarkText(bitmapInput);
//                changePixelColor(bitmapInput);
//                new GraphicsView(context,"hello qwert ASDDS");//NO IDEA
                bitmapOutput = FunctionHelper.applyReflection(bitmapInput);
                imgResult.setImageBitmap(bitmapOutput);
            }
        });
    }

    private void changePixelColor(Bitmap bitmapInput) { //not getting idea
        ImageProcessor imgProcr = new ImageProcessor(bitmapInput);
        bitmapOutput = imgProcr.replaceColor(context.getResources().getColor(R.color.fromColor), context.getResources().getColor(R.color.toColor));
    }

    private void setWaterMarkText(Bitmap bitmapInput) { //not getting idea
        Point point = new Point();
        point.set((int) (imgInput.getX() + imgInput.getWidth() / 2), (int) (imgInput.getY() + imgInput.getHeight() / 2));
        bitmapOutput = FunctionHelper.waterMark(bitmapInput, "Pirates", point, R.color.colorPrimaryDark, 0, 100, true);
    }

    private void init() {
        btnConvert = (Button) findViewById(R.id.btnConvert);
        imgResult = (ImageView) findViewById(R.id.imgResult);
        imgInput = (ImageView) findViewById(R.id.imgInput);

        imgInput.setBackgroundResource(R.drawable.image1);
        //or
        //imgInput.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.image1));

    }


}
