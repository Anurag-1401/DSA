class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        num = 0

        for i in range(len(nums)):
            num = target - nums[i]
            if num in map: return [i,map[num]]
            map[nums[i]] = i

        return [-1,-1]