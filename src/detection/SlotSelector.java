package detection;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlotSelector {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        Mat image = Imgcodecs.imread("parking.jpg");

        if (image.empty()) {
            System.out.println("Image not found!");
            return;
        }

        System.out.println("Image width: " + image.cols());
        System.out.println("Image height: " + image.rows());

        // Raw slots (your input)
        List<Rect> slots = new ArrayList<>();
        slots.add(new Rect(10, 20, 60, 150));
        slots.add(new Rect(80, 20, 60, 150));
        slots.add(new Rect(150, 20, 60, 150));
        slots.add(new Rect(220, 20, 60, 150)); // ❌ invalid

        // ✅ ONLY VALID SLOTS
        List<Rect> validSlots = new ArrayList<>();

        for (Rect r : slots) {

            if (r.x < 0 || r.y < 0 ||
                r.x + r.width > image.cols() ||
                r.y + r.height > image.rows()) {

                System.out.println("Skipping invalid slot: " + r);
                continue;
            }

            // draw
            Imgproc.rectangle(
                    image,
                    r,
                    new Scalar(0, 255, 0),
                    2
            );

            // ✅ add only valid
            validSlots.add(r);
        }

        HighGui.imshow("Select Parking Slots", image);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();

        // ✅ SAVE ONLY VALID SLOTS
        try {
            FileWriter writer = new FileWriter("slots.txt");

            for (Rect r : validSlots) {
                writer.write(
                        r.x + "," +
                        r.y + "," +
                        r.width + "," +
                        r.height + "\n"
                );
            }

            writer.close();
            System.out.println("✅ Slots saved successfully to slots.txt");
            System.out.println("Total valid slots: " + validSlots.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}