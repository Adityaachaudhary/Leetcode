class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[0]+a[1])-(b[0]+b[1]));
        if(nums1.length==0 || nums2.length==0 || k==0){
            return res;
        }
        for(int i=0;i<nums1.length && i<k ;i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }
        while(k>0 && !pq.isEmpty()){
            int curr[]=pq.poll();
            int e1=curr[0];
            int e2=curr[1];
            if(curr[2]+1<nums2.length){
                pq.offer(new int[]{e1,nums2[curr[2]+1],curr[2]+1});
            }
            List<Integer> temp=new ArrayList<>();
            temp.add(e1);
            temp.add(e2);
            res.add(temp);
            k--;
        }
        return res;

    }
}