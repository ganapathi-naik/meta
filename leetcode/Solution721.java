class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToNameMapping = new HashMap<>();
        Map<String, Set<String>> emailToAccountsMapping = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String alternateEmail = account.get(i);
                emailToAccountsMapping.putIfAbsent(email, new HashSet<>());
                emailToAccountsMapping.get(email).add(alternateEmail);

                emailToAccountsMapping.putIfAbsent(alternateEmail, new HashSet<>());
                emailToAccountsMapping.get(alternateEmail).add(email);

                emailToNameMapping.put(alternateEmail, name);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String key : emailToAccountsMapping.keySet()) {
            if (visited.contains(key)) {
                continue;
            }
            Stack<String> stack = new Stack<>();
            stack.push(key);
            visited.add(key);
            List<String> localRes = new ArrayList<>();
            while (!stack.isEmpty()) {
                String email = stack.pop();
                localRes.add(email);
                for (String alertnateEmail : emailToAccountsMapping.get(email)) {
                    if (!visited.contains(alertnateEmail)) {
                        stack.push(alertnateEmail);
                        visited.add(alertnateEmail);
                    }
                }
            }
            Collections.sort(localRes);
            localRes.add(0, emailToNameMapping.get(key));

            res.add(localRes);
        }
        return res;
    }
}


class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        UnionFind uf = new UnionFind();

        // Step 1: For each account, union all emails
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.union(firstEmail, email);
                emailToName.put(email, name);
            }
        }

        // Step 2: Group emails by their root parent
        Map<String, TreeSet<String>> parentToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String parent = uf.find(email);
            parentToEmails.computeIfAbsent(parent, x -> new TreeSet<>()).add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : parentToEmails.entrySet()) {
            List<String> emails = new ArrayList<>(entry.getValue());
            emails.add(0, emailToName.get(entry.getKey())); // Add name at the front
            result.add(emails);
        }

        return result;
    }

    // Union-Find class
    class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public String find(String email) {
            parent.putIfAbsent(email, email);
            if (!email.equals(parent.get(email))) {
                parent.put(email, find(parent.get(email)));
            }
            return parent.get(email);
        }

        public void union(String e1, String e2) {
            String p1 = find(e1);
            String p2 = find(e2);
            if (!p1.equals(p2)) {
                parent.put(p2, p1);
            }
        }
    }
}

/**
 Time & Space Complexity
Time: O(N·logN), where N is total number of emails. Sorting and union-find both are efficient.

Space: O(N), for maps and DSU structure.
 */


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        UnionFind uf = new UnionFind();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.union(firstEmail, email); // Union emails
                emailToName.put(email, name);
            }
        }

        // Group emails by their root parent
        Map<String, TreeSet<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            rootToEmails.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        // Build the result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : rootToEmails.entrySet()) {
            List<String> group = new ArrayList<>();
            group.add(emailToName.get(entry.getKey()));
            group.addAll(entry.getValue());
            result.add(group);
        }

        return result;
    }

    class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        public String find(String x) {
            parent.putIfAbsent(x, x);
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x))); // Path compression
            }
            return parent.get(x);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (rootX.equals(rootY)) return;

            // Union by rank
            int rankX = rank.getOrDefault(rootX, 0);
            int rankY = rank.getOrDefault(rootY, 0);

            if (rankX < rankY) {
                parent.put(rootX, rootY);
            } else if (rankX > rankY) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rankX + 1);
            }
        }
    }
}

/**
 * Using path compression and union by rank (or size) in your Union-Find (DSU) implementation significantly improves performance, especially for large datasets.

These two optimizations together make each DSU operation nearly constant time, specifically O(α(N)), where α(N) is the inverse Ackermann function (which grows extremely slowly — practically ≤ 4 for all realistic N).
 */
