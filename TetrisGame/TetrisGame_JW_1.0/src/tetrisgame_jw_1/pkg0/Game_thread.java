package tetrisgame_jw_1.pkg0;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game_thread extends Thread{

    private Game_area ga;
    private Game_form gf;
    
    private int score;
    private int level = 1;
    private int scorePerLevel = 4;
    
    private int delay = 1000;           //khoang tre
    private int speedupPerLevel = 100;
    
    public Game_thread(Game_area ga, Game_form gf){
        this.ga = ga;
        this.gf = gf;

        gf.updateScore(score);
        gf.updateLevel(level);
    }
    
    @Override
    public void run(){
        //vong lap vo han, block roi xuong kh gioi han
        while(true){
            ga.createBlock();
            while(ga.moveBlockDown()){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    return;
                }
            }
            
            if(ga.isBlockOutOfBounds()){
                TetrisGame_JW_10.gameOver(score);
                break;
            }
            
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            
            int lvl = score / scorePerLevel + 1;
            if(lvl > level){
                level = lvl;
                gf.updateLevel(level);
                delay -= speedupPerLevel;
            }
        }
    }
}
