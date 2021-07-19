package HomeWork8;

import javafx.scene.Parent;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static HomeWork8.Logic.*;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;
    private int winLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);

                }
                repaint();
            }
        });
    }

    void startNewGame(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.GRAY);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }                                                      //Рисуем сетку

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {                   //Рисуем крестики/нолики
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == DOT_X) {
                    drawX(g, i, j);
                }

                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }
            }
        }

        if (isFull()) {
            JOptionPane.showMessageDialog(this, "Ничья!", "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
            new GameWindow();
        }
        if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
            JOptionPane.showMessageDialog(this, "Вы победили!", "Игра окончена", JOptionPane.INFORMATION_MESSAGE);     //Вывод информации о победителе, не могу понять,
            new GameWindow();                                                                                                                     // почему последний символ не отрисовывется,
                                                                                                                                                 // а сразу выпадает сообщение
        }
        if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
            JOptionPane.showMessageDialog(this, "Компьютер победил. Сейчас их даже в шахматы не выиграть...", "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
            new GameWindow();
        }

    }

    private void drawX(Graphics g, int y, int x) {                      //Для рисования крестиков
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        g.drawLine(x * cellWidth + 5, y * cellHeight + 5,
                (x + 1) * cellWidth - 5, (y + 1) * cellHeight - 5);
        g.drawLine(x * cellWidth + 5, (y + 1) * cellHeight - 5, (x + 1) * cellWidth - 5, y * cellHeight + 5);   //+5/-5 для оступов от края клетки
    }

    private void drawO(Graphics g, int y, int x) {                      //Для рисования ноликов
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawOval(x * cellWidth + 5, y * cellHeight + 5, cellWidth - 10, cellHeight - 10);    //+5/-5 для оступов от края клетки
    }


}
