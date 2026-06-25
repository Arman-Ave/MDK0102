public class TrafficLight {

    private String currentColor;
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private int colorIndex;

    private static int totalChanges = 0;

    public TrafficLight() {
        colorIndex = 0;
        currentColor = COLORS[0];
    }

    public void changeColor() {
        colorIndex = (colorIndex + 1) % COLORS.length;
        currentColor = COLORS[colorIndex];
        totalChanges++;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public boolean isRed() {
        return "RED".equals(currentColor);
    }

    public boolean isGreen() {
        return "GREEN".equals(currentColor);
    }

    public boolean isYellow() {
        return "YELLOW".equals(currentColor);
    }

    public static int getTotalChanges() {
        return totalChanges;
    }

    public static void resetTotalChanges() {
        totalChanges = 0;
    }
}