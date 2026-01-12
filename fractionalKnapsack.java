class Solution {

    public class Item{
        int w,v;
        double ratio;

        Item(int v,int w){
            this.v=v;
            this.w=w;
            this.ratio = (double) (v/w);
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = wt.length;
        Item[] items = new Item[n];

        for(int i=0;i<n;i++){
            items[i] = new Item(val[i],wt[i]);
        }

        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));

        double total = 0.0;

        for(Item item :items){
            if(cap == 0) break;
            if(item.w <= cap){
                cap-=item.w;
                total+=item.v;
            } else {
                total+=item.ratio*cap;
                cap = 0;
            }
        }
        return Math.round(total*1e6)/1e6;
    }
}
