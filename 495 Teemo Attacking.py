#  https://leetcode.com/problems/teemo-attacking/


#  Beats 100%
class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        if len(timeSeries) < 1: return 0
        if len(timeSeries) == 1: return duration
        
        time, total_duration = duration + timeSeries[0], duration
        for i in range(1, len(timeSeries)):
            if timeSeries[i] < time: total_duration += timeSeries[i] - timeSeries[i-1]
            else: total_duration += duration
            time = timeSeries[i] + duration
            
        return total_duration


# class Solution:
#     def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
#         if len(timeSeries) < 1: return 0
#         if len(timeSeries) == 1: return duration
        
#         time = 0
#         for i in range(len(timeSeries) - 1):
#             time += min(timeSeries[i+1] - timeSeries[i], duration)
            
#         return time + duration