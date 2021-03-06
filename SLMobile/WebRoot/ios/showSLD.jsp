<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>show sld</title>
    
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<link rel="stylesheet" type="text/css" href="ios/style/sldshow.css">
<link rel="stylesheet" type="text/css" href="style/button.css">
<style type="text/css">
.table{
	margin:0 auto;
	border-collapse:collapse;
}
body{
	background-color:#ffffff;
}
</style>
  </head>
  
  <body>
    <header>
    	<a class="button button-rounded" class="click-button" href="/slmobile/ios/<%=request.getAttribute("pageList")%>?pageNow=${requestScope.pageNow}&uid=${requestScope.uid}">
    	<img class="btnimg" alt="" src="../slmobile/resource/back32.png">返回</a> 
    	&nbsp; 单据号${requestScope.sld.slddls }
    	<s:if test="#request.sld.rushRed=='冲红'">
    	&nbsp;&nbsp;<span style="color:red;font-size: 14px;">冲红</span>
   	 	</s:if>
    </header>
    
    <section>
	    	<table class="table">
				<tr>
					<td align="center"  colspan="6">
					<s:if test="#request.sld.free1=='shou'">
						(收)
					</s:if>
					<s:if test="#request.sld.free1=='fu'">
						(付)
					</s:if>
					<s:if test="#request.sld.free1=='zhuan'">
						(转)
					</s:if>
					<strong>款凭证</strong> 
					<strong>${requestScope.sld.gongsiId.name }公司</strong></td>
				</tr>
				<tr>
					<td><strong>部门:${requestScope.sld.bumen.bname }</strong> 
				</td>
					<td><strong>业务类型:${requestScope.sld.ywlx.yname}</strong>
 					</td>
					<td>
						<strong>对应科目:${requestScope.sld.dykm}</strong>
					</td>
					<td>
						<strong>明细科目:${requestScope.sld.mxkm}</strong>
					</td> 
				</tr>
			</table>
			<table class="table" style="height: 53px;" >
				<tr>
					<td align="right"
						style="width:12.5%;border-left: 2px solid #000000;  border-top: 2px solid #000000; border-bottom: 1px solid #000000; font-size:small; "	class="style1">
						<s:if test="#request.sld.free2=='shou'">
						(收)
						</s:if>
						<s:if test="#request.sld.free2=='fu'">
						(付)
						</s:if>
						<s:if test="#request.sld.free2=='duei'">
						(对)
						</s:if>
					</td>
						
					<td height="40px"
						style="width:12.6%; border-right: 1px solid #000000; border-top: 2px solid #000000; border-bottom: 1px solid #000000; font-size:small; "
						align="left" class="style4">款单位</td>
					<td style="border-right: 1px solid #000000; border-top: 2px solid #000000; border-bottom: 1px solid #000000;
						text-align:left; padding-left:5px;">
						<s:property value='#request.sld.sfkdw'/>
					</td>
					<td
						style="border-right: 1px solid #000000; border-top: 2px solid #000000; border-bottom: 1px solid #000000; font-size:small; "
						class="style8" align="center">币种</td>
					<td
						style="border-right: 1px solid #000000; border-top: 2px solid #000000; border-bottom: 1px solid #000000;width:100px;">
						${requestScope.sld.bizhong.bzname }
					</td>
					<td
						style="border-right: 1px solid #000000; border-top: 2px solid #000000; border-bottom: 1px solid #000000; font-size:small;"
						class="style9" align="center">票号</td>
					<td
						style="border-right:2px solid black; border-top: 2px solid #000000; border-bottom: 1px solid #000000;width:100px;">
						<s:property value='#request.sld.piaohao'/>
					</td>
				</tr>
			</table>
			
			
			<table class="table">
					<tr>
						<td align="center"
							style=" width:25%;border-left: 2px solid #000000;border-right: 1px solid #000000;"
							class="style5">金额</td>		
						<td  align="left" height="40px"
							style="border-right: 2px solid #000000;">
							<s:property value='#request.sld.jine'/>
						</td>
					</tr>
			</table>
			<!-- 
			<table class="table">
			<tr>
				<td rowspan="2" style=" border:solid 1px; border-left-style:solid; border-left-width:2px;" >
					金额(大写)：

					<input  align="left" type="text" readonly="readonly" id="moneyok"  style="text-align:left ;width:470px ;height:40px;border-style: hidden; border-width: 0px; font-size: 20px; font-weight: bold;">       
					</td>
				<td
					style="font-size:small;width:50px; border-bottom-style: solid ; border-bottom-width: 1px; border-bottom-color: #000000; border-top-style:solid; border-top-width:1px;"
					rowspan="2">小写</td>

				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">亿</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">千</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">百</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">十</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">万</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">千</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">百</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">十</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">元</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000;"
					align="center">角</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-right-style:solid; border-right-width:2px; "
					align="center">分</td>
			</tr>
			<tr>
				<td height="25px"
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m11"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m10"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m9"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m8"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m7"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m6"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m5"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m4"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m3"></span>
					</td>
				<td
					style="width:20px;font-size:small; border-left-style: solid; border-left-width: 1px; border-left-color: #000000; border-top-style: solid; border-top-width: 1px; border-top-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;"
					align="center">
						<span id="m2"></span>
					</td>
				<td
					style="border-style: solid; border-width: 1px 2px 1px 1px; border-color: #000000; width:20px; font-size:smaller; "
					align="center">
						<span id="m1"></span>
					</td>
			</tr>
		</table>
		 -->
			
	
			<table class="table">
				<tr>
					<td
						style="width:50px; border-left:2px solid black; border-top:1px solid black;">
						摘要:</td>
					<td
						style="border-bottom:1px solid black; border-right:2px solid black; border-top:1px solid black;
						text-align:left; border-left:1px solid black;" rowspan="5" valign="top">
						<textarea rows="6" style="margin:1px; width:98%;" readonly="readonly"><s:property value="#request.sld.zhaiyao"/></textarea>
					</td>
					
				</tr>
				<tr>
					<td align="left" style="border-left-style: solid; border-left-width: 2px; border-left-color: #000000; ">
						&nbsp;</td>
				</tr>
				<tr>
					<td align="left"
						style="border-left-style: solid; border-left-width: 2px; border-left-color: #000000;">
						&nbsp;</td>
				</tr>
				<tr>
					<td align="left"
						style="border-left-style: solid; border-left-width: 2px; border-left-color: #000000;">
						&nbsp;</td>
				</tr>
				<tr>
					<td align="left"
						style="border-left-style: solid; border-left-width: 2px; border-left-color: #000000; border-bottom-style: solid; border-bottom-width: 1px; border-bottom-color: #000000;">
						&nbsp;</td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<td
						style="border-left: 2px solid #000000; border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller;"
						class="style6" align="center"><span ID="Label5">本部经理</span>
					</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style6" align="center">
						<s:iterator value="#request.electronName">
						 <s:if test="auditingPlace=='本部经理'">
								<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
								<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
						</s:if> 
						</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" />-->
						
						</td> 
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller;"
						class="style6" align="center">
						<span>本部财务</span></td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style6" align="center">
						<s:iterator value="#request.electronName">
							<s:if test="auditingPlace=='本部财务'">
								<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
									<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
							</s:if> 
						</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" />  -->
						<!-- <input type="hidden" value="未审核"> -->
						
						</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller;"
						class="style6" align="center">
						
						<span>本部审核</span></td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style6" align="center">
						<s:iterator value="#request.electronName">
							<s:if test="auditingPlace=='本部审核'">
								<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
									<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
							</s:if> 
						</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" /> -->
						</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 1px solid #000000; font-size:smaller;"
						class="style6" align="center">
						
						<span>本部经办</span></td>
					<td
						style="border-right: 2px solid #000000; border-bottom: 1px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style6" align="center">
						<s:iterator value="#request.electronName">
							<s:if test="auditingPlace=='本部经办'">
								<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
									<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
							</s:if> 
						</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" /> -->
						</td>
				</tr>
				<tr>
					<td
						style="border-left: 2px solid #000000; border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller;"
						class="style7" align="center">
						
						<span>总裁</span></td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style7" align="center">
					<s:iterator value="#request.electronName">
						<s:if test="auditingPlace=='总裁'">
							<s:property value="auditingName"/>
							<s:if test="isProxy!=null">
								<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
							</s:if>
								<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
						</s:if> 
					</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" /> -->
						</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller;"
						class="style7" align="center">
					
						<span>资产经理</span></td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style7" align="center">
						<s:iterator value="#request.electronName">
							<s:if test="auditingPlace=='资产经理'">
								<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
									<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
							</s:if> 
						</s:iterator>
						<!-- <img ID="Image1" width="30px" Height="20px" /> -->
						</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller;"
						class="style7" align="center">
					
						<span>资产审核</span></td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style7" align="center">
					<s:iterator value="#request.electronName">
						<s:if test="auditingPlace=='资产审核'">
							<s:property value="auditingName"/>
							<s:if test="isProxy!=null">
								<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
							</s:if>
								<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
						</s:if> 
					</s:iterator>
						
					</td>
					<td
						style="border-right: 1px solid #000000; border-bottom: 2px solid #000000; font-size:smaller;"
						class="style7" align="center">
						<span>资金审核</span></td>
					<td
						style="border-right: 2px solid #000000; border-bottom: 2px solid #000000; font-size:smaller; width: 90px;height: 30px;"
						class="style7" align="center">
					<s:iterator value="#request.electronName">
						<s:if test="auditingPlace=='资金审核'">
							<s:property value="auditingName"/>
								<s:if test="isProxy!=null">
									<span style="color:red;font-weight: bold;"><s:property value="isProxy"/>:</span>
								</s:if>
								<img alt="电子签名"  src="electronName/<s:property value="auditingPeople"/>" width="30px;" height="20px;">
						</s:if> 
					</s:iterator>
					</td>
				</tr>
			</table>
			
		
	    	<table class="opinionTable">
	    	<thead>
			<tr>
				<!-- <td>审批的级别</td>
				<td>审批的状态</td> -->
				<td>审批人</td>
				<td>审批的意见</td>
				<td>审批的时间</td>
			</tr>
			</thead>
			<s:if test="#request.opinion != null">
				<s:iterator value="#request.opinion">
					<tbody>
						<tr height="20px;">	
						<%-- 	<td><s:property value="lvl"/></td>
							<td><s:property value="yjname"/></td> --%>
							<td><s:property value="yijianExamineName.uname"/></td>
							<td><s:property value="yjcontent"/></td>
							<td><s:property value="ts"/></td>
						</tr>
					</tbody>
			    </s:iterator>
			</s:if>
			<s:else>
				<tr height="20px;">
					<td colspan="5" style="text-align: center;"><span style="color:red;">无审批意见，您是第一级别</span></td>
				</tr>
			</s:else>
			</table>
			
    </section>
    
    <footer>
    	<br>
    </footer>
    
  </body>
</html>
