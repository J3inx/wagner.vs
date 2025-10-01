package Plinko;

import java.awt.Color;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.HashMap;

public class PlinkoDriver extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
    public static ArrayList<peg> p = new ArrayList<>();
    private static HashMap<String, Clip> soundClips = new HashMap<>();
    public static ArrayList<ball> b = new ArrayList<>();
    private static int score = 0;
    
    private int mouseX = 0;
    private int mouseT = 0;
    private boolean isClicked = false; // To control selection movement
    private static boolean painter = false;
    private boolean isSpawning = false; // Flag to control continuous spawning

    public static void main(String[] args) throws InterruptedException {
    	preloadSounds();
        JFrame gui = new JFrame();
        PlinkoDriver game = new PlinkoDriver();
        gui.add(game);
        gui.setSize(800, 800);
        gui.setTitle("Plinko");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.addKeyListener(game);
        gui.addMouseListener(game);
        gui.addMouseMotionListener(game);
        game.setFocusable(true);
        game.requestFocusInWindow();

        // Create pegs for the Plinko board
        for (int r = 30; r < 800; r += 51) {
            for (int c = 50; c < 800; c += 51) {
                if (r % 2 == 0) {
                    p.add(new peg(c - 10, r, true));
                } else {
                    p.add(new peg(c + 10, r, true));
                }
            }
        }

        // Main game loop
        while (true) {
            game.repaint();
            Thread.sleep(40);
            game.movement();
        }
    }
    public static void preloadSounds() {
        loadSound("peg_hit", "peg_hit.wav");
        loadSound("score_zone", "score_zone.wav");
    }
    private static void loadSound(String name, String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            soundClips.put(name, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    // Paint the game screen
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 800);

        // Draw green strips at the bottom for score regions
        int separation = 40;
        for (int i = separation; i < 900; i += separation) {
            g.setColor(Color.green);
            g.fillRect(i - separation, 760, separation, 20);
            g.setColor(Color.red);
            g.fillRect(i - 2, 760, 2, 20);
            g.setColor(Color.green);
            g.fillRect(i + 2, 760, separation, 20);
        }

        // Display score
        g.setColor(Color.white);
        g.drawString("Score: " + score, 20, 20);

        // Draw pegs
        g.setColor(Color.red);
        for (peg peg : p) {
            g.fillOval(peg.getxPos(), peg.getyPos(), 10, 10);
        }

        // Draw balls
        if (painter) {
            for (ball currentBall : b) {
                g.setColor(new Color(currentBall.getColorOne(), currentBall.getColorTwo(), currentBall.getColorThree()));
                g.fillOval(currentBall.getxPos(), currentBall.getyPos(), 10, 10);
            }
        } else {
            g.setColor(Color.white);
            g.fillOval(mouseX - 5, 10, 10, 10); // Centered selection oval
        }
    }

  
    public void playSound(String name) {
        Clip clip = soundClips.get(name);
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); // Stop the sound if it's still playing
            }
            clip.setFramePosition(0); // Rewind to the start
            clip.start(); // Play the sound
        }
    }

    // Update ball movement and collisions
 // Update ball movement and collisions
    public void movement() {
        for (int i = 0; i < b.size(); i++) {
            ball currentBall = b.get(i);

            // Update ball position
            currentBall.setxPos(currentBall.getxPos() + currentBall.getXvel());
            currentBall.setyPos(currentBall.getyPos() + currentBall.getYvel());
            currentBall.setYvel(currentBall.getYvel() + 1); // Simulate gravity

            // Check collision with pegs
            for (peg peg : p) {
                double distance = Math.sqrt(Math.pow(currentBall.getxPos() - peg.getxPos(), 2) +
                        Math.pow(currentBall.getyPos() - peg.getyPos(), 2));
                if (distance < 10) {
                    double angle = Math.atan2(currentBall.getyPos() - peg.getyPos(),
                            currentBall.getxPos() - peg.getxPos());
                    double speed = Math.sqrt(Math.pow(currentBall.getXvel(), 2) +
                            Math.pow(currentBall.getYvel(), 2));

                    // Add a small random variation to the speed to prevent stuck behavior
                    double randomVariation = (Math.random() * 2 - 1) * 0.5; // Random value between -0.5 and 0.5
                    speed += randomVariation;

                    currentBall.setXvel((int) (speed * Math.cos(angle)));
                    currentBall.setYvel((int) (speed * Math.sin(angle)));

                    // Play sound when ball hits a peg
                    playSound("peg_hit");
                    break;
                }
            }

            // Check if ball reaches the bottom
            if (currentBall.getyPos() >= 760) {
                for (int k = 0; k < 800; k += 40) {
                    if (currentBall.getxPos() >= k && currentBall.getxPos() < k + 40) {
                        int center = 400;
                        int distanceFromCenter = Math.abs(k - center);
                        int modifier = (400 - distanceFromCenter) / 100;
                        score += modifier;

                        // Play sound when scoring
                        playSound("score_zone");

                        b.remove(i);
                        i--; // Adjust index after removal
                        break;
                    }
                }
            }

            // Boundary conditions
            if (currentBall.getxPos() < 0 || currentBall.getxPos() > 800) {
                currentBall.setXvel(-currentBall.getXvel());
            }
        }
    }
    
    // Function to spawn a batch of balls near the selection oval
    public void spawner() {
        painter = true; // Enable ball rendering

        // Spawn 10 balls with slight variations around the selection oval
        for (int i = 0; i < 100; i++) {
            int randomOffset = (int) (Math.random() * 21) - 10; // Random offset between -10 and +10
            int spawnX = mouseX + randomOffset; // X-position relative to the selection oval
            int randomR = (int) (Math.random() * 255); // Random red color
            int randomG = (int) (Math.random() * 255); // Random green color
            int randomB = (int) (Math.random() * 255); // Random blue color

            // Add a new ball at the calculated position with random colors
            b.add(new ball(spawnX, 10, randomR, randomG, randomB));
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        isSpawning = true; // Enable spawning behavior
        mouseX = e.getX(); // Update the selection oval's X-position
        spawner(); // Trigger the spawner to drop a batch of balls
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        if (!isClicked) {
            mouseX = e.getX();
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
