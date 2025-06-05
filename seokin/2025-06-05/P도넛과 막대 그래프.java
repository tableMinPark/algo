import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] result = new int[4];
        Map<Integer, Integer> inMap = new HashMap<>();
		Map<Integer, Integer> outMap = new HashMap<>();
		Set<Integer> nodes = new HashSet<>();
		for(int[] edge : edges) {
			inMap.put(edge[1], inMap.getOrDefault(edge[1], 0)+1);
			outMap.put(edge[0], outMap.getOrDefault(edge[0], 0)+1);
			nodes.add(edge[0]);
			nodes.add(edge[1]);
		}
		int randomNode=0;
		int graphCount=0;
		// 임의의 정점 찾기 들어오는건 0 나가는건 2이상
		for(int i : nodes) {
			if(inMap.getOrDefault(i,0)==0 && outMap.getOrDefault(i,0)>=2) {
				randomNode = i;
				graphCount = outMap.get(i);
			}
		}
		// 임의의 정점을 제외하고 간선을 다시 초기화
		inMap = new HashMap<>();
		outMap = new HashMap<>();
		
		for(int[] edge : edges) {
			if(edge[0]==randomNode) continue;
			inMap.put(edge[1], inMap.getOrDefault(edge[1], 0)+1);
			outMap.put(edge[0], outMap.getOrDefault(edge[0], 0)+1);
			nodes.add(edge[0]);
			nodes.add(edge[1]);
		}
        result[0] = randomNode;
		for(int i: nodes) {
			if(i==randomNode) continue;
			// 나가는게 0
			if(outMap.getOrDefault(i,0)==0) {
				result[2] += 1;
			}
			// 8자 그래프
			else if(inMap.getOrDefault(i,0)==2 && outMap.getOrDefault(i,0)==2) {
				result[3] += 1;
			}
		}
		result[1] = graphCount - result[2] - result[3];
        return result;
    }
}