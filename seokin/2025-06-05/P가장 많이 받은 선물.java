import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] result = new int[friends.length];
		Map<String, Integer> giftToFriend = new HashMap<>();
		Map<String, Integer> giftNumber = new HashMap<>();
		for(String gift : gifts) {
			giftToFriend.put(gift, giftToFriend.getOrDefault(gift, 0)+1);
			String name1 = gift.split(" ")[0];
			String name2 = gift.split(" ")[1];
			giftNumber.put(name1, giftNumber.getOrDefault(name1, 0)+1);
			giftNumber.put(name2, giftNumber.getOrDefault(name2, 0)-1);
		}
		
		
		for(int i=0;i<friends.length;i++) {
			for(int j=0;j<friends.length;j++) {
				if(i==j) continue;
				int numA = giftToFriend.getOrDefault(friends[i]+" "+ friends[j],0);
				int numB = giftToFriend.getOrDefault(friends[j]+" "+ friends[i],0);
				
				if(numA > numB) {
					result[i] += 1;
				} else if(numA < numB) {
					result[j] += 1;
				} else {
					int giftNumberA = giftNumber.getOrDefault(friends[i], 0);
					int giftNumberB = giftNumber.getOrDefault(friends[j], 0);
					
					if(giftNumberA > giftNumberB) {
						result[i] += 1;
					} else if(giftNumberA < giftNumberB) {
						result[j] += 1;
					}
				}
			}
		}
		int answer = 0;
		for(int i=0;i<result.length;i++) {
			answer = Math.max(answer, result[i]);
		}
        return answer/2;
    }
}