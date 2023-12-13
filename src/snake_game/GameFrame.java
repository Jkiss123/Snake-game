/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake_game;

import javax.swing.JFrame;

/**
 *
 * @author Cloudy
 */
public class GameFrame extends JFrame {
    
    GameFrame(){
        this.setTitle("Snake Game");
        this.add(new GamePanels());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
}
