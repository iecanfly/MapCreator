package org.apache.jsp.decorators;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class printSingleDefault_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html style=\"overflow: hidden\">\n");
      out.write("    <head>\n");
      out.write("        <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${block.block}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('-');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${block.number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://api.map.baidu.com/api?v=1.2\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js\"></script>\n");
      out.write("\t\t<link rel=\"stylesheet\" media=\"screen\" href=\"@routes.Assets.at(\"stylesheets/main.css\")\">\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/lib/jquery-1.8.2.min.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/lib/jquery-ui-1.8.18.min.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/classHelper.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/latlon.js'/>\"></script>\n");
      out.write("\t\t<!-- DO NOT CHANGE THE ORDER OF JS! map.js should be on top of other custom made js files -->\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/printMapOverall.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/printMap.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/printPage.js'/>\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"<c:url value='/scripts/dao/blockDAO.js'/>\"></script>\n");
      out.write("        <decorator:script/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <decorator:body/>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
