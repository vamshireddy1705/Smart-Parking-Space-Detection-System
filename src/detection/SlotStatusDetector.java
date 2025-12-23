package detection;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class SlotStatusDetector {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        // Load image
        Mat image = Imgcodecs.imread("parking.jpg");
        if (image.empty()) {
            System.out.println("❌ Image not found!");
            return;
        }

        int imgW = image.cols();
        int imgH = image.rows();
        System.out.println("Image width : " + imgW);
        System.out.println("Image height: " + imgH);

        // Slots (SAFE values)
        List<Rect> slots = new ArrayList<>();
        slots.add(new Rect(10, 20, 60, 150));
        slots.add(new Rect(80, 20, 60, 150));
        slots.add(new Rect(150, 20, 60, 150));
        slots.add(new Rect(220, 20, 40, 150)); // width reduced (IMPORTANT)

        int emptyCount = 0;
        int filledCount = 0;

        // Process slots safely
        for (Rect slot : slots) {

            // 🔐 SAFETY CHECK (MOST IMPORTANT)
            if (slot.x < 0 || slot.y < 0 ||
                slot.x + slot.width > imgW ||
                slot.y + slot.height > imgH) {

                System.out.println("Skipping invalid slot: " + slot);
                continue;
            }

            // Extract ROI
            Mat roi = image.submat(slot);

            // Convert to gray
            Mat gray = new Mat();
            Imgproc.cvtColor(roi, gray, Imgproc.COLOR_BGR2GRAY);

            // Mean intensity
            Scalar mean = Core.mean(gray);

            boolean isEmpty = mean.val[0] > 140;

            Scalar color;
            String label;

            if (isEmpty) {
                color = new Scalar(0, 255, 0); // GREEN
                label = "EMPTY";
                emptyCount++;
            } else {
                color = new Scalar(0, 0, 255); // RED
                label = "FILLED";
                filledCount++;
            }

            // Draw rectangle
            Imgproc.rectangle(image, slot, color, 2);

            // Put label
            Imgproc.putText(
                    image,
                    label,
                    new Point(slot.x, slot.y - 5),
                    Imgproc.FONT_HERSHEY_SIMPLEX,
                    0.5,
                    color,
                    1
            );
        }

        // Show output
        HighGui.imshow("Smart Parking Detection", image);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();

        // Final console output
        System.out.println("✅ Detection completed successfully!");
        System.out.println("Total slots : " + slots.size());
        System.out.println("Empty slots : " + emptyCount);
        System.out.println("Filled slots: " + filledCount);
    }
}