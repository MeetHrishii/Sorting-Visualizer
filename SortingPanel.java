import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingPanel extends JPanel {

    private int[] array;
    private int lineWidth;
    private int[] comparedIndices;

    public SortingPanel(int[] array, int lineWidth) {
        this.array = array;
        this.lineWidth = lineWidth;
        this.comparedIndices = new int[]{-1, -1}; // Initialize with invalid indices
        setPreferredSize(new Dimension(array.length * lineWidth, Arrays.stream(array).max().getAsInt()));
    }

    public void setComparedIndices(int[] comparedIndices) {
        this.comparedIndices = comparedIndices;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int x = i * lineWidth;
            int y = getHeight() - array[i];
            int height = array[i];

            if (i == comparedIndices[0] || i == comparedIndices[1]) {
                g.setColor(Color.RED);  // Highlight in red
            } else {
                g.setColor(Color.BLACK);  // Default color
            }

            g.fillRect(x, y, lineWidth, height);
        }
    }
}
