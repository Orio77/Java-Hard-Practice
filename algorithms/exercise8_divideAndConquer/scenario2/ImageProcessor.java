package algorithms.exercise8_divideAndConquer.scenario2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageProcessor {

    public List<int[][]> segmentAndExtract(int[][] image) {
        List<int[][]> segments = new ArrayList<>();
        segment(image, segments);
        return segments;
        /*
        Method to implement a divide and conquer algorithm for image segmentation and feature extraction.
        
        Steps:
        1. Divide the image into four equal parts.
        2. For each part, check if all pixels have the same intensity. If they do, this part is a segment.
        3. If they don't, divide this part again into four equal parts and repeat the process.
        4. Once all parts are segmented, calculate the average intensity for each segment and store it in the features dictionary.
        */
    }

    private void segment(int[][] image, List<int[][]> segments) {
        int[][] segment1 = new int[image.length / 2][image[0].length / 2];
        int[][] segment2 = new int[image.length / 2][image[0].length / 2];
        int[][] segment3 = new int[image.length / 2][image[0].length / 2];
        int[][] segment4 = new int[image.length / 2][image[0].length / 2];

        // fill segment 1
        for (int i = 0; i < image.length / 2; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                segment1[i][j] = image[i][j];
            }
        }

        // fill segment 2
        for (int i = 0; i < image.length / 2; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                segment2[i][j - image[0].length / 2] = image[i][j];
            }
        }

        // fill segment 3
        for (int i = 0; i < image.length / 2; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                segment3[i - image.length / 2][j] = image[i][j];
            }
        }

        // fill segment 4
        for (int i = 0; i < image.length / 2; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                segment4[i - image.length / 2][j - image[0].length / 2] = image[i][j];
            }
        }

        // check segment 1 if pixel values match
        int startValue = segment1[0][0];
        boolean segmented = false;
        for (int i = 0; i < segment1.length; i++) {
            for (int j = 0; j < segment1[0].length; j++) {
                if (segment1[i][j] != startValue) {
                    segmented = true;
                    segment(segment1, segments);
                }
            }
        }
        if (!segmented)
            segments.add(segment1);


        // check segment 2 if pixel values match
        startValue = segment2[0][0];
        segmented = false;
        for (int i = 0; i < segment2.length; i++) {
            for (int j = 0; j < segment2[0].length; j++) {
                if (segment2[i][j] != startValue) {
                    segmented = true;
                    segment(segment2, segments);
                }
            }
        }
        if (!segmented)
            segments.add(segment2);

        // check segment 3 if pixel values match
        startValue = segment3[0][0];
        segmented = false;
        for (int i = 0; i < segment3.length; i++) {
            for (int j = 0; j < segment3[0].length; j++) {
                if (segment3[i][j] != startValue) {
                    segmented = true;
                    segment(segment3, segments);
                }
            }
        }
        if (!segmented)
            segments.add(segment3);

        // check segment 4 if pixel values match
        startValue = segment4[0][0];
        segmented = false;
        for (int i = 0; i < segment4.length; i++) {
            for (int j = 0; j < segment4[0].length; j++) {
                if (segment4[i][j] != startValue) {
                    segmented = true;
                    segment(segment4, segments);
                }
            }
        }
        if (!segmented)
            segments.add(segment4);
    }

    public int[][] identifyRoi(int[][] image, int[] roi) { // roi format: 4 integers ([start_row, start_col, end_row, end_col])

        int[][] areaOfInterest = new int[roi[2] - roi[0] + 1][roi[3] - roi[1] + 1];

        for (int i = 0; i < areaOfInterest.length; i++) {
            for (int j = 0; j < areaOfInterest[0].length; j++) {
                areaOfInterest[i][j] = image[roi[0] + i][roi[1] + j];
            }
        }

        return areaOfInterest;
        /*
        Method to implement a divide and conquer algorithm to efficiently find a specified region of interest in a large image.
        
        Steps:
        1. Divide the image into four equal parts.
        2. Determine which part(s) the region of interest falls into.
        3. If the region of interest falls entirely within one part, discard the other parts and repeat the process with the selected part.
        4. If the region of interest falls into more than one part, repeat the process for each of those parts.
        5. Continue this process until you have isolated the region of interest.
        */
    }

    public int[][] stitchImages(int[][][] images) {
        /*
        Method to implement a divide and conquer algorithm to stitch together multiple images into a single image.
        
        Steps:
        1. Divide the list of images into two halves.
        2. Stitch together the images in the first half into a single image.
        3. Stitch together the images in the second half into a single image.
        4. Stitch together the two resulting images from steps 2 and 3 into a final image.
        */

        int mid = images.length / 2;
        int[][][] firstHalf = Arrays.copyOfRange(images, 0, mid);
        int[][][] secondHalf = Arrays.copyOfRange(images, mid, images.length);

        int[][] firstImage = stitchImages(firstHalf);
        int[][] secondImage = stitchImages(secondHalf);
        int[][] finalImage = new int[firstImage.length + secondImage.length][];
        System.arraycopy(firstImage, 0, finalImage, 0, firstImage.length);
        System.arraycopy(secondImage, 0, finalImage, firstImage.length, secondImage.length);

        return finalImage;
    }
}