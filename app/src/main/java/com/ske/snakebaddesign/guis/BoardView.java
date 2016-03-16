package com.ske.snakebaddesign.guis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ske.snakebaddesign.models.Board;

public class BoardView extends View {
    public Board board;
    // Graphics variables
    private Paint paint;
    private float viewWidth;
    private float cellSize;
    private float padding;
    private float playerSize;
    private int colorP1 = Color.WHITE;
    private int colorP2 = Color.BLACK;
    private int colorBG = Color.parseColor("#6d8d46");
    private int colorText = Color.parseColor("#FFFFFF");

    public BoardView(Context context) {
        super(context);
        init();
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        reloadViewDimensions();
        drawBoard(canvas);
        drawSquares(canvas);
        drawPlayerPieces(canvas);
    }

    public void setBoard(Board board) {
        this.board = board;
        postInvalidate();
    }

    private void init() {
        board = new Board(1);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);
    }


    private void reloadViewDimensions() {
        viewWidth = getWidth();
        cellSize = (viewWidth / board.getSize());
        padding = 0.05f * cellSize;
        playerSize = cellSize/8;
    }

    private void drawBoard(Canvas canvas) {
        paint.setColor(colorBG);
        canvas.drawRect(0, 0, viewWidth, viewWidth, paint);
    }

    private void drawSquares(Canvas canvas) {
        int squareIndex = 0;
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                float startX = i * cellSize + padding/2;
                float startY = j * cellSize + padding/2;
                float endX = startX + cellSize - padding;
                float endY = startY + cellSize - padding;
                paint.setColor(board.getSquare(squareIndex).getColor());
                canvas.drawRect(startX, startY, endX, endY, paint);
                paint.setColor(colorText);
                String label = (j *  board.getSize() + i + 1) + "";
                canvas.drawText(label, startX + cellSize/2 - padding/2, startY + cellSize/2, paint);
                squareIndex++;
            }
        }
    }

    private void drawPlayerPieces(Canvas canvas) {
        // Draw player 1 (0.33 is the 1/3 position of the cell height)
        paint.setColor(colorP1);
        float p1X = positionToCol(board.getPiece(0).getPosition()) * cellSize + cellSize/2;
        float p1Y = positionToRow(board.getPiece(0).getPosition()) * cellSize + (cellSize * 0.33f);
        canvas.drawCircle(p1X, p1Y, playerSize, paint);
        // Draw player 2 (0.66 is the 2/3 position of the cell height)
        paint.setColor(colorP2);
        float p2X = positionToCol(board.getPiece(1).getPosition()) * cellSize + cellSize/2;
        float p2Y = positionToRow(board.getPiece(1).getPosition()) * cellSize + (cellSize * 0.66f);
        canvas.drawCircle(p2X, p2Y, playerSize, paint);
    }

    private int positionToRow(int position) {
        return position / board.getSize();
    }

    private int positionToCol(int position) {
        return position % board.getSize();
    }

}
