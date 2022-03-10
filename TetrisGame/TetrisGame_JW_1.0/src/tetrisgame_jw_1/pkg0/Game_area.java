package tetrisgame_jw_1.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import tetrisblocks.*;

public class Game_area extends JPanel{
    
    public int meshRow;
    public int meshCol;
    public int size;     //kich thuoc 1 o
    private Color[][] background;
    
    private Blocks block;
    private Blocks[] blocks;    //mang cho cac block 
    
    public Game_area(JPanel gamescene, int columns){
        
        //gamescene.setVisible(false);
        this.setBounds(gamescene.getBounds());
        this.setBackground(gamescene.getBackground());
        this.setBorder((gamescene.getBorder()));
        
        meshCol = columns;
        size = this.getBounds().width / meshCol;
        meshRow = this.getBounds().height / size;

        blocks = new Blocks[]{ new IShape(),
                               new JShape(),
                               new LShape(),
                               new OShape(),
                               new SShape(),
                               new TShape(),
                               new ZShape()};
    }
    
    public void initBackgroundArray(){
        background = new Color[meshRow][meshCol];
    }
    
    
    //tao block ngau nhien (su dung spawn ben lop Blocks)
    public void createBlock(){
        Random r = new Random();
        block = blocks[r.nextInt(blocks.length)];
        block.spawn(meshCol);
    }
    
    
    //block full man hinh loi ra ngoai -> gameover
    public boolean isBlockOutOfBounds(){
        if(block.getY() < 0){
            block = null;
            return true;
        }
        return false;
    }
    
    //block roi xuong
    public boolean moveBlockDown(){
        //check block cham day, ket thuc block roi xuong
        if(checkBottom() == false){
            //moveBlockToBackground();
            //clearLines();
            return false;
        }
        block.moveDown();
        repaint();
        
        return true;
    }
    
    
    //RIGHT
    public void moveBlockRight(){
        
        if(block == null)
            return;
        if(!checRight())
            return;
        
        block.moveRight();
        repaint();
    }
    //LEFT
    public void moveBlockLeft(){
        
        if(block == null)
            return;
        if(!checLeft())
            return;
        
        block.moveLeft();
        repaint();
    }
    //DOWN
    public void dropBlock(){
        
        if(block == null)
            return;
        while(checkBottom()){
            block.moveDown();
        }
        repaint();
    }
    //UP
    public void rotateBlock(){
        
        if(block == null)
            return;
        block.rotate();
        
        //fix xoay block tran vien
        if(block.getLeftEdge() < 0){
            block.setX(0);
        }
        if(block.getRightEdge() >= meshCol){
            block.setX(meshCol - block.getWidth());
        }
        if(block.getBottomEdge() >= meshRow){
            block.setY(meshRow - block.getHeight());
        }
        
        //check khi xoay co trung voi nen
        
        repaint();
    }
    
    //kiem tra block cham day và dung
    private boolean checkBottom(){
        if(block.getBottomEdge() == meshRow){
            return false;
        }
        
        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();
        
        for(int col = 0; col < w; col++){
            for(int row = h - 1; row >= 0; row--){
                if(shape[row][col] != 0){
                    int x = col + block.getX();
                    int y = row + block.getY() + 1;
                    if(y<0) break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }
        return true;
    }
    
    
    //kiem tra block khong cho tran canh trai
    private boolean checLeft(){
        if(block.getLeftEdge() == 0)
            return false;
        
        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();
        
        for(int row = 0; row < h; row++){
            for(int col = 0; col < w; col++){
                if(shape[row][col] != 0){
                    int x = col + block.getX() - 1;
                    int y = row + block.getY();
                    if(y<0) break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }
        return true;
    }
    
    //kiem tra block khong cho tran canh phai
    private boolean checRight(){
        if(block.getRightEdge() == meshCol)
            return false;
        
        int[][]shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();
        
        for(int row = 0; row < h; row++){
            for(int col = w - 1; col >= 0; col--){
                if(shape[row][col] != 0){
                    int x = col + block.getX() + 1;
                    int y = row + block.getY();
                    if(y<0) break;
                    if(background[y][x] != null)
                        return false;
                    break;
                }
            }
        }
        return true;
    }
    
    public int clearLines(){
        
        boolean lineFilled;
        int linesCleared = 0;
        
        for(int r = meshRow - 1; r >= 0; r--){
            lineFilled = true;
            
            for(int c = 0; c < meshCol; c++){
                if(background[r][c] == null){
                    lineFilled = false;
                    break;
                }
            }
            
            if(lineFilled){
                linesCleared++;
                
                clearLine(r);
                shiftDown(r);
                clearLine(0); //hang tren cung thanh null
                
                r++;
                
                repaint();
            }
        }
        return linesCleared;
    }
    
    private void clearLine(int r){
        for(int i = 0; i < meshCol; i++){
            background[r][i] = null;
        }
    }
    
    //hang day xuong khi clearLine
    private void shiftDown(int r){
        for(int row = r; row > 0; row--){
            for(int col = 0; col < meshCol; col++){
                background[row][col] = background[row - 1][col];
            }
        }
    }
    
    
    public void moveBlockToBackground(){
        int[][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        
        int xPos = block.getX();
        int yPos = block.getY();
        
        Color color = block.getColor();
        
        for(int r = 0; r < h; r++){
            for(int c = 0; c < w; c++){
                if(shape[r][c] == 1){
                    background[r + yPos][c + xPos] = color;
                }
            }
        }
    }
    
    //ve block khi block dc tao ra
    private void drawBlock(Graphics g){
        int w = block.getWidth();
        int h = block.getHeight();
        
        Color c = block.getColor();
        int[][] shape = block.getShape();
        
        for(int row = 0; row < h; row++){
            for(int col = 0; col < w; col++){
                if(shape[row][col] == 1){
                    int x = (block.getX() + col) * size;
                    int y = (block.getY() + row) * size;
                    
                    drawGridSquare(g, c, x, y);
                }     
            }
        }
    }
    
    
    //luu (ve) khoi cham day
    private  void drawBackground(Graphics g){
        Color color;
        for(int r = 0; r < meshRow; r++){
            for(int c = 0; c < meshCol; c++){
                color = background[r][c];
                
                if(color != null){
                    int x = c * size;
                    int y = r * size;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }
    
    //ve block co ban
    private  void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, size, size);
        g.setColor(Color.black);
        g.drawRect(x, y, size, size);
    }

    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        //ve luoi
        for(int y = 0; y < meshRow; y++){
            for(int x = 0; x < meshCol; x++){
                g.drawRect(x * size, y * size, size, size);
            }
        }

        drawBlock(g);
        drawBackground(g);
    }
        
}
