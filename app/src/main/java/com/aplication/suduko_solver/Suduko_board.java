package com.aplication.suduko_solver;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Suduko_board extends View {


    private Paint paint, fill_paint;
    private Paint textPaint;
    private Rect letterBoundsPaint = new Rect();
    private int color, fill_color;
    int x = -1, y = -1;
    float cell_Size;
    private TypedArray typedArray;
    public static Solver solver = new Solver();


    public Suduko_board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//      Suduko_board.solver = new Solver();
        Suduko_board.solver.fill_withRandomNumber();

        this.cell_Size = this.getWidth() / 9;
        paint = new Paint();
        fill_paint = new Paint();

        this.textPaint = new Paint();


        typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Suduko_board, 0, 0);

        try {
            color = typedArray.getInteger(R.styleable.Suduko_board_BOARDCOLOR, 0x000000);
            fill_color = typedArray.getInteger(R.styleable.Suduko_board_FILL_COLOR, 0x400099F9);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dim = (getMeasuredWidth() > getMeasuredHeight()) ? getMeasuredHeight() : getMeasuredWidth();
        System.out.println("dim : " + dim);
        this.setMeasuredDimension(dim, dim);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, this.getWidth(), this.getWidth(), paintWith(30));
        drawBoard(canvas);
        fillCell(canvas, this.solver.getCurrent_Column(), this.solver.getCurrent_Row());
       if (Suduko_board.solver.getCurrent_Row() >-1 && Suduko_board.solver.getCurrent_Column() > -1)
        drawText(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        Suduko_board.solver.setCurrent_Column((int) (event.getX() / this.cell_Size));
        Suduko_board.solver.setCurrent_Row((int) (event.getY() / this.cell_Size));
        Suduko_board.solver.showBoard();

        invalidate();

        return super.onTouchEvent(event);
    }

    // Non Overridden functions
    void fillCell(Canvas canvas, int x, int y) {
        if (x > -1 && y > -1) {

            this.cell_Size = this.getWidth() / 9;
            fill_paint.setStyle(Paint.Style.FILL);
            fill_paint.setColor(this.fill_color);
            fill_paint.setAntiAlias(true);
// for column
            canvas.drawRect(cell_Size * x, 0, (x + 1) * cell_Size, this.getWidth(), fill_paint);
            canvas.drawRect(0, y * cell_Size, this.getWidth(), cell_Size * (y + 1), fill_paint);

        }
    }

    void drawBoard(Canvas canvas) {
        int size = 5;
        this.cell_Size = this.getWidth() / 9;
        for (int x = 1; x < 9; x++) {
            if (x % 3 == 0) {
                size = 13;
            } else {
                size = 5;
            }
            canvas.drawLine(0, cell_Size * x, getWidth(), cell_Size * x, paintWith(size));
            canvas.drawLine(cell_Size * x, 0, cell_Size * x, getWidth(), paintWith(size));
            canvas.drawLine(0, cell_Size * x, getWidth(), cell_Size * x, paintWith(size));
            canvas.drawLine(cell_Size * x, 0, cell_Size * x, getWidth(), paintWith(size));

            // for rows

        }
    }

    Paint paintWith(int size) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(size);
        paint.setColor(color);
        paint.setAntiAlias(true);

        return this.paint;
    }

    void DrawNumber(Canvas canvas) {

        this.cell_Size = this.getWidth() / 9;

        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(0xFF2210);
        this.textPaint.setAntiAlias(true);


        // for (int y = 0; y < 9; y++) {
        //   for (int x = 0; x < 9; x++) {

        textPaint.getTextBounds("Style.FILL", 0,10 , letterBoundsPaint);
        textPaint.setColor(Color.BLUE);
        float letter_width = textPaint.measureText(7 + "");
        float height = letterBoundsPaint.height();
        System.out.println("letter_w : " + letter_width);
        System.out.println("letter_h : " + height);

        System.out.println("draw number start");
       // canvas.drawRect(Suduko_board.solver.getCurrent_Column() * this.cell_Size , Suduko_board.solver.getCurrent_Row() * this.cell_Size , 0 , cell_Size , textPaint);
        //canvas.drawText(7 + "", this.cell_Size * x + (cell_Size - letter_width / 2), this.cell_Size * y + (cell_Size - height) / 2, textPaint);
        canvas.drawText("Style.FILL", 0, 0, textPaint);
        // }Suduko_board.solver.getValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row())

        //}
    }
    void drawText(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setTextSize(this.cell_Size-30);

        Rect rect = new Rect();
        paint.getTextBounds("8", 0, 1, rect);
        for (int y = 0 ; y<9 ; y++ ) {
            for (int x =0 ; x<9 ; x++ ) {
                if( Suduko_board.solver.getValueAt(x , y)
                        !=0)
                canvas.drawText("5" + "", (x) * cell_Size +  (cell_Size - rect.width())/2, (float) ((y + 1) * (cell_Size) - (cell_Size - rect.height() )/2), paint);
            }
        }



    }
}

