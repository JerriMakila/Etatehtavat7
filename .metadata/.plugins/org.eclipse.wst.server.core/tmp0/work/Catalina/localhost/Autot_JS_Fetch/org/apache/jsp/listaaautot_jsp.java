/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-11-29 21:10:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listaaautot_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("<script src=\"scripts/main.js\"></script>\r\n");
      out.write("<title>Auto-ohjelma</title>\r\n");
      out.write("<style>\r\n");
      out.write(".oikealle{\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onkeydown=\"tutkiKey(event)\">\r\n");
      out.write("<table id=\"listaus\">\r\n");
      out.write("\t<thead>\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan=\"4\" id=\"ilmo\"></th>\r\n");
      out.write("\t\t\t<th><a id=\"uusiAuto\" href=\"lisaaauto.jsp\">Lisää uusi auto</a></th>\r\n");
      out.write("\t\t</tr>\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th class=\"oikealle\">Hakusana:</th>\r\n");
      out.write("\t\t\t<th colspan=\"3\"><input type=\"text\" id=\"hakusana\"></th>\r\n");
      out.write("\t\t\t<th><input type=\"button\" value=\"hae\" id=\"hakunappi\" onclick=\"haeTiedot()\"></th>\r\n");
      out.write("\t\t</tr>\t\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Rekisterinumero</th>\r\n");
      out.write("\t\t\t<th>Merkki</th>\r\n");
      out.write("\t\t\t<th>Malli</th>\r\n");
      out.write("\t\t\t<th>Vuosi</th>\r\n");
      out.write("\t\t\t<th></th>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody id=\"tbody\">\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("haeTiedot();\t\r\n");
      out.write("document.getElementById(\"hakusana\").focus();//viedään kursori hakusana-kenttään sivun latauksen yhteydessä\r\n");
      out.write("\r\n");
      out.write("function tutkiKey(event){\r\n");
      out.write("\tif(event.keyCode==13){//Enter\r\n");
      out.write("\t\thaeTiedot();\r\n");
      out.write("\t}\t\t\r\n");
      out.write("}\r\n");
      out.write("//Funktio tietojen hakemista varten\r\n");
      out.write("//GET   /autot/{hakusana}\r\n");
      out.write("function haeTiedot(){\t\r\n");
      out.write("\tdocument.getElementById(\"tbody\").innerHTML = \"\";\r\n");
      out.write("\tfetch(\"autot/\" + document.getElementById(\"hakusana\").value,{//Lähetetään kutsu backendiin\r\n");
      out.write("\t      method: 'GET'\r\n");
      out.write("\t    })\r\n");
      out.write("\t.then(function (response) {//Odotetaan vastausta ja muutetaan JSON-vastaus objektiksi\r\n");
      out.write("\t\treturn response.json()\t\r\n");
      out.write("\t})\r\n");
      out.write("\t.then(function (responseJson) {//Otetaan vastaan objekti responseJson-parametrissä\t\t\r\n");
      out.write("\t\tvar autot = responseJson.autot;\t\r\n");
      out.write("\t\tvar htmlStr=\"\";\r\n");
      out.write("\t\tfor(var i=0;i<autot.length;i++){\t\t\t\r\n");
      out.write("        \thtmlStr+=\"<tr>\";\r\n");
      out.write("        \thtmlStr+=\"<td>\"+autot[i].rekno+\"</td>\";\r\n");
      out.write("        \thtmlStr+=\"<td>\"+autot[i].merkki+\"</td>\";\r\n");
      out.write("        \thtmlStr+=\"<td>\"+autot[i].malli+\"</td>\";\r\n");
      out.write("        \thtmlStr+=\"<td>\"+autot[i].vuosi+\"</td>\";  \r\n");
      out.write("        \thtmlStr+=\"<td><a href='muutaauto.jsp?rekno=\"+autot[i].rekno+\"'>Muuta</a>&nbsp;\";\r\n");
      out.write("        \thtmlStr+=\"<span class='poista' onclick=poista('\"+autot[i].rekno+\"')>Poista</span></td>\";\r\n");
      out.write("        \thtmlStr+=\"</tr>\";        \t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"tbody\").innerHTML = htmlStr;\t\t\r\n");
      out.write("\t})\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//Funktio tietojen poistamista varten. Kutsutaan backin DELETE-metodia ja välitetään poistettavan tiedon id. \r\n");
      out.write("//DELETE /autot/id\r\n");
      out.write("function poista(rekno){\r\n");
      out.write("\tif(confirm(\"Poista auto \" + rekno +\"?\")){\t\r\n");
      out.write("\t\tfetch(\"autot/\"+ rekno,{//Lähetetään kutsu backendiin\r\n");
      out.write("\t\t      method: 'DELETE'\t\t      \t      \r\n");
      out.write("\t\t    })\r\n");
      out.write("\t\t.then(function (response) {//Odotetaan vastausta ja muutetaan JSON-vastaus objektiksi\r\n");
      out.write("\t\t\treturn response.json()\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t.then(function (responseJson) {//Otetaan vastaan objekti responseJson-parametrissä\t\t\r\n");
      out.write("\t\t\tvar vastaus = responseJson.response;\t\t\r\n");
      out.write("\t\t\tif(vastaus==0){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"ilmo\").innerHTML= \"Auton poisto epäonnistui.\";\r\n");
      out.write("\t        }else if(vastaus==1){\t        \t\r\n");
      out.write("\t        \tdocument.getElementById(\"ilmo\").innerHTML=\"Auton \" + rekno +\" poisto onnistui.\";\r\n");
      out.write("\t\t\t\thaeTiedot();        \t\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\tsetTimeout(function(){ document.getElementById(\"ilmo\").innerHTML=\"\"; }, 5000);\r\n");
      out.write("\t\t})\t\t\r\n");
      out.write("\t}\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
