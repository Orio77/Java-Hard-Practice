package dataStructures.exercise2_hashing.scenario3;

public class Data {
    private String contents;
    private int dataID;
    private boolean recentlyUsed = false;

    public Data(String contents) {
        this.contents = contents;
        this.dataID = contents.hashCode();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public boolean isRecentlyUsed() {
        return recentlyUsed;
    }

    public void setRecentlyUsed(boolean recentlyUsed) {
        this.recentlyUsed = recentlyUsed;
    }
}
