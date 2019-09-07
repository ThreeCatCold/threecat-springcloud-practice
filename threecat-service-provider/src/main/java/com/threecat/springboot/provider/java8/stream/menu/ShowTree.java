package com.threecat.springboot.provider.java8.stream.menu;

import java.util.*;

public class ShowTree
{

	public static void main(String[] args)
	{
		Node rootNode = new Node(0, -1, "root");
		List<Node> nodes = new ArrayList<>(Arrays.asList(
				new Node[]{rootNode,
						new Node(1, 0,  "水泳部"),
				new Node(2, 1,  "水泳部2"),
						new Node(3, 2,  "水泳部3"),
						new Node(4, 2,  "水泳部4"),
						new Node(5, 3,  "水泳部5"),
						new Node(6, 0,  "愤青部"),
						new Node(7, 6,  "愤青部1"),
						new Node(8, 6,  "愤青部2"),
						new Node(9, 8,  "愤青部3")
				}
		));


		buildTreeNode(rootNode, nodes);
		showTree(rootNode, 0);
	}

	private static void buildTreeNode(Node startNode, List<Node> nodes)
	{
		if (nodes.isEmpty())
		{
			return;
		}
		List<Node> nextNodes = new ArrayList<>();
		int pid = startNode.getDeptId();
		for (Node node: nodes)
		{
			if (node.getParentId() == pid)
			{
				nextNodes.add(node);
			}
		}
		startNode.setNextNodes(nextNodes);
		nodes.removeAll(nextNodes);
		for (Node node : nextNodes)
		{
			buildTreeNode(node, nodes);
		}
	}

	private static void showTree(Node rootNode, int count)
	{
		System.out.println(getTabStr(count) + rootNode.getName());
		if(!rootNode.getNextNodes().isEmpty())
		{
			count++;
			for (Node node : rootNode.getNextNodes())
			{
				showTree(node, count);
			}
		}
	}

	private static String getTabStr(int count)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count;i++)
		{
			sb.append("  ");
		}
		return sb.toString();
	}


}
