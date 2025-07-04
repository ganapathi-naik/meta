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
