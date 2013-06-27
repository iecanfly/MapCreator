package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class blockMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/pages/sidecontrol.jsp");
    _jspx_dependants.add("/common/dialog.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_message_key_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_set_var.release();
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>");
      if (_jspx_meth_fmt_message_1(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("    <meta name=\"menu\" content=\"MapMenu\"/>\n");
      out.write("</head>\n");
      out.write("<body class=\"home\">\n");
      out.write("\n");
      out.write("    ");
      out.write("<div id=\"sideControl\">\r\n");
      out.write("\t<div id=\"blockDiv\">\r\n");
      out.write("\t\t<h5 class=\"sideControlHeader\">Block Creation</h5>\r\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\"Create\" onclick=\"territoryMap.startDrawingBlocks();\" />\r\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\"Finish\" onclick=\"territoryMap.finishDrawingBlocks();\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"printDiv\">\r\n");
      out.write("\t\t<h5 class=\"sideControlHeader\">Print Territory</h5>\r\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\"Print\" onclick=\"territoryMap.openPrintDialogue();\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"filterDiv\">\r\n");
      out.write("\t\t<h5 class=\"sideControlHeader\">View Filter</h5>\r\n");
      out.write("\t\t<select style=\"font-size: 11px;\" id=\"cboViewFilter\" class=\"ui-combobox ui-widget ui-state-default ui-corner-all\" >\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"coverageDiv\">\r\n");
      out.write("\t\t<h5 class=\"sideControlHeader\">Coverage</h5>\r\n");
      out.write("        <div class=\"datepicker datepicker-inline\"></div>\r\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\"Block View\" onclick=\"territoryMap.openBlockViewCoverage();\" />\r\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\"Chart View\" onclick=\"territoryMap.openChartViewCoverage();\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"viewFilterOptionTmpl\" style=\"display:none\">\r\n");
      out.write("<option value=\"{val}\">{Name}</option>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("    <div id=\"container\"></div>\n");
      out.write("    ");
      out.write("<div id=\"save_block_dialog_form\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-header\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">x</button>\n");
      out.write("    <h3 id=\"myModalLabel\">Save Block</h3>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"modal-body\">\n");
      out.write("    <form>\n");
      out.write("    \t<fieldset>\n");
      out.write("    \t\t<label for=\"block\">Block</label>\n");
      out.write("    \t\t<input type=\"text\" name=\"block\" id=\"block\" class=\"text ui-widget-content ui-corner-all\" />\n");
      out.write("    \t\t<label for=\"number\">Number</label>\n");
      out.write("    \t\t<input type=\"text\" name=\"number\" id=\"number\" class=\"text ui-widget-content ui-corner-all\" />\n");
      out.write("    \t</fieldset>\n");
      out.write("    \t</form>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"modal-footer\">\n");
      out.write("    <button id=\"btnCancelSaveBlock\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</button>\n");
      out.write("    <button id=\"btnSaveBlock\" class=\"btn btn-primary\">Save Block</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"save_record_dialog_form\" title=\"Write Record\">\n");
      out.write("\t<form>\n");
      out.write("\t<fieldset>\n");
      out.write("\t\t<label for=\"workDate\">Work Date</label>\n");
      out.write("\t\t<input type=\"text\" name=\"workDate\" id=\"workDate\" class=\"text ui-widget-content ui-corner-all\" />\n");
      out.write("\t\t<label for=\"personInitial\">Initial</label>\n");
      out.write("\t\t<input type=\"text\" name=\"initial\" id=\"initial\" class=\"text ui-widget-content ui-corner-all\" />\n");
      out.write("\t</fieldset>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"return_card_dialog_form\" title=\"Write Record\">\n");
      out.write("\t<form>\n");
      out.write("\t<fieldset>\n");
      out.write("\t\t<label for=\"cardReturnDate\">Card Return Date</label>\n");
      out.write("\t\t<input type=\"text\" name=\"returnDate\" id=\"returnDate\" class=\"text ui-widget-content ui-corner-all\" />\n");
      out.write("\t</fieldset>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"view_record_dialog\" title=\"View Record\">\n");
      out.write("\t<table id=\"record\">\n");
      out.write("\t    <thead>\n");
      out.write("\t    </thead>\n");
      out.write("\t    <tbody>\n");
      out.write("\n");
      out.write("\t    </tbody>\n");
      out.write("\t</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"print_dialog_form\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-header\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">x</button>\n");
      out.write("    <h3 id=\"myModalLabel\">Print Blocks</h3>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"modal-body\">\n");
      out.write("    <form>\n");
      out.write("        <fieldset id=\"printFieldSet\">\n");
      out.write("\n");
      out.write("   \t    </fieldset>\n");
      out.write("   \t</form>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"modal-footer\">\n");
      out.write("    <button id=\"btnCancelPrintBlocks\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</button>\n");
      out.write("    <button id=\"btnPrintBlocks\" class=\"btn btn-primary\">Print</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"printCheckTempl\">\n");
      out.write("\t<label class=\"printlabel\">\n");
      out.write("\t    <input type=\"checkbox\" name=\"{block}\" id=\"{blockName}^{blockNumber}\" class=\"printcheck\" />\n");
      out.write("        &nbsp;{block}\n");
      out.write("    </label>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"printHeaderTempl\">\n");
      out.write("\t<br><h2 class=\"printBlockHeader\">{blockName}</h2>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"display:none\" id=\"printOptionTempl\">\n");
      out.write("\t<div class=\"printBlockDiv\">\n");
      out.write("    <span class=\"printlabel\" >Select All</span>\n");
      out.write("    <input type=\"checkbox\" name=\"printAll\" id=\"printAll\" class=\"printcheck\" />\n");
      out.write("    <span class=\"printlabel\" >For Record</span>\n");
      out.write("    <input type=\"checkbox\" name=\"printOptionForRecord\" id=\"printOptionForRecord\" class=\"printcheckForOptionRecord\" />\n");
      out.write("    <span class=\"printlabel\" >For Overall</span>\n");
      out.write("    <input type=\"checkbox\" name=\"printOptionForOverall\" id=\"printOptionForOverall\" class=\"printcheckForOptionRecord\" />\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var territoryMap;\n");
      out.write("\n");
      out.write("        function initTerritoryMap() {\n");
      out.write("            var cong = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cong.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("            var zoomLevel = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cong.zoomLevel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("            var centerCoord = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cong.centerCoord}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("            territoryMap = new Territory.Map(cong, centerCoord, zoomLevel);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        $(document).ready(function(){\n");
      out.write("            setTimeout(\"initTerritoryMap();\", 500);\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("datePattern");
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_set_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_set_1.doInitBody();
      }
      do {
        if (_jspx_meth_fmt_message_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_set_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_set_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_fmt_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_set_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_set_1);
    _jspx_th_fmt_message_0.setKey("date.format");
    int _jspx_eval_fmt_message_0 = _jspx_th_fmt_message_0.doStartTag();
    if (_jspx_th_fmt_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_0);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_1.setParent(null);
    _jspx_th_fmt_message_1.setKey("mapMenu.title");
    int _jspx_eval_fmt_message_1 = _jspx_th_fmt_message_1.doStartTag();
    if (_jspx_th_fmt_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_1);
      return true;
    }
    _jspx_tagPool_fmt_message_key_nobody.reuse(_jspx_th_fmt_message_1);
    return false;
  }
}
