package threads.exercise2_threadSynchronization.scenario3;

import java.util.List;
import java.util.concurrent.RecursiveTask;

class Advertiser {
    private AdSlot prefferedBid;

    public boolean bid(AdSlot adSlot) {
        if (adSlot.getBidder() == null) {
            adSlot.setBidder(this);
            return true;
        }
        return false;
    }

    public AdSlot getPrefferedBid() {
        return prefferedBid;
    }
}

class AdSlot {
    private Advertiser bidder;

    public Advertiser getBidder() {
        return bidder;
    }
    public void setBidder(Advertiser bidder) {
        this.bidder = bidder;
    }
}

public class RealTimeBiddingSystem {
    private List<AdSlot> adSlots;

    public void placeBid(Advertiser advertiser, AdSlot adSlot) {
        advertiser.bid(adSlot);
    }

    public Advertiser getWinner(AdSlot adSlot) {
        return adSlot.getBidder();
    }

    public void startBidding(Advertiser advertiser, List<AdSlot> adSlots) {
        for (AdSlot adSlot : adSlots) {
            advertiser.bid(adSlot);
        }
    }

    public int getTotalAdSlotsWon() {
        int count = 0;
        for (AdSlot adSlot : adSlots) {
            if (adSlot.getBidder() != null) {
                count++;
            }
        }

        return count;
    }

    public void startBidding(List<Advertiser> advertisers, List<AdSlot> adSlots) {
        
    }
}

class BiddingRecursiveTask extends RecursiveTask<Boolean> {
    private List<Advertiser> advertisers;
    private List<AdSlot> adSlots;

    public BiddingRecursiveTask(List<Advertiser> advertisers, List<AdSlot> adSlots) {
        this.advertisers = advertisers;
        this.adSlots = adSlots;
    }

    @Override
    protected Boolean compute() {
        for (Advertiser advertiser : advertisers) {
            if (adSlots.contains(advertiser.getPrefferedBid())) {
                advertiser.bid(advertiser.getPrefferedBid());
                return true;
            }
        }

        return false;
    }
}
