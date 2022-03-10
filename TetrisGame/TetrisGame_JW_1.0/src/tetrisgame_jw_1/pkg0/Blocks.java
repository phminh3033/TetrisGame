package tetrisgame_jw_1.pkg0;

import java.awt.Color;
import java.util.Random;

public class Blocks {
    //thong so block
    private int[][] shape;      //xac dinh hinh dang của block
    private Color color;        //to mau cho block
    private int x,y;            //toa do vi tri block so voi goc toa do
    
    //thong so dang xoay block
    private int[][][] shapes;   //luu tru cac dang xoay cua block
    private int currentRotation;//luu tru dang xoay hien tai cua block
    
    private Color[] availableColors = {Color.GRAY, 
                                       Color.RED,
                                       Color.BLUE,
                                       Color.PINK,
                                       Color.ORANGE,
                                       Color.YELLOW,
                                       Color.MAGENTA,
                                       Color.DARK_GRAY,
                                       Color.CYAN};
    
    public Blocks(int[][] shape){
        this.shape = shape;

        initShapes();
    }
    
    private void initShapes(){
        shapes = new int[4][][];
        
        for(int i = 0; i < 4; i++){
            int r = shape[0].length;    //hang (dang moi) = cot (chieu ngang dang cu)
            int c = shape.length;       //cot (dang moi) = hang (chieu cao dang cu)
            
            shapes[i] = new int[r][c];
            
            for(int y = 0; y < r; y++){
                for(int x = 0; x < c; x++){
                    shapes[i][y][x] = shape[c - x - 1][y];
                }
            }
            
            shape = shapes[i];
        }
    }
    
    //tao block
    public  void spawn(int meshWidth){
        
        Random r = new Random();
        
        //random form roi
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        
        //random vi tri roi
        y = 0 - getHeight();
        x = r.nextInt(meshWidth - getWidth());
        //sinh block o trung tam x = (meshWidth - getWidth()) / 2;
        
        color = availableColors[r.nextInt(availableColors.length)];
    }
    
    public int[][] getShape(){ return shape; }      //xac dinh hinh dang của block
    
    public  Color getColor(){ return color; }       //to mau cho block
    
    public int getHeight(){ return shape.length; }      //chieu cao của block
    
    public int getWidth(){ return shape[0].length; }    //chieu ngang cua block
    
    public int getX() { return x; }                     //toa do x cua block so voi goc toa do
    public void setX(int newX) {x = newX;}
    
    public int getY() { return y; }                     //toa do y cua block so voi goc toa do
    public void setY(int newY) {y = newY;}
    
    public void moveDown(){ y++; }              //tang y de block roi xuong
    public void moveLeft(){ x--; }              //tang x de block qua phai
    public void moveRight(){ x++; }             //giam x de block qua trai
    
    //xet dang xoay hien tai cua block
    public void rotate(){
        currentRotation++;
        
        if(currentRotation > 3)
            currentRotation = 0;
        
        shape = shapes[currentRotation];
    }
    
    public int getBottomEdge(){ return y + getHeight(); }   //toa do y (block) + chieu cao (block) = chieu cao cua luoi
    
    public int getLeftEdge(){ return x; }
    
    public int getRightEdge(){ return x + getWidth(); }
}
