class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(part);
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder canonical = new StringBuilder();
        for (String dir : stack) {
            canonical.append('/').append(dir);
        }
        return canonical.toString();
    }
}