// Introduction to algorithms, 9-1-1
// Time complexity: n+log n +1

public class Solution {
	// find [smallest, 2nd smallest] number in an array
	public int secondSmallest(int[] nums) {
		int[] res = findLastAndSecondSmallest(nums, 0, nums.length-1);
		return res[1];
	}
	
	private int[] findLastAndSecondSmallest(int[] nums, int lo, int hi) {
		if(lo == hi)
			return new int[] {nums[lo],0};	// 0 is dummy
		if(hi == lo+1) {
			if(nums[lo]<nums[hi])
				return new int[] {nums[lo], nums[hi]};
			else
				return new int[] {nums[hi], nums[lo]};
		}
		// if(hi>lo+1)
		int mid = lo +(hi-lo)/2;
		
		// System.out.println("Debug 1: partition-mid= "+mid);
		partition(nums, lo, mid, hi);
		
		int[] smaller = findLastAndSecondSmallest(nums, lo, mid);	// smaller has size n/2 or n/2+1
		int[] larger = findLastAndSecondSmallest(nums, mid+1, hi);
		return new int[] {smaller[0], Math.min(smaller[1],larger[0])};
	}
	
	private void partition(int[] nums, int lo, int mid, int hi) {
		int i=0, j=mid+1;
		while(i<=mid && j<=hi) {
			if(nums[i]>nums[j])
				swap(nums, i, j);
			i++;
			j++;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
