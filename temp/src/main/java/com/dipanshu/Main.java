package com.dipanshu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class Boid {
    static final double SIZE = 5;
    static final double MAX_SPEED = 2;
    static final double MAX_FORCE = 0.1;

    Point position;
    Point velocity;
    Point acceleration;

    public Boid(double x, double y) {
        position = new Point((int)x, (int)y);
        velocity = new Point(new Random().nextInt(3) - 1, new Random().nextInt(3) - 1);
        acceleration = new Point(0, 0);
    }

    public void update() {
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;

        // Limit speed
        double speed = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        if (speed > MAX_SPEED) {
            velocity.x = (int) ((velocity.x / speed) * MAX_SPEED);
            velocity.y = (int) ((velocity.y / speed) * MAX_SPEED);
        }

        position.x += velocity.x;
        position.y += velocity.y;
        acceleration.x = 0;
        acceleration.y = 0;
    }

    public void applyForce(Point force) {
        acceleration.x += force.x;
        acceleration.y += force.y;
    }

    public void flock(ArrayList<Boid> boids) {
        Point alignment = align(boids);
        Point cohesion = cohere(boids);
        Point separation = separate(boids);

        alignment.x *= 1.0;
        alignment.y *= 1.0;
        cohesion.x *= 1.0;
        cohesion.y *= 1.0;
        separation.x *= 1.5;
        separation.y *= 1.5;

        applyForce(alignment);
        applyForce(cohesion);
        applyForce(separation);
    }

    private Point align(ArrayList<Boid> boids) {
        Point steering = new Point(0, 0);
        double total = 0;
        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < 50) {
                steering.x += other.velocity.x;
                steering.y += other.velocity.y;
                total++;
            }
        }
        if (total > 0) {
            steering.x /= total;
            steering.y /= total;
            steering.x = steering.x - velocity.x;
            steering.y = steering.y - velocity.y;

            // Limit steering
            double speed = Math.sqrt(steering.x * steering.x + steering.y * steering.y);
            if (speed > MAX_FORCE) {
                steering.x =  (int) ((steering.x / speed) * MAX_FORCE);
                steering.y = (int) ((steering.y / speed) * MAX_FORCE);
            }
        }
        return steering;
    }

    private Point cohere(ArrayList<Boid> boids) {
        Point steering = new Point(0, 0);
        double total = 0;
        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < 50) {
                steering.x += other.position.x;
                steering.y += other.position.y;
                total++;
            }
        }
        if (total > 0) {
            steering.x /= total;
            steering.y /= total;
            steering.x = steering.x - position.x;
            steering.y = steering.y - position.y;

            // Limit steering
            double speed = Math.sqrt(steering.x * steering.x + steering.y * steering.y);
            if (speed > MAX_FORCE) {
                steering.x = (int) ((steering.x / speed) * MAX_FORCE);
                steering.y = (int) ((steering.y / speed) * MAX_FORCE);
            }
        }
        return steering;
    }

    private Point separate(ArrayList<Boid> boids) {
        Point steering = new Point(0, 0);
        double total = 0;
        for (Boid other : boids) {
            double distance = position.distance(other.position);
            if (other != this && distance < 25) {
                Point diff = new Point(position.x - other.position.x, position.y - other.position.y);
                diff.x /= distance; // Weight by distance
                diff.y /= distance;
                steering.x += diff.x;
                steering.y += diff.y;
                total++;
            }
        }
        if (total > 0) {
            steering.x /= total;
            steering.y /= total;

            // Limit steering
            double speed = Math.sqrt(steering.x * steering.x + steering.y * steering.y);
            if (speed > MAX_FORCE) {
                steering.x = (int) ((steering.x / speed) * MAX_FORCE);
                steering.y = (int) ((steering.y / speed) * MAX_FORCE);
            }
        }
        return steering;
    }
}

public class Main extends JPanel implements ActionListener {
    private ArrayList<Boid> boids;
    private Timer timer;

    public Main(double numBoids) {
        boids = new ArrayList<>();
        for (double i = 0; i < numBoids; i++) {
            boids.add(new Boid(new Random().nextDouble(800), new Random().nextDouble(600)));
        }
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Boid boid : boids) {
            g.fillOval(boid.position.x, boid.position.y, (int)Boid.SIZE, (int)Boid.SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Boid boid : boids) {
            boid.flock(boids);
            boid.update();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flock Simulation");
        Main Main = new Main(100);
        frame.add(Main);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
