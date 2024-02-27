import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class SortingVisualizer extends JFrame {

    private static final int ARRAY_SIZE = 100;
    private static final int LINE_WIDTH = 10;
    private static final int LINE_HEIGHT_MULTIPLIER = 10;
    private static final int ANIMATION_DELAY = 500;

    private int[] array;
    private SortingPanel sortingPanel;
    private Timer timer;
    private int currentIteration;

    public SortingVisualizer() {
        setTitle("Sorting Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        array = generateRandomArray(ARRAY_SIZE);
        sortingPanel = new SortingPanel(array, LINE_WIDTH);

        add(sortingPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        currentIteration = 0;
        timer = new Timer(ANIMATION_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIteration < array.length - 1) {
                    SortingAlgorithms.bubbleSort(array, currentIteration, sortingPanel);
                    sortingPanel.repaint();
                    currentIteration++;
                } else {
                    timer.stop();
                }
            }
        });

        timer.start();
    }

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * LINE_HEIGHT_MULTIPLIER) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortingVisualizer::new);
    }
}
