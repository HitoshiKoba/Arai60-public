class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();


        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        Set<String> visited = new HashSet<>();

        minHeap.offer(new int[]{0, 0, nums1[0] + nums2[0]});
        visited.add("0, 0");

        //repeat while we find k-pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[0];
            int j = current[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (i + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                minHeap.offer(new int[]{i + 1, j, nums1[i + 1] + nums2[j]});
                visited.add((i + 1) + "," + j);
            }

            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                minHeap.offer(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
                visited.add(i + "," + (j + 1));
            }
        }
        return result;
    }
}
