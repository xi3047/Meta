package bdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L207_CourseSchedule {
    /**
     * 1, 0
      0 -> 1
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Status> statusMap = new HashMap<>();
        for (int[] course : prerequisites) {
            graph.computeIfAbsent(course[0], k -> new ArrayList<>())
                    .add(course[1]);
        }
        for (int key : graph.keySet()) {
            if (containsCycle(graph, key, statusMap)) return false;
        }
        return true;
    }

    private boolean containsCycle(Map<Integer, List<Integer>> graph, int cur, Map<Integer, Status> statusMap) {
        Status status = statusMap.get(cur);
        if (status == Status.Processing) {
            return true;
        }
        if (status == Status.Done) {
            return false;
        }
        statusMap.put(cur, Status.Processing);
        if (graph.get(cur) != null) {
            for (int next : graph.get(cur)) {
                if (containsCycle(graph, next, statusMap)) return true;
            }
        }
        statusMap.put(cur, Status.Done);
        return false;
    }

    enum Status {
        Initial, Processing, Done;
    }
}
