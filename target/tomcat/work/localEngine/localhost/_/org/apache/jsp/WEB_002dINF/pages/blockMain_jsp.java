package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class blockMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/pages/sidecontrol.jsp");
    _jspx_dependants.add("/common/dialog.jsp");
    _jspx_dependants.add("/WEB-INF/appfuse.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
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

      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("<head>\n");
      out.write("    <title>");
      if (_jspx_meth_fmt_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("    <meta name=\"menu\" content=\"MainMenu\"/>\n");
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
      out.write("<div id=\"container\"></div>\n");
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
      out.write("\t<span class=\"printlabel\">{block}</span>\n");
      out.write("\t<input type=\"checkbox\" name=\"{block}\" id=\"{blockName}^{blockNumber}\" class=\"printcheck\" />\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("        var territoryMap;\n");
      out.write("\n");
      out.write("\n");
      out.write("        function initTerritoryMap() {\n");
      out.write("            var cong = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cong.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\n");
      out.write("            var zoomLevel = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cong.zoomLevel}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\n");
      out.write("            var centerCoord = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cong.centerCoord}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /common/taglibs.jsp(16,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /common/taglibs.jsp(16,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/common/taglibs.jsp(16,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /common/taglibs.jsp(17,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("datePattern");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_005fset_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_005fset_005f1.doInitBody();
      }
      do {
        if (_jspx_meth_fmt_005fmessage_005f0(_jspx_th_c_005fset_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fset_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fset_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fset_005f1);
    // /common/taglibs.jsp(17,25) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f0.setKey("date.format");
    int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f1.setParent(null);
    // /WEB-INF/pages/blockMain.jsp(4,11) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fmessage_005f1.setKey("blockMenu.title");
    int _jspx_eval_fmt_005fmessage_005f1 = _jspx_th_fmt_005fmessage_005f1.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
    return false;
  }
}
