package algorithms.exercise1_sorting.scenario2;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Post> posts;
    private int id;

    public User(String name) {
        this.name = name;
        posts = new ArrayList<>();
        id = name.hashCode();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // My take
    public void insertionSortPosts() {
        ArrayList<Post> alreadySorted = new ArrayList<>();
        alreadySorted.add(posts.get(0));

        for (int i = 1, j = 0; i < posts.size(); i++) {
            if (posts.get(i).getHowOld() > alreadySorted.get(j).getHowOld()) {
                alreadySorted.add(posts.get(i));
                posts.remove(i);
                j++;
            }
        }

        for (Post post : posts) {
            int i = 0;
            while (alreadySorted.get(i).getHowOld() < post.getHowOld()) {
                i++;
            }
            alreadySorted.add(i, post);
        }

        this.posts = alreadySorted;
    }

    // AI Generated (I don't understand just yet)
    public void correctInsertionSort() {
        for (int i = 0; i < posts.size(); i++) {
            Post key = posts.get(i);
            int j = i - 1;

            while (j >= 0 && posts.get(j).getHowOld() > key.getHowOld()) {
                posts.set(j + 1, posts.get(j));
            }
            posts.set(j + 1, key);
        }
    }

    // My take:
    // Get the minimum element
    // Set this element in index 0
    // increment the index to be ready for the next insertion
    // swap the minimum element with element at index
    public void selectionSort() {

        for (int j = 0; j < posts.size(); j++) {
            Post min = posts.get(j);
            int i = 0;
            int tracksmallIndex = 0;
            for (i = j; i < posts.size(); i++) {
                if (posts.get(i).getHowOld() < min.getHowOld()) {
                    min = posts.get(i);
                    tracksmallIndex = i;
                }
            }
            Post temp = posts.get(j);
            posts.set(j, min);
            posts.set(tracksmallIndex, temp);
        }
    }
    
    //My take
    // *check if the beginning index is greater than end index      // forgot about that one
    // check if the middle post is the searched for post
    // if yes, return
    // if no, ascertain in which half the post is
    // run binary search again with new indeces
    public Post binarySearchID(int howLongAgoWasItPosted, int start, int end) {

        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        if (posts.get(mid).getHowOld() == howLongAgoWasItPosted) {
            return posts.get(mid);
        }

        Post right = null;
        Post left = null;

        if (posts.get(mid).getHowOld() > howLongAgoWasItPosted)
            right = binarySearchID(howLongAgoWasItPosted, mid + 1, end);
        else
            left = binarySearchID(howLongAgoWasItPosted, start, mid - 1);

        if (right != null && right.getHowOld() == howLongAgoWasItPosted)
            return right;
        else if (left != null && left.getHowOld() == howLongAgoWasItPosted)
            return left;

        return null;
    }
}
