class Solution {
    public int[] twoSum(int[] nums, int target) {
	    	if(nums == null)
	    		return null;
                HashMap<Integer,Integer> list=new HashMap();
                for(int i=0;i<nums.length;i++){
                    list.put(nums[i],i);
                }
                for(int j=0;j<nums.length;j++){
                    int val=nums[j];
                    int diff=target-val;
                    if(list.containsKey(diff)){
                        int index=list.get(diff);
                        if(index==j) continue;
                        return new int[]{j,index};
                    }
                }
                return new int[]{};
               
	    }      
    }