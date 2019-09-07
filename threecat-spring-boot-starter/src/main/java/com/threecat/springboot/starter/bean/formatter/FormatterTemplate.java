package com.threecat.springboot.starter.bean.formatter;

public class FormatterTemplate
{
	private Formatter formatter;

	public FormatterTemplate(Formatter formatter)
	{
		this.formatter = formatter;
	}

	public <T> String doFormat(T t)
	{
		return "FormatterTemplate -> " + formatter.format(t);
	}
}
