package com.louisgeek.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by louisgeek on 2016/4/26.
 */
public class MyView extends View {
    Paint mPaint;
    public MyView(Context context) {
        //super(context);
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {

        mPaint=new Paint();
        //mPaint.set(new Paint());//用于赋值
        mPaint.setColor(Color.parseColor("#FF00FF"));//设置颜色
        //mPaint.setARGB((255,127,255,212);//设置透明度和颜色，a代表透明度，r，g，b代表颜色值
        mPaint.setStrokeWidth(10);//当画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的粗细度

        mPaint.setTextSize(40);//设置文字大小 太小看不到。。。
       // mPaint.setTextScaleX(2.5f); //设置文字x轴的缩放比例，可以实现文字的拉伸效果
        //mPaint.setTextSkewX(-0.5f); //设置文字倾斜弧度
       // mPaint.setUnderlineText(true); //设置文字下划线效果
        //mPaint.setStrikeThruText(true); //设置删除线效果
       // mPaint.setTypeface(Typeface.DEFAULT_BOLD);//设置字体风格
        //mPaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD)); //设置字体风格Typeface.defaultFromStyle(Typeface.BOLD)
        //mPaint.setTextAlign(Paint.Align.LEFT); //设置文字的对齐方向,，接收的参数为Paint的内部枚举类Align的值，可选LEFT、CENTER和RIGHT

        mPaint.setAlpha(50); //设置透明度，alpha为透明度,取值范围为0~255,数值越小越透明
        mPaint.setAntiAlias(true); //设置是否使用抗锯齿功能，比较耗资源，减慢绘制速度
        mPaint.setDither(true);// 设定是否使用图像抖动，如true，绘制出来的图片颜色更饱满、清晰
        /**
         * 当style为FILL时，绘制是填充面，FILL是Paint默认的style；
         当style为STROKE时，绘制的是图形的轮廓线；
         当style为FILL_AND_STROKE时，同时绘制填充面和轮廓线，不过这种情况用的不多，因为填充面和轮廓线是用同一种颜色绘制的，区分不出轮廓线的效果。
         */
       // mPaint.setStyle(Paint.Style.FILL_AND_STROKE); //设置画笔的样式，为FILL，FILL_AND_STROKE，或STROKE

        //Cap.BUTT:The stroke ends with the path, and does not project beyond it.
        //mPaint.setStrokeCap(Paint.Cap.BUTT);//当画笔样式为STROKE或FILL_AND_STROKE时，设置笔刷的图形样式，如圆形样式  Cap.ROUND,或方形样式Cap.SQUARE
        //mPaint.setFakeBoldText(true); // 将画笔设置为粗体
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**颜色*/
        // canvas.drawColor(Color.GRAY);

        /**点*/
        mPaint.setColor(Color.DKGRAY);
        //#canvas.drawPoint(100, 100, mPaint);

        /**文字*/
        //如不setTextAlign(... ...)的话，第二个参数 x 默认是字符串的左边的位置，第三个参数则固定为这个字符串的baseline的位置。
        canvas.drawText("博客", 0, 240, mPaint);//x y
        mPaint.setColor(Color.RED);
        canvas.drawText(new char[]{'a', 's', 'd', 'f', '9', '0', '8', '7'}, 2, 4, 450, 0, mPaint);//index count x y
        mPaint.setColor(Color.GREEN);
        canvas.drawText("qwer312445342", 2, 6, 800, 800, mPaint); //含头不含尾  start end x y

        /** 按照指定点的坐标绘制文本*/
        mPaint.setColor(Color.DKGRAY);
        canvas.drawPosText("qwer", new float[]{150.0f, 150.0f, 200.0f, 200.0f, 350.0f, 350.0f, 600.0f, 600.0f,}, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawPosText(new char[]{'z', 'x', 'c', 'v'}, 2, 2, new float[]{50.0f, 50.0f, 100.0f, 100.0f, 250.0f, 250.0f, 500.0f, 500.0f,}, mPaint);//index count

        /**矩形*/
       // canvas.drawRect(new Rect(0, 0, 200, 200), mPaint);
        //canvas.drawRect(100,100,300,300,mPaint);

        /**圆形*/
        //圆中心的坐标x 中心的坐标y //半径200
        //canvas.drawCircle(300, 300, 200, mPaint);

        /**弧线区域*/
        //矩形
        RectF rect1 = new RectF(0, 0, 100, 100);
       /* canvas.drawArc(rect1, //弧线所使用的矩形区域大小
                0,  //开始角度
                90, //扫过的角度
                false, //是否使用中心
                mPaint);*/

        /**弧线区域*/
        RectF rect2 = new RectF(0, 0, 100, 100);
      /*  canvas.drawArc(rect2, //弧线所使用的矩形区域大小
                0,  //开始角度
                90, //扫过的角度
                true, //是否使用中心
                mPaint);*/

        /**圆角矩形*/
       /*## canvas.drawRoundRect( new RectF(0, 0, 150, 150),
                30, //x轴的半径
                30, //y轴的半径
                mPaint);*/

        /**路径*/
        Path path1 = new Path(); //定义一条路径
        path1.moveTo(10, 10); //移动到 坐标10,10
        path1.lineTo(50, 60);
        path1.lineTo(200,80);
        path1.lineTo(10, 10);
       // path1.close();
      //##  canvas.drawPath(path1, mPaint);

        /**文字路径*/
        Path path2 = new Path(); //定义一条路径
        path2.moveTo(10, 10); //移动到 坐标10,10
        path2.lineTo(50, 360);
        path2.lineTo(560, 380);
        path2.lineTo(10, 10);
        // canvas.drawPath(path2, mPaint);
       // canvas.drawTextOnPath("1234567890", path2, 10, 10, mPaint);


        /**椭圆*/
        //定义一个矩形区域
        RectF oval = new RectF(0,0,200,300);
        mPaint.setColor(Color.YELLOW);
        //矩形区域内切椭圆
       //## canvas.drawOval(oval, mPaint);


        /**线*/
        //画一条线
       mPaint.setColor(Color.RED);
        canvas.drawLine(10, 10, 100, 100, mPaint);
        canvas.rotate(10); //【旋转】顺时针旋转10度
        canvas.scale(3, 3);//【放大】
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(250, 250, 350, 350, mPaint);



      /*  canvas.drawText("00000000", 800, 700, mPaint);
        canvas.drawText("||||||||||||||||", 800, 600, mPaint);
        canvas.drawText("—————", 800, 700, mPaint);*/


        /*canvas.drawText("00000000", 400, 700, mPaint);
        canvas.translate(0, 300);//x y位移距离//【平移】
        canvas.drawText("||||||||||||||||", 400, 600, mPaint);
        canvas.drawText("—————", 400, 700, mPaint);*/


      /*  canvas.drawText("00000000", 0, 700, mPaint);
        canvas.save();
        canvas.translate(0, 300);//x y位移距离
        canvas.drawText("||||||||||||||||", 0, 600, mPaint);
        canvas.restore();
        canvas.drawText("—————", 0, 700, mPaint);
*/



    }
}
