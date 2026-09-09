class Solution {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList();

        String[] names = path.split("/");

        for (String name : names) {
            if (name.isEmpty() || name.equals(".") ) {
                continue;
            }

            if (name.equals("..")) {
                if (!result.isEmpty()){ 
                    result.remove(result.size() - 1);
                }
            } else {
                result.add(name);
            }
        }

        return "/"+String.join("/",result);
    }
}