import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list (directed graph)
        for (int[] e : prerequisites) {
            int course = e[0];
            int prereq = e[1];
            adj.get(prereq).add(course);  // prereq → course
        }

        // Compute indegree of each course
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Courses with indegree 0 can be taken first
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            count++;

            for (int next : adj.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return count == numCourses;  // If all courses processed → possible
    }
}
