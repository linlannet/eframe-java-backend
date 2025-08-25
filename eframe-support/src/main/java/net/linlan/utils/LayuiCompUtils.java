/*
 * eframe-support - frame支撑模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.utils;

import java.util.LinkedList;
import java.util.List;

import net.linlan.utils.dto.LayuiTree;

/**
 * @author Linlan
 * Description layui控件工具类
 * CreateTime 2019/8/2
 */
public class LayuiCompUtils {

    /**
     * 构建菜单树：格式：
     * {id:"",name:"",children:[]}
     * @param layuiTreeList LayuiTree树列表
     * @param rootId    根节点ID
     * @return  树列表
     */
    public static List<LayuiTree> buildLayuiTree(List<LayuiTree> layuiTreeList, String rootId) {
        LinkedList<LayuiTree> result = new LinkedList<>();
        // parentId为null的根节点
        for (int i = 0; i < layuiTreeList.size(); i++) {
            if ((rootId == null && layuiTreeList.get(i).getParentId() == rootId)
                || layuiTreeList.get(i).getParentId().equals(rootId)) {
                result.add(layuiTreeList.get(i));
            }
        }
        if (result != null && result.size() > 0) {
            result = sortToTree(result, layuiTreeList);
        }
        return result;
    }

    /** 通过递归算法，对当前的全部菜单进行树状结构排序
     * @param parentLayuiTreeList    当前的根菜单列表
     * @param layuiTreeList       全部菜单列表
     * @return  树列表
     */
    private static LinkedList<LayuiTree> sortToTree(LinkedList<LayuiTree> parentLayuiTreeList,
                                                    List<LayuiTree> layuiTreeList) {
        LinkedList<LayuiTree> temp = new LinkedList<>();
        for (int i = 0; i < parentLayuiTreeList.size(); i++) {
            // 通过当前的parentId，查询出list内的全部第一级子节点
            temp = getChildren(parentLayuiTreeList.get(i).getId(), layuiTreeList);
            if (temp != null && temp.size() > 0) {
                parentLayuiTreeList.get(i).setChildren(sortToTree(temp, layuiTreeList));
            }
            continue;
        }
        return parentLayuiTreeList;
    }

    /** 通过parentId，从全部列表中取出当前的子节点
     * @param parentId  当前parentId
     * @param allList   全部菜单列表
     * @return  树列表
     */
    private static LinkedList<LayuiTree> getChildren(String parentId, List<LayuiTree> allList) {
        LinkedList<LayuiTree> temp = new LinkedList<>();
        for (int j = 0; j < allList.size(); j++) {
            String pid = allList.get(j).getParentId();
            if (pid != null && pid.equals(parentId)) {
                temp.add(allList.get(j));
            }
        }
        return temp;
    }
}
