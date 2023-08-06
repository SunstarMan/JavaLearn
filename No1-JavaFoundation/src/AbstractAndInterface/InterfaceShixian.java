package AbstractAndInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Manman
 * @since 2023/4/11 10:59
 */
public class InterfaceShixian extends AbstractDemo {
//    AbstractDemo a = new AbstractDemo() {
//        @Override
//        public int getAge() {
//            return super.getAge();
//        }
//    };

//    @Override
//    public int getAge() {
//        return super.getAge() + 100;
//    }

    public void dfs(TreeNode root, String path, List<String> list) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                list.add(sb.toString());  // 把路径加入到答案中
            } else {
                sb.append("->");  // 当前节点不是叶子节点，继续递归遍历
                dfs(root.left, sb.toString(), list);
                dfs(root.right, sb.toString(), list);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        return list;
    }


}