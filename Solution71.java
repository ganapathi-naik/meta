class Solution71 {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String folder : folders) {
            if (folder.equals(".") || folder.equals("")) {
                continue;
            } else if (folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(folder);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        String prefix = "";
        for (String str : stack) {
            sb.append(prefix).append(str);
            prefix = "/";
        }
        return sb.toString();
    }
}
