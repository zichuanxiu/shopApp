package org.deepthought.tag;

import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {
	private String url;// 请求地址 index.action?

	private Page page;// 分页实体对象

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = this.pageContext.getOut();
		try {
			// 获取请求的参数
			ServletRequest request = (HttpServletRequest) this.pageContext
					.getRequest();
			// 获取所有的参数名
			Enumeration<String> params = request.getParameterNames();
			// 用户拼装请求的url地址
			StringBuffer requestUrl = new StringBuffer();
			requestUrl.append(url).append("?");
//			System.out.println("requestUrl"+requestUrl);
			// 获取参数值
			while (params.hasMoreElements()) {

				// 获取参数名
				String parameterName = params.nextElement();
				// 由于页码值需要做计算，因此不在此处拼接
				if (parameterName.equals("pageIndex")) {
					continue;
				}
//				System.out.println("参数名:" + parameterName);
				// 根据参数名获取参数值
				String parameterVal = request.getParameter(parameterName);
				requestUrl.append(parameterName).append("=")
						.append(parameterVal).append("&");
//				System.out.println("requestUrl"+requestUrl);

			}
			out.print("<div class='pagebottom' id='pager' style='clear:both;'>");
			// 拼装分页标签
			// 判断是否是第一页
			if (this.page.getPageIndex() == 1) {
				out.print("<h3>首&nbsp;&nbsp;页</h3><h3>上一页</h3>");
			} else {
//				System.out.println(requestUrl);
				out.print("<h3><a href='" + requestUrl.toString()
						+ "pageIndex=1'>首&nbsp;&nbsp;页</a></h3>");
				out.print("<h3><a href='" + requestUrl.toString()
						+ "pageIndex=" + (this.page.getPageIndex() - 1)
						+ "'>上一页</a></h3>");
//				System.out.println("requestUrl"+requestUrl.toString());
			}

			// 判断是否使尾页
			if (this.page.getPageIndex() == this.page.getTotalPage()) {
				out.print("<h3>下一页</h3><h3>尾&nbsp;&nbsp;页</h3>");
			} else {
//				System.out.println("requestUrl"+requestUrl.toString());
				out.print("<h3><a href='" + requestUrl.toString()
						+ "pageIndex=" + (this.page.getPageIndex() + 1)
						+ "'>下一页</a></h3>");
				out.print("<h3><a href='" + requestUrl.toString()
						+ "pageIndex=" + this.page.getTotalPage()
						+ "'>尾&nbsp;&nbsp;页</a></h3>");
//				System.out.println("00000000000000");
//				System.out.println("requestUrl"+requestUrl.toString());
//				System.out.println("00000000000000");
			}

			out.print("<h6>当前显示第&nbsp;<font style='color:red;'>"
					+ this.page.getPageIndex() + "</font>");
			out.print("/" + this.page.getTotalPage() + "&nbsp;页&nbsp;</h6>");
			out.print("</div>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.SKIP_BODY;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("url:" + url);
		this.url = url;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		System.out.println("page:" + page);
		this.page = page;
	}

}
