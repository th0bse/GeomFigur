package com.th0bse.geomfigur;

import com.th0bse.geomfigur.model.*;
import com.th0bse.geomfigur.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, JPanel> panels = new HashMap<>();
    private static final Map<String, JTextField> fields = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = createFrame();
        frame.setVisible(true);
        // Set default selection
        handleComboBoxSelection(Shape.CIRCLE);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("GeomFigur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JComboBox<Shape> comboBox = createComboBox();
        frame.add(comboBox);

        for (String label : new String[]{"Radius", "Height", "Width", "Depth", "Side length"}) {
            JPanel panel = createInputPanel(label);
            frame.add(panel);
            panels.put(label, panel);
        }

        JSeparator separator = createSeparator();
        frame.add(separator);

        for (String label : new String[]{"Area", "Volume", "Surface area"}) {
            JPanel panel = createResultPanel(label);
            frame.add(panel);
            panels.put(label, panel);
        }

        JButton button = createButton(comboBox);
        frame.add(button);

        frame.pack();
        return frame;
    }

    private static JComboBox<Shape> createComboBox() {
        JComboBox<Shape> comboBox = new JComboBox<>(Shape.values());
        comboBox.addItemListener(itemEvent -> handleComboBoxSelection(itemEvent.getItem()));
        return comboBox;
    }

    private static JPanel createInputPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText + ": ");
        JTextField textField = new JTextField(20);
        addNumberKeyListener(textField);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.add(label);
        panel.add(textField);
        fields.put(labelText, textField);
        return panel;
    }

    private static JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        return separator;
    }

    private static JPanel createResultPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText + ": ");
        JTextField textField = new JTextField(20);
        textField.setEditable(false);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.add(label);
        panel.add(textField);
        fields.put(labelText, textField);
        return panel;
    }

    private static JButton createButton(JComboBox<Shape> comboBox) {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> {
            handleButtonClick((Shape) comboBox.getSelectedItem());
        });
        return button;
    }

    private static void addNumberKeyListener(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
                    e.consume();
                }
            }
        });
    }

    private static void handleComboBoxSelection(Object selectedItem) {
        panels.get("Radius").setVisible(selectedItem.equals(Shape.CIRCLE) || selectedItem.equals(Shape.BALL));
        panels.get("Height").setVisible(selectedItem.equals(Shape.RECTANGLE) || selectedItem.equals(Shape.CUBOID) || selectedItem.equals(Shape.CUBE));
        panels.get("Width").setVisible(selectedItem.equals(Shape.RECTANGLE) || selectedItem.equals(Shape.CUBOID));
        panels.get("Depth").setVisible(selectedItem.equals(Shape.CUBOID));
        panels.get("Side length").setVisible(selectedItem.equals(Shape.SQUARE) || selectedItem.equals(Shape.CUBE));
        panels.get("Area").setVisible(selectedItem.equals(Shape.CIRCLE) || selectedItem.equals(Shape.RECTANGLE) || selectedItem.equals(Shape.SQUARE));
        panels.get("Volume").setVisible(selectedItem.equals(Shape.BALL) || selectedItem.equals(Shape.CUBE) || selectedItem.equals(Shape.CUBOID));
        panels.get("Surface area").setVisible(selectedItem.equals(Shape.BALL) || selectedItem.equals(Shape.CUBE) || selectedItem.equals(Shape.CUBOID));
        fields.values().forEach(field -> field.setText(""));
    }

    private static void handleButtonClick(Shape selectedShape) {
        try {
            switch ((Shape) selectedShape) {
                case CIRCLE -> {
                    double radius = Double.parseDouble(fields.get("Radius").getText());
                    Circle circle = new Circle("Circle", radius);
                    fields.get("Area").setText(String.valueOf(circle.getArea()));
                }
                case RECTANGLE -> {
                    double height = Double.parseDouble(fields.get("Height").getText());
                    double width = Double.parseDouble(fields.get("Width").getText());
                    Rectangle rectangle = new Rectangle("Rectangle", width, height);
                    fields.get("Area").setText(String.valueOf(rectangle.getArea()));
                }
                case SQUARE -> {
                    double sideLength = Double.parseDouble(fields.get("Side length").getText());
                    Square square = new Square("Square", sideLength);
                    fields.get("Area").setText(String.valueOf(square.getArea()));
                }
                case BALL -> {
                    double radius = Double.parseDouble(fields.get("Radius").getText());
                    Ball ball = new Ball("Ball", radius);
                    fields.get("Volume").setText(String.valueOf(ball.getVolume()));
                    fields.get("Surface area").setText(String.valueOf(ball.getSurfaceArea()));
                }
                case CUBE -> {
                    double sideLength = Double.parseDouble(fields.get("Side length").getText());
                    Cube cube = new Cube("Cube", sideLength);
                    fields.get("Volume").setText(String.valueOf(cube.getVolume()));
                    fields.get("Surface area").setText(String.valueOf(cube.getSurfaceArea()));
                }
                case CUBOID -> {
                    double height = Double.parseDouble(fields.get("Height").getText());
                    double width = Double.parseDouble(fields.get("Width").getText());
                    double depth = Double.parseDouble(fields.get("Depth").getText());
                    Cuboid cuboid = new Cuboid("Cuboid", width, height, depth);
                    fields.get("Volume").setText(String.valueOf(cuboid.getVolume()));
                    fields.get("Surface area").setText(String.valueOf(cuboid.getSurfaceArea()));
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}