# SortingAlgorithms
Quick reference for sorting algorithms.

## 1. Bubble Sort
## 2. Insertion Sort
```
for i loop from 0 to end
	for j loop from i to 0
		if arr[j-1] > arr[j]
			swap(arr, j, j-1)
```
## 3. Selection Sort
```
for i = 0 -> end
	int min_index = i;
	for i =j -> end
		if (arr[min_index] > arr[j])
			min_index = j;
	if (min_index != i)
		swap(i, min_index)
```
## 4. Merge Sort
```
Divide until the subarrays are of size 1
Merge 2 subarrays until they are sorted

mergesort(arr, start, end) {
	if (end >= start) return;
	int mid = (start+end)/2;
	mergesort(arr, start, mid);
	mergesort(arr, mid+1, end);
	merge(arr, start, mid, end);
}

merge(arr, start, mid, end) {
	int temparr[] = new int[arr.length];
	copy arr to temparr;
	int i = start, j = mid+1;
	int track = start;
	while(i <= mid && j < end) {
		if (temparr[j] <= temparr[i]) {
			arr[track++] = temparr[j];
			j++;
		} else {
			arr[track++] = temparr[i];
			i++;
		}
	}
	while (i <= mid) {
		arr[track++] = temparr[i];
		i++;
	}
	while (j < end) {
		arr[track++] = temparr[j];
		j++;
	}
}

```
## 5. Quick Sort
```
pick a random (middle) pivot:
	left to pivot is subarray that is smaller than pivot
	right to subarray is larger than pivot
stop when subarrays of size 1 is reached in other words start >= end

quicksort(arr, start, end) {
	if (start >= end) return;
	int pivot = partition(arr, start, end);
	quicksort(arr, start, pivot-1);
	quicksort(arr, pivot+1; end);
}

int partition (arr, start, end) {
	swap(start, end);
	int i = start;

	for (j = 0 -> end) {
		if (arr[j] <= arr[end])
		swap(i,j)
		i++;
	}
	swap(i, end);
	return i;
}
```
## 6. Heap Sort
```
First construct heap: O(n)
Then keep on maintaining heap until the last element is reached: O(nlogn)
1. swap first element with last element and assume last element is in sorted position and reduce size of array by 1
2. call maxHeapify on the first element


i = middle -> 0 index

for (int i = len/2; i>=0; i--) {
	maxHeapify(arr, i)
}

maxHeapify(int[] arr, int i, int len) {
	int right = 2*i+1;
	int left = 2*i+2;

	int largest = 0;

	if (right < len && arr[right] > arr[i]) {
		largest = right;
	}
	else largest = i;

	if (left < len && arr[left] > arr[largest]) {
		largest = left;
	}

	if (largest != i) {
		swap(arr, i, largest);
		maxHeapify(arr, i);
	}
}

sort(int[] arr) {
	int len = arr.length;
	while (len >= 1) {
		swap(arr,0,len-1);
		length--;
		maxHeapify(arr,0,len);
	}
}
```
# TODO:
## 7. Counting Sort
## 8. Radix Sort