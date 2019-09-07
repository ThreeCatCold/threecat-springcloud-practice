package com.threecat.springboot.provider.java8.stream.menu;

import java.util.List;

public class Node
{
	private Integer deptId;
	private Integer parentId;
	private String name;
	private List<Node> nextNodes;

	public Node(Integer deptId, Integer parentId, String name)
	{
		this.deptId = deptId;
		this.parentId = parentId;
		this.name = name;
	}

	public Integer getDeptId()
	{
		return deptId;
	}

	public void setDeptId(Integer deptId)
	{
		this.deptId = deptId;
	}

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Node> getNextNodes()
	{
		return nextNodes;
	}

	public void setNextNodes(List<Node> nextNodes)
	{
		this.nextNodes = nextNodes;
	}
}


