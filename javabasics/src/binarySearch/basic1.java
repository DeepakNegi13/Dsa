package binarySearch;

public class basic1 {
	public static int lowerBound(int[] arr, int x) {
		int st = 0;
		int end = arr.length - 1;
		int ans = arr.length;
		if (arr[arr.length - 1] < x) return arr.length;
		while (end >= st) {
			int mid = (st + end) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		return ans;
	}

	public static int upperBound(int[] arr, int x) {
		int st = 0;
		int end = arr.length - 1;
		int ans = arr.length;
		if (arr[arr.length - 1] < x) return arr.length;
		while (end >= st) {
			int mid = (st + end) / 2;
			if (arr[mid] > x) {
				ans = mid;
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		return ans;

	}

	public static int[] getFloorAndCeil(int[] nums, int x) {

		int[] ans = new int[2];
		if (nums[nums.length - 1] < x) {
			int floor = nums[nums.length - 1];
			int ceil = -1;
			ans[0] = floor;
			ans[1] = ceil;
		} else if (nums[0] > x) {
			int floor = -1;
			int ceil = nums[0];
			ans[0] = floor;
			ans[1] = ceil;
		} else {
			int floor = nums[upperBound(nums, x) - 1];
			int ceil = nums[lowerBound(nums, x)];
			ans[0] = floor;
			ans[1] = ceil;
		}

		return ans;


	}

	
	public static void main(String[] args) {
		int[] arr = {1, 12, 23, 34, 45, 56, 67, 78, 89, 90, 99, 100};
		int n = arr.length;
		int target = 111;
		//System.out.println(getFloorAndCeil(arr, target)[0] + " " + getFloorAndCeil(arr, target)[1]);

		int ans = -1;
		int i = 0, j = n - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] > target) {
				j = mid - 1;
			} else if (arr[mid] < target) {
				i = mid + 1;
			} else if (arr[mid] == target) {
				ans = mid;
				break;
			}
		}
		//if (ans==-1){
		//  System.out.println("does not exist");
		//}else {
		//  System.out.println(ans);
		//}


//        boolean flag = false
//        while(n>0){
//            if (arr[(n+1)/2-1]==target){
//                flag = true;
//                break;
//            }else if (arr[(n+1)/2-1]>target){
//                n = (n+1)/2;
//            }else if (arr[(n+1)/2]<target) {
//                n = (3*n+1)/4;
//            }
//        }
//        System.out.println(n);
	}


}
