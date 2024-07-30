- Enhanced task 1 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Implement a divide and conquer algorithm for image segmentation and feature extraction. Your goal is to divide the image into segments and extract features from each segment.
    - _Potential input_: An image. For example: `image = [[255, 255, 255], [0, 0, 0], [255, 255, 255]]`.
    - _Desired Output_: The segmented image and the extracted features. For example: `segments = [[1, 1, 1], [0, 0, 0], [1, 1, 1]], features = {'segment1': {'average_intensity': 255}, 'segment2': {'average_intensity': 0}}`.
    - _Coach Suggestions_: Start by dividing the image into segments using a divide and conquer algorithm. Then, for each segment, extract features such as the average intensity, the number of pixels, etc.
- Enhanced task 2 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Explore techniques for identifying regions of interest in large images using divide and conquer algorithms. Your goal is to efficiently find regions of interest in the image.
    - _Potential input_: A large image and a region of interest. For example: `image = [[255, 255, 255], [0, 0, 0], [255, 255, 255]], roi = [0, 0, 1, 1]`.
    - _Desired Output_: The region of interest. For example: `[[255, 255], [0, 0]]`.
    - _Coach Suggestions_: Use a divide and conquer algorithm to divide the image into smaller regions and identify the region of interest. You can use techniques such as binary search or quadtree decomposition.
- Enhanced task 3 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Develop tools for stitching together multiple images using divide and conquer principles. Your goal is to create a panorama from multiple images.
    - _Potential input_: A list of images. For example: `images = [[[255, 255, 255], [0, 0, 0]], [[0, 0, 0], [255, 255, 255]]]`.
    - _Desired Output_: The stitched image. For example: `[[255, 255, 255, 0, 0, 0], [0, 0, 0, 255, 255, 255]]`.
    - _Coach Suggestions_: Use a divide and conquer algorithm to stitch the images together. Start by dividing the list of images into two halves, stitch each half together, and then stitch the two halves together. You might need to use image processing techniques to align the images correctly.